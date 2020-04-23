import javax.swing.*; //  the ability to create gui components (buttons and scroll bars, etc)
import java.awt.event.*; // defines classes and interfaces used for event handling in the AWT and Swing
import java.awt.*; // AWT stands for Abstract Window Toolkit
import java.util.Random;

public class main
{
    public static class mainframe extends JFrame
    {
        private gui board;
        private final int totalplayers = 4;
        private players[] players;
        private int turn = -1; //starts from zero
        private ImageIcon boardimage; // creates an uninitialized image icon.
        private Point selection; // point representing a location (this one for chosen one)
        private int value; // value of every each coordinate
        private JLabel display; // blank space to display text or image

        public int scorebasedround = -2;
        public int score1 = 0;
        public int score2 = 0;
        public int score3 = 0;
        public int score4 = 0;

        private JPanel piecewindow;

        public mainframe() {
            players = new players[totalplayers]; // blokus must be 4 players

            players[0] = new players(gui.red); // player one has red pieces
            players[1] = new players(gui.blue); // player two has blue pieces
            players[2] = new players(gui.yellow);
            players[3] = new players(gui.green);

            board = new gui();

            run_blokus(); // start run the program
            next_turn(); // keep the program run while the players change turn

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // preventing the program keep running in background even it closed
        }

        private void run_blokus() {
            class movement implements MouseListener, MouseMotionListener, MouseWheelListener {
                // mouse listener : left-click(BUTTON1), middle-click(BUTTON2), right-click(BUTTON3)
                // mouse motion listener : the pointer of mouse when it's moved either dragged
                // mouse wheel listener : scroll-up (x>1), scroll-down (x<1)

                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        hflip(); // flip the piece
                    }


                    else {
                        try {
                            board.placement(players[turn].pieces.get(value), selection.x - playerpieces.piece_size / 2,
                                    selection.y - playerpieces.piece_size / 2);
                            placepiece(); // piece saved on the coordinate chosen (x,y)
                            players[turn].pieces.remove(value); // changing the shape after player's turn done
                            next_turn();
                        }
                        catch (gui.IllegalMoveException em) { // em = error message
                            popup(em.getMessage());
                        }
                    }   // NOTE TO SELF : try and catch keywords come in pairs!! :")
                }

                public void mouseMoved(MouseEvent e) {
                    Point p = board.callPixels(e.getPoint(), gui.res); // following the resolution of the board
                    if (!p.equals(selection)) {
                        selection = p;
                        board.overlay(players[turn].pieces.get(value), selection.x, selection.y); //
                        placepiece();
                    }
                }

                public void mouseWheelMoved(MouseWheelEvent e) {
                    int d = e.getWheelRotation();
                    if (d > 0) { // d > 0 = scroll-up
                        rotatec(); // if its scrolled up, then rotate clockwise
                    }
                    else { // d < 0 = scroll-down
                        rotatecc(); // if its scrolled-down, then rotate in different direction
                    }
                }

                public void mousePressed(MouseEvent e) { // formalitas
                }
                public void mouseReleased(MouseEvent e) { // formalitas
                }
                public void mouseExited(MouseEvent e) { // formalitas
                }
                public void mouseDragged(MouseEvent e) { // formalitas
                }
                public void mouseEntered(MouseEvent e) { // formalitas
                }

            }

            // Buttonlistener
            class rotatebuttonListener implements ActionListener {
                public void actionPerformed(ActionEvent event) { rotatec();
                }
            }
            class surrenderbuttonListener implements ActionListener {
                public void actionPerformed(ActionEvent event) { surrender();}
            }
            class hflipbuttonListener implements ActionListener {
                public void actionPerformed(ActionEvent event) {
                    hflip();
                }
            }
            class vflipbuttonListener implements ActionListener {
                public void actionPerformed(ActionEvent event) {
                    vflip();
                }
            }
            class nextpieceListener implements ActionListener {
                public void actionPerformed(ActionEvent e) { nextpiece(); }
            }


            //=================================================================================================//

            final JPanel mainwindow; mainwindow = new JPanel(); // weird syntax, still trying to configure this
            final JPanel sidewindow; sidewindow = new JPanel();
            final JPanel boardwindow; boardwindow = new JPanel();
            final JPanel textwindow; textwindow = new JPanel();

            // pieces layout
            piecewindow = new JPanel();
            piecewindow.setLayout(new BoxLayout(piecewindow, BoxLayout.PAGE_AXIS));

            // LABER FOR BUTTONS
            JButton rotatebutton = new JButton("Rotate");
            JButton surrenderbutton = new JButton("Surrender");
            JButton hflipbutton = new JButton("H-Flip");
            JButton vflipbutton = new JButton("V-Flip");
            JButton nextpiecebutton = new JButton("-blank feature-");

            JScrollPane pieceslayout = new JScrollPane(piecewindow);

            // PIECES PLACEMENT
            pieceslayout.getVerticalScrollBar().setUnitIncrement(playerpieces.res / 3);
            pieceslayout.setPreferredSize(new Dimension(playerpieces.res, gui.res-100));

            // BUTTON PLACEMENT
            rotatebutton.addActionListener(new rotatebuttonListener());
            surrenderbutton.addActionListener(new surrenderbuttonListener());
            hflipbutton.addActionListener(new hflipbuttonListener());
            vflipbutton.addActionListener(new vflipbuttonListener());
            nextpiecebutton.addActionListener(new nextpieceListener());

