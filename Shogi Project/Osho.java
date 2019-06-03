import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
public class Osho implements Koma{
    private int[][] moveSet = new int[2][8];
    private int order;
    
    public int[][] getMoveSet(){
        moveSet[0][0] = -1;
        moveSet[1][0] = 1;
        
        moveSet[0][1] = 0;
        moveSet[1][1] = 1;
        
        moveSet[0][2] = 1;
        moveSet[1][2] = 1;
        
        moveSet[0][3] = -1;
        moveSet[1][3] = 0;
        
        moveSet[0][4] = 1;
        moveSet[1][4] = 0;
        
        moveSet[0][5] = -1;
        moveSet[1][5] = -1;
        
        moveSet[0][6] = 0;
        moveSet[1][6] = -1;
        
        moveSet[0][7] = 1;
        moveSet[1][7] = -1;
        
        return moveSet;
    }
    
    public ImageIcon getKoma(){
        BufferedImage image = null;
        try {
            if(order == 1){
                image = ImageIO.read(new File("koma_pics/王将.png"));
            }
            else{
                image = ImageIO.read(new File("koma_pics1/王将.png"));
            }
        } catch (IOException e) {}
        
        ImageIcon img = new ImageIcon(image);
        return img;
    }
    
    public Osho(int order){
        this.order = order;
    }
    public int getOrder(){
        return order;
    }
    public String getName(){
        return "王";
    }
}