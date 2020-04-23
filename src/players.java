import java.util.Random;
import java.util.LinkedList;


public class players {

    public LinkedList<playerpieces> pieces;
    public boolean canPlay = true;
    public static final Random random = new Random();

    public players(int color) {
        int[][][] pieceshape = playerpieces.AllPieces();
        pieces = new LinkedList<>();

        for (int i = 0; i < pieceshape.length; i++) {
            pieces.add(new playerpieces(pieceshape[i], color));

        }
    }

    public int playerscore()
    {
        int total = 0;
        for (playerpieces bp : pieces)
        {
            total += bp.score();
        }
        return total;
    }
}
