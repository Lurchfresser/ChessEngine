package mytristronics.java;

public enum PIECE {
    WHITE_PAWN(true, 'P', 'P'),
    WHITE_KNIGHT(true, 'N', 'N'),
    WHITE_BISHOP(true, 'B', 'B'),
    WHITE_ROOK(true, 'R', 'R'),
    WHITE_QUEEN(true, 'Q', 'Q'),
    WHITE_KING(true, 'K', 'K'),
    BLACK_PAWN(false, 'P', 'p'),
    BLACK_KNIGHT(false, 'N', 'n'),
    BLACK_BISHOP(false, 'B', 'b'),
    BLACK_ROOK(false, 'R', 'r'),
    BLACK_QUEEN(false, 'Q', 'q'),
    BLACK_KING(false, 'K', 'k'),
    ;

    final boolean isWhite;
    final char type;

    final char symbol;

    PIECE(boolean isWhite, char type, char symbol) {
        this.isWhite = isWhite;
        this.type = type;
        this.symbol = symbol;
    }
    public static PIECE fromFEN(char Fen){
        for (PIECE p:PIECE.values()){
            if (p.symbol == Fen)
                return p;
        }
        return null;
    }
}
