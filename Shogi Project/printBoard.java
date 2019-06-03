import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
public class printBoard extends Game{
    private BoardGraphics boardGui = new BoardGraphics();
    private JButton[][] boardSquares = new JButton[9][9];
    private JPanel board;
    private JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JLabel label;
    private JButton b1;
    private boolean gameover;
    public printBoard(){
        printKoma();
    }

    public void goBack(){printKoma();}

    public void printKoma(){
        gui.removeAll();
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(b1 = new JButton("New"));
        tools.addSeparator();
        if(boardGui.getOrder() == 0){
            tools.add(label = new JLabel("Player 1's Turn"));
        }
        else{
            tools.add(label = new JLabel("Player 2's Turn"));
        }
        tools.addSeparator();

        board = new JPanel(new GridLayout(0, 10));
        board.setBorder(new LineBorder(Color.BLACK));
        gui.add(board);

        b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.print("\f");
                    boardGui = new BoardGraphics();
                    gameover = false;
                    goBack();
                }
            });
        if(!gameover){
            ActionListener listener = new ActionListener(){
                    int x = -1, y = -1;
                    public void actionPerformed(ActionEvent a){
                        Object source = a.getSource();
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) { 
                                if (source == boardSquares[i][j]) {
                                    if(x != -1){
                                        int[][] moveSet = boardGui.getMoves(x, y);
                                        try{
                                            for(int k = 0; k < moveSet[0].length; k++){
                                                boolean newX = (x - j) == moveSet[0][k];
                                                boolean newY = (y - i) == moveSet[1][k];
                                                if(newX && newY){
                                                    boardGui.changeLoc(x, y, moveSet[0][k], moveSet[1][k]);
                                                    if(boardGui.gameover()){gameover = true;
                                                        System.out.println(gameover);}
                                                    goBack();
                                                    break;
                                                }
                                            }
                                        } catch(ArrayIndexOutOfBoundsException e){}
                                    }
                                    if(boardGui.getOrder() == 0 && boardGui.getK(i, j) == 1){
                                        x = j;
                                        y = i;
                                    }
                                    else if(boardGui.getOrder() == 1 && boardGui.getK(i, j) == -1){
                                        x = j;
                                        y = i;
                                    }
                                    else{
                                        x = -1;
                                        y = -1;
                                    }
                                }
                            }
                        }
                    }
                };

            Insets buttonMargin = new Insets(0,0,0,0);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    JButton b = new JButton();
                    b.setMargin(buttonMargin);
                    ImageIcon icon = new ImageIcon();
                    icon = boardGui.getImage(i,j);
                    b.setIcon(icon);
                    boardSquares[i][j] = b;
                }
            }

            board.add(new JLabel(""));
            for (int i = 0; i < 9; i++) {
                board.add(new JLabel(String.valueOf(i + 1), SwingConstants.CENTER));
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    switch (j) {
                        case 0:
                        if(i == 0){board.add(new JLabel("一", SwingConstants.CENTER));}
                        if(i == 1){board.add(new JLabel("二", SwingConstants.CENTER));}
                        if(i == 2){board.add(new JLabel("三", SwingConstants.CENTER));}
                        if(i == 3){board.add(new JLabel("四", SwingConstants.CENTER));}
                        if(i == 4){board.add(new JLabel("五", SwingConstants.CENTER));}
                        if(i == 5){board.add(new JLabel("六", SwingConstants.CENTER));}
                        if(i == 6){board.add(new JLabel("七", SwingConstants.CENTER));}
                        if(i == 7){board.add(new JLabel("八", SwingConstants.CENTER));}
                        if(i == 8){board.add(new JLabel("九", SwingConstants.CENTER));}

                        default:
                        boardSquares[i][j].addActionListener(listener);
                        board.add(boardSquares[i][j]);
                    }
                }
            }
        }
        super.update(gameover);
    }

    public JComponent getBoard(){
        return gui;
    }
}