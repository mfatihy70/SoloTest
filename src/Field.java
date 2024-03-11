import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Field extends JButton{
    public int x;
    public int y;
    public boolean hasStone;
    public boolean isMovable;

    public Field(int x, int y){
        this.x = x;
        this.y = y;

        if ((x == 3 || x == 4 || x == 5) || (y == 3 || y == 4 || y == 5)){
            putStone();
            if (x == 4 && y == 4) {
                removeStone();
            }
        }
        else {
            setVisible(false);
            putStone();
        }


        setBackground(Color.RED);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void putStone(){
        if (hasStone){
            return;
        }
        hasStone = true;
        setIcon(new ImageIcon("data/stone.png"));
    }

    public void removeStone(){
        if (!hasStone){
            return;
        }
        hasStone = false;
        setIcon(null);
    }

    public void changeState(){
        if (hasStone){
            removeStone();
        } else {
            putStone();
        }
    }

    public void moveStone(Field toField){
        //Case field is occupied
        if (toField.hasStone){
            return;
        }

        toField.changeState();
        this.changeState();
    }
}

