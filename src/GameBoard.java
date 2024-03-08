import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameBoard extends JPanel {

    private final Integer[][] board = new Integer[9][9];

    private void initBoard(){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                JButton button = new JButton();
                int finalI = i;
                int finalJ = j;
                button.addActionListener(e -> {
                    moveStone(finalI, finalJ);
                });
                add(button);

                if ((j == 3 || j == 4 || j == 5) || (i == 3 || i == 4 || i == 5)) {
                    button.setBackground(Color.RED);
                    button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                    if (!(i == 4 && j == 4)) {
                        button.setIcon(new ImageIcon("data/stone.png"));
                        board[i][j] = 1;
                    }
                    else {board[i][j] = 0;}

                }

                else {
                    button.setVisible(false);
                    board[i][j] = 0;
                }


            }
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private void moveStone(int x, int y){
        //TODO: Implement this method
    }


    public GameBoard() {
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(9,9));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        initBoard();
    }




}
