package mytristronics.java.chessGui;

import javax.swing.*;
import java.awt.*;

public class GUISquare extends JPanel {
    final private String ID;
    final boolean isWhite;

    final int squareIndex;

    public GUISquare(String ID, boolean isWhite, int size, int squareIndex1) {
        super(new BorderLayout());
        this.ID = ID;
        this.isWhite = isWhite;
        this.squareIndex = squareIndex1;

        if (isWhite) {
            setBackground(Color.white);
        }else {
            setBackground(Color.darkGray);
        }

        setPreferredSize(new Dimension(size,size));


    }

    public String getID() {
        return ID;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public int getSquareIndex() {
        return squareIndex;
    }
}
