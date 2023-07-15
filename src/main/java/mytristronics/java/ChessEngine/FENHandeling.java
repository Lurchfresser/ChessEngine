package mytristronics.java.ChessEngine;

import mytristronics.java.PIECE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Character.isDigit;

public class FENHandeling {
    public static void getBoardFromFen(String FEN) {
        StringTokenizer FENSpaceSeperator = new StringTokenizer(FEN, " ", false);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    CreatePieceArray(FENSpaceSeperator.nextToken());
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
    }

    static private long[] CreatePieceArray(String piecePlacement) {
        long[] pieceBBs = new long[12];
        Arrays.fill(pieceBBs, 0);
        long squareIndex = 63;
        for (char ch : piecePlacement.toCharArray()) {
            if (ch == '/') {

            }else if (isDigit(ch)){
                squareIndex-= (long) ch;
            }else {
                pieceBBs[PIECE.fromFEN(ch).ordinal()] |= 1L << squareIndex;
                squareIndex--;
            }
        }
        int i =0;
        for (long l:pieceBBs){
            System.out.println("PieceIndex: " + i++);
            while (l != 0){
                System.out.println(Long.toBinaryString(l));
                System.out.println(Long.toBinaryString(1L << bitScanForwardDbl(l)));
                l ^= 1L << bitScanForwardDbl(l);
            }
        }
        return pieceBBs;
    }

    static public int bitScanForwardDbl(long b)
    {
        double x = (double)(b & - b);
        int exp = (int) (Double.doubleToLongBits(x) >>> 52);
        return (exp & 2047) - 1023;
    }
}
