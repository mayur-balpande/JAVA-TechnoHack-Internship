import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RockPaperScissors extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel, scoreLabel;
    private int userScore, computerScore;

    public RockPaperScissors() {
        // Set up the window
        setTitle("Rock Paper Scissors");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the buttons
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        // Create the labels
        resultLabel = new JLabel("Choose your move!");
        scoreLabel = new JLabel("Score: You - " + userScore + " Computer - " + computerScore);

        // Add the buttons and labels to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 1));
        contentPane.add(rockButton);
        contentPane.add(paperButton);
        contentPane.add(scissorsButton);
        contentPane.add(resultLabel);
        contentPane.add(scoreLabel);

        // Register the event listeners
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        // Display the window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Determine which button was clicked
        String userMove = "";
        if (e.getSource() == rockButton) {
            userMove = "rock";
        } else if (e.getSource() == paperButton) {
            userMove = "paper";
        } else if (e.getSource() == scissorsButton) {
            userMove = "scissors";
        }

        // Generate a random move for the computer
        String computerMove = "";
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                computerMove = "rock";
                break;
            case 1:
                computerMove = "paper";
                break;
            case 2:
                computerMove = "scissors";
                break;
        }

        // Determine the winner and update the score
        String result = "";
        if (userMove.equals(computerMove)) {
            result = "Tie!";
        } else if (userMove.equals("rock") && computerMove.equals("scissors")
                || userMove.equals("paper") && computerMove.equals("rock")
                || userMove.equals("scissors") && computerMove.equals("paper")) {
            result = "You win!";
            userScore++;
        } else {
            result = "Computer wins!";
            computerScore++;
        }

        // Update the labels
        resultLabel.setText("You chose " + userMove + ", computer chose " + computerMove + ". " + result);
        scoreLabel.setText("Score: You - " + userScore + " Computer - " + computerScore);
    }

    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
    }
}
