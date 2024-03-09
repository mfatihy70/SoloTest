import javax.swing.JFrame;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Solo Test");
        setSize(500, 500);
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