import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

public class playerpieces {
    public static final int piece_size = 7; //alasan bukan 5, untuk rotationnya
    public static final int piecevalue = 3;
    public static final int adjacentvalue = 2;
    public static final int cornervalue = 1;
    private static int type = 21;
    public int j = 0;


    public static final int res = 120;
    public static final Random random = new Random();

    private int[][] grid;
    private int color;

    public playerpieces(int[][] shape, int color) {
        grid = shape.clone(); // buat bufferedimage
        this.color = color;
    }

    public void rotatecpieces() {
        int i = playerpieces.piece_size;
        int[][] temp = new int[i][i];

        for (int x = 0; x < i; x++)
            for (int y = 0; y < i; y++)
                temp[i - y - 1][x] = grid[x][y];

        grid = temp;
    }

    public void rotateccpieces() {
        int i = playerpieces.piece_size;
        int[][] temp = new int[i][i];

        for (int x = 0; x < i; x++)
            for (int y = 0; y < i; y++)
                temp[y][i - x - 1] = grid[x][y];

        grid = temp;
    }

    public void hflippieces() {
        int i = piece_size;
        int[][] temp = new int[i][i];

        for (int x = 0; x < i; x++)
            for (int y = 0; y < i; y++)
                temp[i - x - 1][y] = grid[x][y];

        grid = temp;
    }

    public void vflippieces() {
        //Don't know this one yet
        int i = piece_size;
        int[][] temp = new int[i][i];

        for (int x = 0; x < i; x++)
            for (int y = 0; y < i; y++)
                temp[x][i - y - 1] = grid[x][y];

        grid = temp;
    }

    public int callValue(int x, int y) {
        return grid[x][y];
    } // callback to other classes (not ruin the syntax)

    public int callColor() {
        return color;
    } // callback to other classes (not ruin the syntax)

    public BufferedImage render(int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        int PiecePixel = size / (playerpieces.piece_size);
        Graphics2D g = (Graphics2D) image.getGraphics();

        g.setColor(Color.black);
        // g.fillRect(0, 0, size, size);

        for (int x = 0; x < playerpieces.piece_size; x++) {
            for (int y = 0; y < playerpieces.piece_size; y++) {
                if (grid[x][y] == piecevalue) {
                    g.setColor(gui.callColor(color));
                    g.fillRect(x * PiecePixel, y * PiecePixel, PiecePixel, PiecePixel);
                    g.setColor(Color.black);
                    g.drawRect(x * PiecePixel, y * PiecePixel, PiecePixel, PiecePixel);
                }
            }
        }
        return image;
    }

    public int score() {
        int score = 0;
        for (int y = 0; y < piece_size; y++)
            for (int x = 0; x < piece_size; x++)
                if (grid[x][y] == piecevalue) score++;
        return score;
    }

    public static int[][][] AllPieces() {
        int[][][] pieceshape = new int[type][piece_size][piece_size];
        int i = 0;
        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0},
                {0, 1, 2, 3, 2, 2, 1},  //   *
                {0, 2, 3, 3, 3, 3, 2},  // * * * *
                {0, 1, 2, 2, 2, 2, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 2, 2, 2, 1, 0},
                {0, 2, 3, 3, 3, 2, 0},  // * * *
                {0, 1, 2, 2, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };


        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 2, 3, 2, 1, 0},  // *
                {0, 0, 2, 3, 3, 2, 0},  // * *
                {0, 0, 1, 2, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 2, 2, 2, 2, 2, 1},
                {2, 3, 3, 3, 3, 3, 2},  // * * * * *
                {1, 2, 2, 2, 2, 2, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 2, 1, 0, 0, 0},
                {0, 2, 3, 2, 2, 2, 1},  // *
                {0, 2, 3, 3, 3, 3, 2},  // * * * *
                {0, 1, 2, 2, 2, 2, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 2, 3, 2, 1, 0},  // *
                {0, 0, 2, 3, 3, 2, 0},  // * *
                {0, 0, 1, 2, 3, 2, 0},  //   *
                {0, 0, 0, 1, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0},
                {0, 1, 2, 3, 2, 1, 0},  //   *
                {0, 2, 3, 3, 3, 2, 0},  // * * *
                {0, 1, 2, 2, 3, 2, 0},  //     *
                {0, 0, 0, 1, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0},
                {0, 1, 2, 3, 2, 1, 0},  //   *
                {0, 2, 3, 3, 3, 2, 0},  // * * *
                {0, 1, 2, 3, 2, 1, 0},  //   *
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 2, 2, 2, 1, 0},
                {0, 2, 3, 3, 3, 2, 0},  // * * *
                {0, 2, 3, 2, 3, 2, 0},  // *   *
                {0, 1, 2, 1, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 2, 2, 2, 1, 0},
                {0, 2, 3, 3, 3, 2, 0},  // * * *
                {0, 1, 2, 3, 3, 2, 0},  //   * *
                {0, 0, 1, 2, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 2, 1, 0},
                {0, 0, 1, 2, 3, 2, 0},  //     *
                {0, 1, 2, 3, 3, 2, 0},  //   * *
                {0, 2, 3, 3, 2, 1, 0},  // * *
                {0, 1, 2, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 2, 3, 2, 0, 0},  //   *
                {0, 1, 2, 3, 2, 1, 0},  //   *
                {0, 2, 3, 3, 3, 2, 0},  // * * *
                {0, 1, 2, 2, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        pieceshape[i++] = new int[][]{
                {0, 0, 1, 2, 1, 0, 0},
                {0, 0, 2, 3, 2, 0, 0},  // *
                {0, 0, 2, 3, 2, 2, 1},  // *
                {0, 0, 2, 3, 3, 3, 2},  // * * *
                {0, 0, 1, 2, 2, 2, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 2, 1, 0},
                {0, 0, 2, 3, 3, 2, 0},  //   * *
                {0, 1, 2, 3, 2, 1, 0},  //   *
                {0, 2, 3, 3, 2, 0, 0},  // * *
                {0, 1, 2, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 2, 1, 0},
                {0, 1, 2, 3, 3, 2, 0},  //   * *
                {0, 2, 3, 3, 2, 1, 0},  // * *
                {0, 1, 2, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        pieceshape[i++] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 2, 2, 1, 0, 0},
                {0, 2, 3, 3, 2, 0, 0},  // * *
                {0, 2, 3, 3, 2, 0, 0},  // * *
                {0, 1, 2, 2, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        pieceshape[i++] = new int[][]{ // *
                {0, 0, 0, 0, 0, 0, 0}, // * * *
                {0, 0, 1, 2, 1, 0, 0},
                {0, 1, 2, 3, 2, 1, 0},
                {0, 2, 3, 3, 3, 2, 0},
                {0, 1, 2, 2, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        pieceshape[i++] = new int[][]{ //   *
                {0, 0, 0, 0, 0, 0, 0}, // * * *
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 2, 2, 2, 2, 0},
                {0, 2, 3, 3, 3, 2, 0},
                {0, 1, 2, 2, 3, 2, 0},
                {0, 0, 0, 1, 2, 1, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };

       return pieceshape;
    }
}