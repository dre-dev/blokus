import java.util.Random;

public class piecetype {

    public static final int piece_size = 7; //alasan bukan 5, untuk rotationnya
    public static int type = 21;
    public static final Random random = new Random();
    public int i;

    public static int[][][] AllPieces() {
        int[][][] pieceshape = new int[random.nextInt(piecetype.type)][piece_size][piece_size];
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

    public static int[][][] CurrentPiece() {
        int[][][] pieceshape = new int [random.nextInt(type)][piece_size][piece_size];

        return AllPieces();
    }

}