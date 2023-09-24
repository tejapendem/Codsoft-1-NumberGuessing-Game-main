import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 1016;
        int maxAttempts = 3;
        int playerScore = 0;
        int highestScore = 0;
        int attempts;
        boolean guessedCorrectly;

        System.out.println("Welcome to the Teja's Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            System.out.print("Select difficulty level (1 - Easy, 2 - Medium, 3 - Hard): ");
            int difficultyLevel = scanner.nextInt();

            switch (difficultyLevel) {
                case 1:
                    maxRange = 100;
                    maxAttempts = 5;
                    break;
                case 2:
                    maxRange = 500;
                    maxAttempts = 4;
                    break;
                case 3:
                    maxRange = 1016;
                    maxAttempts = 3;
                    break;
                default:
                    System.out.println("Invalid input. Setting difficulty to Medium.");
                    maxRange = 500;
                    maxAttempts = 4;
                    break;
            }

            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have generated a random number between 1 and " + maxRange + " (inclusive).");

            attempts = 0;
            guessedCorrectly = false;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    guessedCorrectly = true;
                    playerScore += (maxAttempts - attempts + 1);
                    System.out.println("Congratulations! You guessed the correct number!");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you have used all your attempts. The correct number was: " + secretNumber);
            }

            if (playerScore > highestScore) {
                highestScore = playerScore;
                System.out.println("New highest score: " + highestScore);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            if (!playAgain) {
                System.out.println("Thanks for playing Teja's Number Guessing game! Goodbye!");
            }
        }
        scanner.close();
    }
}
