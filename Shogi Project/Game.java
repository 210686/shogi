import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

public class Game{
    private static JFrame f;
    private static printBoard p;
    private static Runnable r;
    public Game(){}

    public void update(boolean gameover){ 
        try{
            f.revalidate();
            f.repaint();
        }catch(NullPointerException e){}
    }

    public static void main(String[] args) {
        r = new Runnable()
        {
            @Override
            public void run() {
                System.out.print("\f");
                p = new printBoard();

                f = new JFrame("Shogi");

                f.add(p.getBoard());

                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.pack();
                f.setLocationByPlatform(true);
                f.setMinimumSize(f.getSize());
                f.setMaximumSize(f.getSize());
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}