            JLabel redscore = new JLabel("Red: " + score1);
            JLabel bluescore = new JLabel("Blue: " + score2);
            JLabel yellowscore = new JLabel("Yellow: " + score3);
            JLabel greenscore = new JLabel("Green: " + score4);

            sidewindow.setLayout(new BoxLayout(sidewindow, BoxLayout.PAGE_AXIS));

            boardimage = new ImageIcon(board.render()); // board (gui) rendering

            movement mvmt = new movement(); // mouse feature

            // see display like a canvas in photoshop
            display = new JLabel(boardimage);

            display.addMouseListener(mvmt); // clicking feature
            display.addMouseMotionListener(mvmt); // shapes below the cursor feature
            display.addMouseWheelListener(mvmt); // mouse rotation

            boardwindow.add(display);

            // ADD ADD AND ADD
            sidewindow.add(rotatebutton);
            sidewindow.add(vflipbutton);
            sidewindow.add(hflipbutton);
            sidewindow.add(surrenderbutton);
            sidewindow.add(nextpiecebutton);
            mainwindow.add(pieceslayout);

            sidewindow.add(redscore);
            redscore.setText("1. you can choose your own piece from the lists");
            sidewindow.add(bluescore);
            bluescore.setText("2. can't refresh the score in the label. idk why");
            sidewindow.add(yellowscore);
            yellowscore.setText("3. enjoy the game. ");
            sidewindow.add(greenscore);
            greenscore.setText("4. score will appears after player surrender.");

            mainwindow.add(sidewindow);
            mainwindow.add(boardwindow); // board of the blokus

            getContentPane().add(mainwindow); // JPanel is a container, need to add panel to the container to be shown
            setVisible(true); // a blocking operation and blocks until dialog is closed.
        }

        // FUNCTION!!
        private void rotatec() {
            players[turn].pieces.get(value).rotatecpieces();
            board.overlay(players[turn].pieces.get(value), selection.x, selection.y);
            placepiece();
        }
        private void rotatecc() {
            players[turn].pieces.get(value).rotateccpieces();
            board.overlay(players[turn].pieces.get(value), selection.x, selection.y);
            placepiece();
        }

        private void hflip() {
            players[turn].pieces.get(value).hflippieces();
            board.overlay(players[turn].pieces.get(value), selection.x, selection.y);
            placepiece();
        }
        private void vflip() {
            players[turn].pieces.get(value).vflippieces();
            board.overlay(players[turn].pieces.get(value), selection.x, selection.y);
            placepiece();
        }

        private void placepiece() {
            boardimage.setImage(board.render()); // render to the newest layout
            display.repaint();
        }
        private void surrender() {
            players[turn].canPlay = false;
            {
                next_turn();
            }
            JOptionPane.showMessageDialog(null, "You Lose! You lose in your " + scorebasedround + " th round");
        }

        private void nextpiece() {
            for (int i = 0; i < players[turn].pieces.size(); i++) {
                playerpieceslabel pieceLabel = new playerpieceslabel(i, players[turn].pieces.get(i), playerpieces.res);
                pieceLabel.addMouseListener(new piecemovement());
            }
            piecewindow.repaint();
            pack();
        }

        //piecemovement
        private class piecemovement implements MouseListener {
            public void mouseClicked(MouseEvent e) {
                playerpieceslabel pl = (playerpieceslabel) e.getComponent();
                value = pl.value;
            }

            public void mouseEntered(MouseEvent e) { // formalitas
            }
            public void mouseReleased(MouseEvent e) { // formalitas
            }
            public void mouseExited(MouseEvent e) { // formalitas
            }
            public void mousePressed(MouseEvent e) { // formalitas
            }
        }

        // for ExceptionHandling!
        private void popup(String message) {
            JOptionPane.showMessageDialog(this, message, "Ooops!", JOptionPane.INFORMATION_MESSAGE);
        }


        private void next_turn() {
            turn++;
            turn %= totalplayers;
            // Random rand = new Random();
            // int upperbound = 21;
            // int randompiece = rand.nextInt(upperbound);

            if (!players[turn].canPlay) {
                next_turn();
                return;
            }

            piecewindow.removeAll();
            // textwindow.removeAll();

            for (int i = 0; i < players[turn].pieces.size(); i++) {
                playerpieceslabel pieceLabel = new playerpieceslabel(i, players[turn].pieces.get(i), playerpieces.res);
                pieceLabel.addMouseListener(new piecemovement());
                piecewindow.add(pieceLabel);
            }

            scorebasedround = scorebasedround + 1;
            piecewindow.repaint();
            value = 0;
            pack();
        }
    }

    public static class playerpieceslabel extends JLabel {
        public int value;

        public playerpieceslabel(int value, playerpieces pp, int size) {
            super(new ImageIcon(pp.render(size)));
            this.value = value;
        }
    }

    // END
    public static void main(String[] args) {
        mainframe a = new mainframe();
    }
}

/*
REFERENCES!!!

- https://www.javatpoint.com/java-mouselistener // mouse listener buat rotate
- https://www.javatpoint.com/java-mousemotionlistener // mouse motion listener buat guidance

 */
