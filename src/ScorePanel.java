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

    private void initScoreLabel(int score){
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setText("Score: " + score);
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
        int score = 0;
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(500, 250));
        initScoreLabel(score);
        initScoreImage(score);

    }
}
