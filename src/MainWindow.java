import javax.swing.*;

public class MainWindow extends JFrame {
    private static final JPanel mainPanel = new JPanel();

    public MainWindow() {
        setTitle("Solo Test");
        setSize(500, 750);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        ScorePanel scorePanel = new ScorePanel();
        mainPanel.add(scorePanel);
        mainPanel.add(gameBoard);
        MainWindow mw = new MainWindow();
        mw.setVisible(true);
    }
}