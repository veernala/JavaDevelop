import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100. Can you guess it?");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + secretNumber);
                System.out.println("You took " + attempts + " attempts.");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Hint: Try a higher number.");
            } else {
                System.out.println("Hint: Try a lower number.");
            }
        } while (true);

        scanner.close();
    }
}
