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
            new JLabel("\"Hirnlos\""),
            new JLabel("\"Idiot\""),
            new JLabel("\"Dumm\""),
            new JLabel("\"Ahnungslos\""),
            new JLabel("\"Normal\""),
            new JLabel("\"Erfolgreich\""),
            new JLabel("\"Schlau\""),
            new JLabel("\"Intelligent\""),
            new JLabel("\"Weise\"")
    };

    private final GridBagConstraints gbc = new GridBagConstraints();

    private void addVSpace(){
        gbc.gridy++;
        add(new JLabel(" "), gbc);
        gbc.gridy++;
    }

    private void initPanel(int stonesLeft){
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setText(stonesLeft + " stones left");
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        add(scoreLabel, gbc);
        addVSpace();
        if (stonesLeft < 10 && stonesLeft > 0){
            add(imageTranslations[9-stonesLeft], gbc);
            addVSpace();
            add(imageLabels[9-stonesLeft], gbc);
        }

    }

    public ScorePanel(int stonesLeft){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 30));
        initPanel(stonesLeft);

        JOptionPane.showMessageDialog(this, this, "Score", JOptionPane.PLAIN_MESSAGE);

    }
}
