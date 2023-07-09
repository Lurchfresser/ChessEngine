package mytristronics.java.chessGui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board extends JPanel {
    final Map<String, Square> squareMap = new HashMap<String, Square>();

    public Board(int size, boolean whitePLaying){

        setSize(new Dimension(size,size));

        setLayout(new GridLayout(8,8));

        setUpForWhite(size);
        //creates the squares and puts them in a Hashmap with the SquareID as Key
    }

    private void setUpForWhite(int size) {
        int squareSize = size/8;
        for (int i = 1; i<9;i++){
            for (char c = 'a';c<'i';c++){


                String ID = Integer.toString(i)+c;

                //exclusive Or on weather the number or the char is odd
                boolean isWhite = ((c % 2) ^ (i % 2)) > 0;

                Square square = new Square(ID,isWhite,squareSize);

                add(square);

                squareMap.put(ID,square);

                if(i==8){
                    JLabel charLabel = new JLabel();
                    charLabel.setText(Character.toString(c));
                    charLabel.setVerticalAlignment(JLabel.BOTTOM);
                    charLabel.setHorizontalTextPosition(JLabel.CENTER);
                    square.add(charLabel);
                }
            }
        }
    }
}
