import java.awt.Graphics2D; // provide more control over geometry, coordinate transformations, color management, and text layout.
import java.awt.image.BufferedImage; //handle + manipulate image data
import java.awt.Point; //two dimensional coordinate space (x,y) - (int,int)
import java.awt.Color; //creates color by RGBA (Red, Green, Blue, Alpha)

// NOTES : AWT stands for Abstract Window Toolkit ---

public class gui
{
   // 'final' means the variable can't be changed until the session done
    public static final int blue = 1;
    public static final int red = 2;
    public static final int yellow = 3;
    public static final int green = 4;

    public static Color bcolor = new Color(192, 192, 192); // b = background
    public static Color linecolor = new Color(105, 105, 105);

    // 'final' declares the window/value size is constant (NOT resizeable)
    public static final int res = 640; //pixels

    public static String error = "Wrong move! Try Again!"; //error popup

    private int[][] grid;
    private int[][] overlay;

    public gui() {
        grid = new int[20][20];
        overlay = new int[20][20];
    }

    public boolean validmove(playerpieces pp, int xCoor, int yCoor) throws IllegalMoveException {
        boolean corner = false;

        for (int x = 0; x < playerpieces.piece_size; x++) {
            for (int y = 0; y < playerpieces.piece_size; y++) { // shape in-grid coordinate x dan y

                int shapevalue = pp.callValue(x, y); // shape-value, call value shape dari playerpieces

                boolean inGrid = InGrid(x + xCoor, y + yCoor);
                if (inGrid) {
                    int gridValue = grid[x + xCoor][y + yCoor];

                    if (gridValue != 0) {
                        if (shapevalue == playerpieces.piecevalue) {
                            throw new IllegalMoveException(error); // [universal rules] kalo ketiban antara dengan value 3, error.
                        }
                        if (gridValue == pp.callColor()) { // [dengan syarat warna playerpieces harus sama] karena bisa aja berhimpitan dengan shape lawan
                            if (shapevalue == playerpieces.adjacentvalue) {
                                throw new IllegalMoveException(error); // kalo ketiban antara 1,2,3 dan 2, error juga.
                            }
                            if (shapevalue == playerpieces.cornervalue) { // warna sama, dan nilai sama-sama 1, maka true hasilnya
                                corner = true;
                            }
                        }
                    }
                    else {
                        if (shapevalue == playerpieces.piecevalue&& new Point(x + xCoor, y + yCoor).equals(firstPlacement(pp.callColor())))
                            corner = true; // placement pertama, tempat first placement udah ditentukan dari class firstPlacement sesuai warna
                    }
                }
                else {
                    if (shapevalue == playerpieces.piecevalue) throw new IllegalMoveException(error); // kalo ketiban, error
                }
            }
        }
        if (!corner) throw new IllegalMoveException(error); // kalo gak nilainya gak sama-sama 1 each shape connected, maka gak valid

        return true; // loop(ulang penempatan shape)
    }


    public void placement(playerpieces pp, int xset, int yset) throws IllegalMoveException {
        validmove(pp, xset, yset); // as long as itu valid, maka

        for (int x = 0; x < playerpieces.piece_size; x++) {
            for (int y = 0; y < playerpieces.piece_size; y++) {
                if (pp.callValue(x, y) == playerpieces.piecevalue) {
                    grid[x + xset][y + yset] = pp.callColor(); // replace grid ditambah warna.
                }
            }
        }
    }

    public Point callPixels(Point pixel, int res) { // untuk mouse motion si cursor juga
        return new Point(pixel.x / (res / 20 ), pixel.y / (res / 20));
    }

    public void overlay(playerpieces pp, int xCur, int yCur) {
        reset(overlay); // biar dia gak kyk draw di grid nya. langsung ke-reset jadi grid pada awalnya.

        for (int x = 0; x < playerpieces.piece_size; x++) {
            for (int y = 0; y < playerpieces.piece_size; y++) {
                if (InGrid(x + xCur - playerpieces.piece_size / 2, y + yCur - playerpieces.piece_size / 2) && pp.callValue(x, y) == playerpieces.piecevalue) {
                    overlay[x + xCur - playerpieces.piece_size / 2][y + yCur - playerpieces.piece_size / 2] = pp.callColor(); // buat mousemotion (yang ngikutin cursor)
                }
            }
        }
    }

    public BufferedImage render() { return render(res); }

    public BufferedImage render(int size)
    {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        int PiecePixel = size / (20); // dibagi jadi satuan
        Graphics2D g = (Graphics2D) image.getGraphics();

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                g.setColor(callColor(grid[x][y]));
                if (overlay[x][y] != 0) {
                    g.setColor(blend(g.getColor(), callColor(overlay[x][y]), 0.1f));
                }
                g.fillRect(x * PiecePixel, y * PiecePixel, PiecePixel, PiecePixel); // background warna abu2
                g.setColor(linecolor);
                g.drawRect(x * PiecePixel, y * PiecePixel, PiecePixel, PiecePixel); // garis 20x20
            }
        }
        return image;
    }

    private Color blend(Color c1, Color c2, float balance) { // kenapa harus ada balance? bingung sendiri gue.
        int r = (int)(c1.getRed() * balance + c2.getRed() * (1 - balance));
        int g = (int)(c1.getGreen() * balance + c2.getGreen() * (1 - balance));
        int b = (int)(c1.getBlue() * balance + c2.getBlue() * (1 - balance));
        return new Color(r, g, b);
    }

    private void reset(int[][] array) { // reset overlay sebelumnya
        for (int x = 0; x < 20; x++)
            for (int y = 0; y < 20; y++)
                array[x][y] = 0;
    }

    private boolean InGrid(int x, int y) {
        return (x >= 0 && y >= 0 && x < 20 && y < 20);
        // x greater than 0, y greater than 0
        // x below than 20, y below than 20
        // && = returns true if both statements are true
    }

    private Point firstPlacement(int bycolor) { // to make sure every each player place their pieces by the selected corner
        switch (bycolor) {
            case blue: return new Point(19, 0); // coordinate every each color
            case green: return new Point(0, 19);
            case yellow: return new Point(20 - 1, 19);
            case red: return new Point(0, 0);

            default: throw new IllegalArgumentException(); // return statement
        }
        // drawrect
    }

    public static Color callColor(int color) { // each player has different color
        switch (color) {
            case blue: return Color.blue;
            case red: return Color.red;
            case yellow: return Color.yellow;
            case green: return new Color(0, 128, 0);
            default: return bcolor;
        }
    }

    public static String getColorName(int color)
    {
        switch (color)
        {
            case blue: return "Blue";
            case red: return "Red";
            case yellow: return "Yellow";
            case green: return "Green";
            default: return "Unknown";
        }
    }

    public static class IllegalMoveException extends Exception {
        public IllegalMoveException(String message) {
            super(message);
        }
    }
}
