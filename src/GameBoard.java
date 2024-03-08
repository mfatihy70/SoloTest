import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    private final Field[][] board = new Field[9][9];
    private Field firstField = null;

    private void initBoard(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                Field currentField = new Field(i, j);
                board[i][j] = currentField;

                currentField.addActionListener(e -> {
                    if (firstField != null) {
                        firstField.moveStone(currentField);
                        firstField = null;
                    } else {
                        firstField = currentField;
                    }
                });
                add(currentField);
            }
        }
    }

    public GameBoard() {
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(9,9));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        initBoard();
    }
}
