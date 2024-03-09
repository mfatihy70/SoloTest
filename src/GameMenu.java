import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GameMenu extends JMenuBar {
    public GameMenu(){
        var newGame = new JMenuItem("New Game");
        var howToPlay = new JMenuItem("How to play");
        var credits = new JMenuItem("Credits");
        var todoWinCheckMenu = new JMenuItem("Got 3 stones?");

        newGame.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "New Game", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                GameBoard.resetBoard();
            }
        });

        howToPlay.addActionListener(e -> JOptionPane.showMessageDialog(null, """                    
        The goal of the game is to remove as many stones as possible from the board
        You can only move a stone to an empty field, by jumping over another stone.
        You can only jump horizontally or vertically.
        """));

        credits.addActionListener(e -> JOptionPane.showMessageDialog(null, """
        This game was created by:
        M. Fatih Yildiz
        https://github.com/mfatihy70/SoloTest/"""));

        todoWinCheckMenu.addActionListener(e -> JOptionPane.showMessageDialog(null, """
                                               Sorry!\s
        If you got 3 immovable stones and the game didn't end,
        that's because I haven't implemented that case yet.
        Just count the stones yourself and start a new game"""));

        add(newGame);
        add(howToPlay);
        add(credits);
        add(todoWinCheckMenu);
    }
}
