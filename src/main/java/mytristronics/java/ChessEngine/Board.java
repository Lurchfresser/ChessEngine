package mytristronics.java.ChessEngine;

public class Board {
    boolean whitesMove;

    public Board(String FEN){
        FENHandeling.getBoardFromFen(FEN);
    }
}
