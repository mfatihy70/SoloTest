import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.util.Objects;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Solo Test");
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("icon.png"))).getImage());
        setSize(500, 520);
        setContentPane(new GameBoard());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setJMenuBar(new GameMenu());
    }

    public static void main(String[] args) {
        new MainWindow();

    }
}