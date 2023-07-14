import com.github.bhlangonijr.chesslib.Board;
import mytristronics.java.chessGui.GameWindow;

public class Main {
    public static void main(String[] args) {
        //GameWindow board = new GameWindow();
        //System.out.println(board.toString());
        Board board2 = new Board();
        System.out.println(board2.getFen());
    }
}