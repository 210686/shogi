import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Fu implements Koma{
    private int[][] moveSet = new int[2][1];
    private int order;
    
    public int[][] getMoveSet(){
        if(order == 1){
            moveSet[0][0] = 0;
            moveSet[1][0] = 1;
        }
        else{
            moveSet[0][0] = 0;
            moveSet[1][0] = -1;
        }
        return moveSet;
    }
    
    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            if(order == 1){
                image = ImageIO.read(new File("koma_pics/歩兵.png"));
            }
            else{
                image = ImageIO.read(new File("koma_pics1/歩兵.png"));
            }
        } catch (IOException e) {}
        
        ImageIcon img = new ImageIcon(image);
        return img;
    }
    
    public Fu(int order){
        this.order = order;
    }
    public int getOrder(){
        return order;
    }
    public String getName(){
        return "歩";
    }
}