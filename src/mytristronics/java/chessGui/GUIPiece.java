package mytristronics.java.chessGui;

import com.github.bhlangonijr.chesslib.Piece;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GUIPiece extends JLabel {
    final String FENSymbol;
    private final ImageIcon imageIcon;
    final Piece piece;

    GUIPiece(Piece piece, int size){

        this.piece = piece;

        FENSymbol = piece.getFenSymbol();

        String fileStart = Character.isUpperCase(FENSymbol.charAt(0)) ? "w" : "b";
        URL image = GUIPiece.class.getClassLoader().getResource("images/" + fileStart + FENSymbol + ".png");
        //scale the image at initialisation
        imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT));

        setIcon(imageIcon);
    }
}
