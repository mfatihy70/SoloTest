import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class ScorePanel extends JPanel {

    private final JLabel scoreLabel = new JLabel("Score: ");
    private final JLabel[] imageLabels = {
            new JLabel(new ImageIcon("data/beyinsiz.jpg")),
            new JLabel(new ImageIcon("data/gerizekali.jpg")),
            new JLabel(new ImageIcon("data/aptal.jpg")),
            new JLabel(new ImageIcon("data/tecrübesiz.jpg")),
            new JLabel(new ImageIcon("data/normal.jpg")),
            new JLabel(new ImageIcon("data/basarili.jpg")),
            new JLabel(new ImageIcon("data/kurnaz.jpg")),
            new JLabel(new ImageIcon("data/zeki.jpg")),
            new JLabel(new ImageIcon("data/bilgin.jpg"))
    };

    private final JLabel[] imageTranslations = {
            new JLabel("\"Brainless\""),
            new JLabel("\"Idiot\""),
            new JLabel("\"Dumb\""),
            new JLabel("\"Clueless\""),
            new JLabel("\"Normal\""),
            new JLabel("\"Successfull\""),
            new JLabel("\"Clever\""),
            new JLabel("\"Intelligent\""),
            new JLabel("\"Wise\"")
    };

    private final GridBagConstraints gbc = new GridBagConstraints();

    private void addVSpace(){
        gbc.gridy++;
        add(new JLabel(" "), gbc);
        gbc.gridy++;
    }

    private void initPanel(int stonesLeft){
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        add(scoreLabel, gbc);
        addVSpace();
        if (stonesLeft < 10 && stonesLeft > 0){
            scoreLabel.setText("You got only " + stonesLeft + " stones left!");
            add(imageTranslations[9-stonesLeft], gbc);
            addVSpace();
            add(imageLabels[9-stonesLeft], gbc);
        }
        else {
            addVSpace();
            add(new JLabel("Wow you didn't even get any rank. Impressive..."));
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
