package mytristronics.java.chessGui;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.Piece;
import com.github.bhlangonijr.chesslib.Side;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class GUIBoard extends JPanel {

    Board board;
    final Map<String, GUISquare> squareMap = new HashMap<String, GUISquare>();
    final GUISquare[] GUISquares = new GUISquare[64];

    int size;

    Side sidePlaying;

    public GUIBoard(int size, boolean whitePLaying, Board board) {

        this.size = size;

        this.board = board;

        setSize(new Dimension(size, size));

        setLayout(new GridLayout(8, 8));

        sidePlaying = whitePLaying? Side.WHITE : Side.BLACK;

        if (whitePLaying)
            setUpForWhite();
        else
            setUpForBlack();

        setPosition(board.boardToArray());
    }

    private void setUpForWhite() {
        int squareSize = size / 8;
        int borderSize = (int) ((squareSize * (1 - GUI.PIECE_SIZE_FACTOR.numVal)) / 2);

        int squareIndex = 0;

        for (int i = 8; i > 0; i--) {
            for (char c = 'a'; c < 'i'; c++) {

                String ID = Integer.toString(i) + c;

                //exclusive Or on weather the number or the char is odd
                boolean isWhite = ((c % 2) ^ (i % 2)) > 0;

                //creates the squares and puts them in a Hashmap with the SquareID as Key
                GUISquare GUISquare = new GUISquare(ID, isWhite, squareSize, squareIndex);

                add(GUISquare);

                squareMap.put(ID, GUISquare);

                GUISquares[squareIndex++] = GUISquare;

                if (c == 'a') {
                    GUISquare.add(jLabelFactory(Integer.toString(i)), BorderLayout.PAGE_START);
                } else {
                    GUISquare.add(BoxFiller(true), BorderLayout.PAGE_START);
                }
                if (i == 1) {
                    GUISquare.add(jLabelFactory(Character.toString(c)), BorderLayout.PAGE_END);
                } else {
                    GUISquare.add(BoxFiller(true), BorderLayout.PAGE_END);
                }
                GUISquare.add(BoxFiller(false), BorderLayout.LINE_START);
                GUISquare.add(BoxFiller(false), BorderLayout.LINE_END);
            }
        }
    }


    private void setUpForBlack() {
        int squareSize = size / 8;
        int borderSize = (int) ((squareSize * (1 - GUI.PIECE_SIZE_FACTOR.numVal)) / 2);

        int squareIndex = 63;
        for (int i = 1; i < 9; i++) {
            for (char c = 'h'; c >= 'a'; c--) {

                String ID = Integer.toString(i) + c;

                //exclusive Or on weather the number or the char is odd
                boolean isWhite = ((c % 2) ^ (i % 2)) > 0;

                GUISquare GUISquare = new GUISquare(ID, isWhite, squareSize, squareIndex);

                add(GUISquare);

                squareMap.put(ID, GUISquare);

                GUISquares[squareIndex--] = GUISquare;

                if (c == 'h') {
                    GUISquare.add(jLabelFactory(Integer.toString(i)), BorderLayout.PAGE_START);
                } else {
                    GUISquare.add(BoxFiller(true), BorderLayout.PAGE_START);
                }
                if (i == 8) {
                    GUISquare.add(jLabelFactory(Character.toString(c)), BorderLayout.PAGE_END);
                } else {
                    GUISquare.add(BoxFiller(true), BorderLayout.PAGE_END);
                }
                GUISquare.add(BoxFiller(false), BorderLayout.LINE_START);
                GUISquare.add(BoxFiller(false), BorderLayout.LINE_END);
            }
        }
    }

    private JLabel jLabelFactory(String text) {
        JLabel jLabel = new JLabel();
        jLabel.setText(text);
        double squareSize = ((double) size / 8);
        int height = (int) ((squareSize * (1 - GUI.PIECE_SIZE_FACTOR.numVal)) / 2) - 2;
        jLabel.setMaximumSize(new Dimension(size / 8, height));
        return jLabel;
    }

    private Box.Filler BoxFiller(boolean horizontal) {
        double squareSize = ((double) size / 8);
        int fillerSize = (int) ((squareSize * (1 - GUI.PIECE_SIZE_FACTOR.numVal)) / 2) - 2;

        Dimension dimension;

        if (horizontal) {
            dimension = new Dimension(size / 8, fillerSize + 10);
        } else {
            dimension = new Dimension(fillerSize, size / 8);
        }

        Box.Filler fillerBox = new Box.Filler(dimension, dimension, dimension);
        return fillerBox;
    }

    public void setPosition(Piece[] pieces) {
        int pieceSize = (int) (((double) size / 8) * (GUI.PIECE_SIZE_FACTOR.numVal));
        for (int i = 0; i < 64; i++) {
            if (pieces[i].getPieceType() != null) {
                GUIPiece piece = new GUIPiece(pieces[i], pieceSize);
                piece.addMouseListener(new PieceMoveMouseListener());
                GUISquares[63 - i].add(piece, BorderLayout.CENTER);
            }
        }
    }

    public void highLightBitboard(long bb){
        for (GUISquare square:GUISquares){

        }
    }

    class PieceMoveMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getSource() instanceof GUIPiece){
                GUIPiece target = (GUIPiece) e.getSource();
                if (target.piece.getPieceSide() == sidePlaying) {
                    System.out.println(Long.toBinaryString(board.getBitboard(target.piece)));
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

