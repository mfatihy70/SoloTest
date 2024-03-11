import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.util.Objects;

public class Main extends JFrame {
    public Main() {
        setTitle("Solo Test");
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("icon.png"))).getImage());
        setSize(500, 520);
        setContentPane(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setJMenuBar(new Menu());
    }

    public static void main(String[] args) {
        new Main();

    }
}