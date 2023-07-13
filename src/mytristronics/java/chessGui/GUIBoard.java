package mytristronics.java.chessGui;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.github.bhlangonijr.chesslib.Piece.NONE;

public class GUIBoard extends JPanel {

    Board board;
    final Map<String, Square> squareMap = new HashMap<String, Square>();
    final Square[] squares = new Square[64];

    int size;

    public GUIBoard(int size, boolean whitePLaying, Board board) {

        this.size = size;

        this.board = board;

        setSize(new Dimension(size, size));

        setLayout(new GridLayout(8, 8));


        if (whitePLaying)
            setUpForWhite();
        else
            setUpForBlack();

        setPosition(board.boardToArray());
    }

    private void setUpForWhite() {
        int squareSize = size / 8;
        int squareIndex = 0;
        for (int i = 8; i > 0; i--) {
            for (char c = 'a'; c < 'i'; c++) {

                String ID = Integer.toString(i) + c;

                //exclusive Or on weather the number or the char is odd
                boolean isWhite = ((c % 2) ^ (i % 2)) > 0;

                //creates the squares and puts them in a Hashmap with the SquareID as Key
                Square square = new Square(ID, isWhite, squareSize, squareIndex);

                add(square);

                squareMap.put(ID, square);

                squares[squareIndex++] = square;

                if (c == 'a') {
                    JLabel numberLabel = new JLabel();
                    numberLabel.setText(Integer.toString(i));
                    square.add(numberLabel, BorderLayout.PAGE_START);
                }
                if (i == 1) {
                    JLabel charLabel = new JLabel();
                    charLabel.setText(Character.toString(c));
                    square.add(charLabel, BorderLayout.PAGE_END);
                }
            }
        }
    }

    private void setUpForBlack() {
        int squareSize = size / 8;
        int squareIndex = 63;
        for (int i = 1; i < 9; i++) {
            for (char c = 'h'; c >= 'a'; c--) {

                String ID = Integer.toString(i) + c;

                //exclusive Or on weather the number or the char is odd
                boolean isWhite = ((c % 2) ^ (i % 2)) > 0;

                Square square = new Square(ID, isWhite, squareSize, squareIndex);

                add(square);

                squareMap.put(ID, square);

                squares[squareIndex--] = square;

                if (c == 'h') {
                    JLabel numberLabel = new JLabel();
                    numberLabel.setText(Integer.toString(i));
                    square.add(numberLabel, BorderLayout.PAGE_START);
                }
                if (i == 8) {
                    JLabel charLabel = new JLabel();
                    square.add(charLabel, BorderLayout.PAGE_END);
                }
            }
        }
    }

    public void setPosition(Piece[] pieces) {
        for (int i = 0; i < 64; i++) {
            if (pieces[i].getPieceType() != null) {
                    squares[i].add(new GUIPiece(pieces[i], size/8), BorderLayout.CENTER);

            }
        }
    }
}

