import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Field extends JButton{
    private int x;
    private int y;
    private boolean hasStone;

    public Field(int x, int y){
        this.x = x;
        this.y = y;

        if ((x == 3 || x == 4 || x == 5) || (y == 3 || y == 4 || y == 5))
        {
            putStone();
            if (x == 4 && y == 4) {
                removeStone();
            }
        }
        else {
            setVisible(false);
        }

        setBackground(Color.RED);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public int[] getCoord(){
        return new int[]{x, y};
    }

    public void setCoord(int[] coord){
        this.x = coord[0];
        this.y = coord[1];
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

    public void moveStone(Field toField){
        if (toField.hasStone){
            System.out.println("Field is occupied");
            return;
        }

        toField.putStone();
        this.removeStone();

    }

}
