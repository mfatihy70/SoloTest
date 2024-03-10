import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Dimension;
import static java.lang.Math.abs;

public class GameBoard extends JPanel {

    private final static Field[][] board = new Field[9][9];
    private Field firstField = null;

    public void initBoard(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                var currentField = new Field(i, j);
                board[i][j] = currentField;
                currentField.addActionListener(e -> clickField(currentField));
                add(currentField);
            }
        }
    }

    public static void resetBoard(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                board[i][j].removeStone();
                if ((i == 3 || i == 4 || i == 5) ||
                        (j == 3 || j == 4 || j == 5)){
                    board[i][j].putStone();
                    if (i == 4 && j == 4) {
                        board[i][j].removeStone();
                    }
                }
            }
        }
    }

    private int getStoneCount(){
        int stoneCount = 0;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                if (board[i][j].hasStone){
                    stoneCount++;
                }
            }
        }
        return stoneCount;
    }

    private void clickField(Field field){
        //Check if the first field is selected
        if (firstField != null && !field.hasStone){

            Field verticalMiddle = board[(field.x + firstField.x) / 2][field.y];
            Field horizontalMiddle = board[field.x][(field.y + firstField.y) / 2];
            // Check if the move is horizontally valid
            if ((abs(field.x - firstField.x) == 2) && (abs(field.y - firstField.y) == 0) &&
                    (verticalMiddle.hasStone)){
                firstField.moveStone(field);
                verticalMiddle.removeStone();
            }
            // Check if the move is vertically valid
            else if ((abs(field.x - firstField.x) == 0) && (abs(field.y - firstField.y) == 2) &&
                    (horizontalMiddle.hasStone))
            {
                firstField.moveStone(field);
                horizontalMiddle.removeStone();
            }
            firstField = null;
        }
        else {
            firstField = field;
        }

        if (checkGameOver()){
            new ScorePanel(getStoneCount());
        }
    }

    private boolean checkGameOver(){
        boolean isOver = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Field field = board[i][j];
                if ((field.hasStone) &&
                    ((i > 0 && board[i-1][j].hasStone) ||
                    (i < 8 && board[i+1][j].hasStone) ||
                    (j > 0 && board[i][j-1].hasStone) ||
                    (j < 8 && board[i][j+1].hasStone)))  {
                    isOver = false;
                    break;
                }
            }

            //TODO: Check if 3 stones are stuck
            //are3StonesStuck();

            if (!isOver) {
                break;
            }

        }
        return isOver;
    }

    private boolean are3StonesStuck() {

        if (board[0][3].hasStone && board[0][4].hasStone && board[0][5].hasStone &&
            !board[1][3].hasStone && !board[1][4].hasStone && !board[1][5].hasStone) {
            return true;
        }

        if (board[1][3].hasStone && board[1][4].hasStone && board[1][5].hasStone &&
            !board[0][3].hasStone && !board[0][4].hasStone && !board[0][5].hasStone &&
            !board[2][3].hasStone && !board[2][4].hasStone && !board[2][5].hasStone) {
            return true;
        }

        if (board[2][3].hasStone && board[2][4].hasStone && board[2][5].hasStone &&
            !board[1][3].hasStone && !board[1][4].hasStone && !board[1][5].hasStone &&
            !board[3][3].hasStone && !board[3][4].hasStone && !board[3][5].hasStone) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][3].hasStone && board[i][4].hasStone && board[i][5].hasStone &&
                !board[(i+1)%3][3].hasStone && !board[(i+1)%3][4].hasStone && !board[(i+1)%3][5].hasStone) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[3][j].hasStone && board[4][j].hasStone && board[5][j].hasStone &&
                    !board[3][(j+1)%3].hasStone && !board[4][(j+1)%3].hasStone && !board[5][(j+1)%3].hasStone) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[6+i][3].hasStone && board[6+i][4].hasStone && board[6+i][5].hasStone &&
                    !board[(6+i+1)%9][3].hasStone && !board[(6+i+1)%9][4].hasStone && !board[(6+i+1)%9][5].hasStone) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[3][6+j].hasStone && board[4][6+j].hasStone && board[5][6+j].hasStone &&
                    !board[3][(6+j+1)%9].hasStone && !board[4][(6+j+1)%9].hasStone && !board[5][(6+j+1)%9].hasStone) {
                return true;
            }
        }

        return false;
    }

    public GameBoard() {
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(9,9));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        initBoard();
    }
}
