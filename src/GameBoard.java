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

        int stoneCount = checkGameOver();
        if (stoneCount > 0){
            new ScorePanel(stoneCount);
        }
    }

    private int checkGameOver(){
        boolean isOver = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Field currentField = board[i][j];
                if (currentField.hasStone) {
                    if ((i > 0 && board[i-1][j].hasStone) ||
                            (i < 8 && board[i+1][j].hasStone) ||
                            (j > 0 && board[i][j-1].hasStone) ||
                            (j < 8 && board[i][j+1].hasStone)) {
                        isOver = false;
                        break;
                    }
                }
            }

            if (!isOver) {
                break;
            }
        }
//TODO: Fix the following code
//        // Check if three stones are at one of the sides of the board
//        for (int i = 0; i < 9; i++) {
//            if ((board[i][0].hasStone && board[i][1].hasStone && board[i][2].hasStone) || // Left side
//                (board[i][8].hasStone && board[i][7].hasStone && board[i][6].hasStone) || // Right side
//                (board[0][i].hasStone && board[1][i].hasStone && board[2][i].hasStone) || // Top side
//                (board[8][i].hasStone && board[7][i].hasStone && board[6][i].hasStone)) { // Bottom side
//                isOver = true;
//                break;
//            }
//        }
// from copilot
//    for (int i = 0; i < 9; i++) {
//        if ((board[i][0].hasStone && board[i][1].hasStone && board[i][2].hasStone &&
//            !board[i][3].hasStone && !board[i-1][0].hasStone && !board[i+1][0].hasStone) || // Left side
//
//            (board[i][8].hasStone && board[i][7].hasStone && board[i][6].hasStone &&
//            !board[i][5].hasStone && !board[i-1][8].hasStone && !board[i+1][8].hasStone) || // Right side
//
//            (board[0][i].hasStone && board[1][i].hasStone && board[2][i].hasStone &&
//            !board[3][i].hasStone && !board[0][i-1].hasStone && !board[0][i+1].hasStone) || // Top side
//
//            (board[8][i].hasStone && board[7][i].hasStone && board[6][i].hasStone &&
//            !board[5][i].hasStone && !board[8][i-1].hasStone && !board[8][i+1].hasStone)) { // Bottom side
//            isOver = true;
//            break;
//        }
//    }

        if (isOver) {
            return getStoneCount();
        }
        return 0;
    }

    public GameBoard() {
        setPreferredSize(new Dimension(500, 500));
        setLayout(new GridLayout(9,9));
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        initBoard();
    }
}
