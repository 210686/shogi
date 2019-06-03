import javax.swing.*;
import java.awt.image.BufferedImage;
public class BoardGraphics{
    private Koma[][] board = new Koma[9][9];
    private boolean gameover;
    private int turns = 0;
    public BoardGraphics(){
        for(int i = 0; i < 9; i++){
            board[2][i] = new Fu(-1);
            board[6][i] = new Fu(1);
        }
        board[0][4] = new Osho(-1);
        board[8][4] = new Osho(1);

        board[0][3] = new Kinsho(-1);
        board[0][5] = new Kinsho(-1);
        board[8][3] = new Kinsho(1);
        board[8][5] = new Kinsho(1);

        board[0][2] = new Ginsho(-1);
        board[0][6] = new Ginsho(-1);
        board[8][2] = new Ginsho(1);
        board[8][6] = new Ginsho(1);

        board[0][1] = new Keima(-1);
        board[0][7] = new Keima(-1);
        board[8][1] = new Keima(1);
        board[8][7] = new Keima(1);

        board[0][0] = new Kyosya(-1);
        board[0][8] = new Kyosya(-1);
        board[8][0] = new Kyosya(1);
        board[8][8] = new Kyosya(1);

        board[1][1] = new Hisya(-1);
        board[7][7] = new Hisya(1);

        board[1][7] = new Kakugyo(-1);
        board[7][1] = new Kakugyo(1);
    }

    public ImageIcon getImage(int i, int j){
        try{
            return board[i][j].getKoma();
        } catch(NullPointerException e){
            return new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        }
    }

    public int[][] getMoves(int x, int y){
        try{
            return board[y][x].getMoveSet();
        } catch(NullPointerException e){return new int[0][0];}
    }

    public void changeLoc(int x, int y, int newX, int newY){
        try{
            if(board[y - newY][x - newX].getOrder() != board[y][x].getOrder()){
                turns++;
                Koma temp = board[y][x];
                board[y][x] = null;
                if(board[y - newY][x - newX].getName().equals("王")){
                    gameover = true;
                }
                board[y - newY][x - newX] = temp;
                printMove(x - newX, y - newY);
            }
        }catch(NullPointerException e){
            try{
                turns++;
                Koma temp = board[y][x];
                board[y][x] = null;
                board[y - newY][x - newX] = temp;
                printMove(x - newX, y - newY);
            }
            catch(NullPointerException e2){}
        }
    }

    public void printMove(int x, int y){
        String str = "";

        str += String.valueOf(turns) + ": ";
        str += String.valueOf(y + 1);
        if(x == 0){str += "一";}
        else if(x == 1){str += "二";}
        else if(x == 2){str += "三";}
        else if(x == 3){str += "四";}
        else if(x == 4){str += "五";}
        else if(x == 5){str += "六";}
        else if(x == 6){str += "七";}
        else if(x == 7){str += "八";}
        else if(x == 8){str += "九";}
        System.out.println(str + board[y][x].getName());
    }

    public boolean gameover(){
        return gameover;
    }

    public Koma[][] getBoard(){
        return board;
    }

    public int getOrder(){
        return turns % 2;
    }

    public int getK(int y, int x){
        try{
            return board[y][x].getOrder();
        } catch(NullPointerException e){}
        return 0;
    }
}