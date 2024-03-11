import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.util.Objects;

public class ScorePanel extends JPanel {

    private final JLabel scoreLabel = new JLabel("Score: ");
    private final GridBagConstraints gbc = new GridBagConstraints();

    private final JLabel[] imageLabels = {
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("bilgin.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("zeki.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("kurnaz.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("basarili.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("normal.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("tecrübesiz.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("aptal.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("gerizekali.jpg")))),
            new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("beyinsiz.jpg"))))
    };

    private final JLabel[] imageTranslations = {
            new JLabel("You are \"Wise\""),
            new JLabel("You are \"Intelligent\""),
            new JLabel("You are \"Clever\""),
            new JLabel("You are \"Successfull\""),
            new JLabel("You are \"Normal\""),
            new JLabel("You are \"Clueless\""),
            new JLabel("You are \"Dumb\""),
            new JLabel("You are \"Idiot\""),
            new JLabel("You are \"Brainless\""),
    };

    private void addVSpace(){
        gbc.gridy++;
        add(new JLabel(" "), gbc);
        gbc.gridy++;
    }

    private void initPanel(int stonesLeft){
        //Formatting score panel
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        add(scoreLabel, gbc);
        addVSpace();
        if (stonesLeft < 10 && stonesLeft > 0){
            scoreLabel.setText("You got only " + stonesLeft + " stones left!");
            add(imageTranslations[stonesLeft-1], gbc);
            addVSpace();
            add(imageLabels[stonesLeft-1], gbc);
        }
        else {
            scoreLabel.setText("You got " + stonesLeft + " stones left.");
            addVSpace();
            add(new JLabel("Congratulations you didn't even get any rank."), gbc);
            addVSpace();
        }
    }

    public ScorePanel(int stonesLeft){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 300));
        initPanel(stonesLeft);
        JOptionPane.showMessageDialog(this, this, "Score", JOptionPane.PLAIN_MESSAGE);
    }
}
