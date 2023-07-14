package mytristronics.java.ChessEngine;

import java.util.StringTokenizer;

public class FEN{
    public static Board getBoardFromFen(String FEN){
        Board board = new Board("hi");
        StringTokenizer FENSpaceSeperator = new StringTokenizer(FEN," ", false);
        for (int i = 0; i<6;i++){
            switch (i){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }


        return board;
    }
}
