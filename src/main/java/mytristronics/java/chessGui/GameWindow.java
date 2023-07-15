package mytristronics.java.chessGui;

import com.github.bhlangonijr.chesslib.Board;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    public GameWindow() {

        JPanel testPanel = new GUIBoard(600,true, new Board());

        registerWindowListener();
        createMenu();

        add(testPanel);
        pack();

        setTitle("Chess GUI");
        setLocation(10, 10);
        setResizable(false);

        setVisible(true);
        setLayout(null);
    }

    private void registerWindowListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //TODO: implement
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //TODO: implement
            }
        });
    }

    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu gameMenu = new JMenu("Game");
        JMenu prefMenu = new JMenu("Preferences");

        menuBar.add(fileMenu);
        menuBar.add(gameMenu);
        menuBar.add(prefMenu);

        addFileMenuItems(fileMenu);
    }

    private void addFileMenuItems(JMenu fileMenu) {
        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);

        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}