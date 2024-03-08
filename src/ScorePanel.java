import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel{
    private final JLabel scoreLabel = new JLabel("Score: ");
    private final ImageIcon icon = new ImageIcon("data/bilgin.png");
    private final JLabel imageLabel = new JLabel(icon);
    private final GridBagConstraints gbc = new GridBagConstraints();


    public void setScore(int score){
        scoreLabel.setText("Score: " + score);
    }

    private void initScoreLabel(){
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(scoreLabel, gbc);
        gbc.gridy = 1;
        add(new JLabel(" "), gbc);
    }

    private void initScoreImage(int score){
        if (score == 1){
            gbc.gridy = 2;
            add(imageLabel, gbc);
        }
    }

    public ScorePanel(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(500, 250));
        initScoreLabel();
        initScoreImage(0);

    }
}
