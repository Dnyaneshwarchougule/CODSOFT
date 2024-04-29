import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guess the Number!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        int attemptsLimit = 5;
        int roundNumber = 1;
        int totalAttempts = 0;

        while (true) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nRound " + roundNumber);
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts!");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == attemptsLimit) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("\nTotal attempts: " + totalAttempts);
                System.out.println("Thank you for playing!");
                break;
            }

            roundNumber++;
        }
        scanner.close();
    }
}