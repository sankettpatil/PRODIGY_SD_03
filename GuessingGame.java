import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        int userGuess;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Try to guess the number between " + minRange + " and " + maxRange);

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            }

        } while (userGuess != randomNumber);

        scanner.close();
    }
}
//This program generates a random number between 1 and 100 and prompts the user to guess it. It provides feedback if the guess is too high or too low and continues until the user correctly guesses the number. After winning, the program displays the number of attempts it took to win the game