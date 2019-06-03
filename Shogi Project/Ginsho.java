import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Ginsho implements Koma{
    private int[][] moveSet = new int[2][5];
    private int order;
    
    public int[][] getMoveSet(){
        if(order == 1){
            moveSet[0][0] = -1;
            moveSet[1][0] = 1;

            moveSet[0][1] = 0;
            moveSet[1][1] = 1;

            moveSet[0][2] = 1;
            moveSet[1][2] = 1;

            moveSet[0][3] = -1;
            moveSet[1][3] = -1;

            moveSet[0][4] = 1;
            moveSet[1][4] = -1;
        }
        else{
            moveSet[0][0] = -1;
            moveSet[1][0] = 1;

            moveSet[0][1] = 1;
            moveSet[1][1] = 1;

            moveSet[0][2] = -1;
            moveSet[1][2] = -1;

            moveSet[0][3] = 0;
            moveSet[1][3] = -1;

            moveSet[0][4] = 1;
            moveSet[1][4] = -1;
        }
        return moveSet;
    }
    
    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            if(order == 1){
                image = ImageIO.read(new File("koma_pics/銀将.png"));
            }
            else{
                image = ImageIO.read(new File("koma_pics1/銀将.png"));
            }
        } catch (IOException e) {}
        
        ImageIcon img = new ImageIcon(image);
        return img;
    }
    
    public Ginsho(int order){
        this.order = order;
    }
    public int getOrder(){
        return order;
    }
    public String getName(){
        return "銀";
    }
}