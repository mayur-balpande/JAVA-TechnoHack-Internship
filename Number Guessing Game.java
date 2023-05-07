import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGuessingGame extends JFrame implements ActionListener {
    
    private int randomNumber;
    private int numGuesses;
    
    private JTextField guessField;
    private JLabel guessLabel;
    private JButton guessButton;
    private JLabel resultLabel;
    private JButton newGameButton;
    
    public NumberGuessingGame() {
        super("Number Guessing Game");
        setLayout(new FlowLayout());
        
        randomNumber = (int) (Math.random() * 100) + 1;
        numGuesses = 0;
        
        guessField = new JTextField(10);
        guessLabel = new JLabel("Enter your guess:");
        guessButton = new JButton("Guess");
        resultLabel = new JLabel("");
        newGameButton = new JButton("New Game");
        
        add(guessLabel);
        add(guessField);
        add(guessButton);
        add(resultLabel);
        add(newGameButton);
        
        guessButton.addActionListener(this);
        newGameButton.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            int guess = Integer.parseInt(guessField.getText());
            numGuesses++;
            if (guess == randomNumber) {
                resultLabel.setText("Congratulations! You guessed the number in " + numGuesses + " guesses!");
                guessButton.setEnabled(false);
            } else if (guess < randomNumber) {
                resultLabel.setText("Your guess is too low. Try again.");
            } else {
                resultLabel.setText("Your guess is too high. Try again.");
            }
        } else if (e.getSource() == newGameButton) {
            randomNumber = (int) (Math.random() * 100) + 1;
            numGuesses = 0;
            guessField.setText("");
            resultLabel.setText("");
            guessButton.setEnabled(true);
        }
    }
    
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
    }
}
