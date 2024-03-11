import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Menu extends JMenuBar {

    private void addComponent(JComponent component, int gridx, GridBagConstraints gbc) {
        gbc.gridx = gridx; gbc.gridy = 0; add(component, gbc); }

    public Menu(){
        var newGame = new JMenuItem("New Game");
        var howToPlay = new JMenuItem("How to play");
        var credits = new JMenuItem("Credits");

        newGame.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "New Game", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                Board.resetBoard();
            }});

        howToPlay.addActionListener(e -> JOptionPane.showMessageDialog(null, """                    
        The goal of the game is to remove as many stones as possible from the board
        You can only move a stone to an empty field, by jumping over another stone.
        You can only jump horizontally or vertically.""", "How to play", JOptionPane.INFORMATION_MESSAGE));

        credits.addActionListener(e -> JOptionPane.showMessageDialog(null, """
        This game was created by:
        M. Fatih Yildiz
        https://github.com/mfatihy70/SoloTest/""", "Credits", JOptionPane.INFORMATION_MESSAGE));

        setLayout(new GridBagLayout());
        var gbc = new GridBagConstraints();
        var leftSpacer = (JComponent) Box.createHorizontalStrut(15);
        addComponent(leftSpacer, 0, gbc);
        addComponent(newGame, 1, gbc);
        addComponent(howToPlay, 2, gbc);
        addComponent(credits, 3, gbc);
    }

}
