import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Rockpaperscissor extends Game {
    private JLabel result;
    private JLabel scoreLabel;
    private Random random = new Random();
    private String[] choices = { "Rock", "Paper", "Scissors" };

    public Rockpaperscissor() {
        JFrame frame = new JFrame("Rock Paper Scissors");
        JLabel title = new JLabel("Rock Paper Scissors", JLabel.CENTER);
        result = new JLabel("Choose your move!", JLabel.CENTER);
        scoreLabel = new JLabel("You: 0 | Computer: 0", JLabel.CENTER);

        JButton rock = new JButton("Rock");
        JButton paper = new JButton("Paper");
        JButton scissors = new JButton("Scissors");
        JButton reset = new JButton("Reset Score");

        rock.addActionListener(e -> play("Rock"));
        paper.addActionListener(e -> play("Paper"));
        scissors.addActionListener(e -> play("Scissors"));

        reset.addActionListener(e -> {
            resetScore();
            scoreLabel.setText("You: 0 | Computer: 0");
            result.setText("Choose your move!");
        });

        JPanel panel = new JPanel();
        panel.add(rock);
        panel.add(paper);
        panel.add(scissors);
        panel.add(reset);

        frame.setLayout(new BorderLayout());
        frame.add(title, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(result);
        bottomPanel.add(scoreLabel);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Check who wins
    public String checkWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw!";
        }

        if ((user.equals("Rock") && computer.equals("Scissors")) ||
                (user.equals("Paper") && computer.equals("Rock")) ||
                (user.equals("Scissors") && computer.equals("Paper"))) {
            return "You Win!";
        }
        return "Computer Wins!";
    }

    @Override
    public void play(String userChoice) {
        String computer = choices[random.nextInt(3)];
        String winner = checkWinner(userChoice, computer);

        result.setText("You: " + userChoice + " | Computer: " + computer + " | " + winner);
        updateScore(winner);

        scoreLabel.setText("You: " + getPlayerScore() + " | Computer: " + getComputerScore());
    }

    public static void main(String[] args) {
        new Rockpaperscissor();
    }
}
