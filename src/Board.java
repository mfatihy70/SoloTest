import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;

public class Board extends JPanel {

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
                if (board[i][j].hasStone && board[i][j].isVisible()){
                    stoneCount++;
                }
            }
        }
        return stoneCount;
    }

    private void clickField(Field field){
        //Function handling click events by checking if the move is valid
        if (firstField != null && !field.hasStone && isMovable(firstField)) {
            Field middleField = board[(firstField.x + field.x) / 2][(firstField.y + field.y) / 2];
            if (middleField.hasStone) {
                firstField.moveStone(field);
                middleField.removeStone();
            } else {
                firstField = field;
            }
        } else {
            firstField = field;
        }

        if (checkGameOver()){
            new Score(getStoneCount());
        }
    }

    private boolean checkGameOver() {
        //If there areno valid moves left, the game is over
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (((x == 3 || x == 4 || x == 5) || (y == 3 || y == 4 || y == 5)) &&
                    (isMovable(board[x][y]))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isMovable(Field field){
        //Checking if the stone has valid moves
        if (!field.hasStone){
            return false;
        }
        // Check move up
        if (field.x > 1 && board[field.x-1][field.y].hasStone && !board[field.x-2][field.y].hasStone) {
            return true;
        }
        // Check move down
        if (field.x < 7 && board[field.x+1][field.y].hasStone && !board[field.x+2][field.y].hasStone) {
            return true;
        }
        // Check move left
        if (field.y > 1 && board[field.x][field.y-1].hasStone && !board[field.x][field.y-2].hasStone) {
            return true;
        }
        // Check move right
        if (field.y < 7 && board[field.x][field.y+1].hasStone && !board[field.x][field.y+2].hasStone) {
            return true;
        }

        return false;
    }

    public Board() {
        setLayout(new GridLayout(9,9));
        setBorder(BorderFactory.createEmptyBorder(7,7,7,7));
        initBoard();
    }
}
