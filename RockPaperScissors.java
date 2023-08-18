import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock, Paper, Scissors!");

        String[] choices = {"rock", "paper", "scissors"};

        while (true) {
            System.out.print("Enter your choice (rock, paper, scissors, or quit to exit): ");
            String userChoice = scanner.next().toLowerCase();

            if (userChoice.equals("quit")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter rock, paper, scissors, or quit.");
                continue;
            }

            int computerChoiceIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
                    || (userChoice.equals("paper") && computerChoice.equals("rock"))
                    || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("Congratulations! You win!");
            } else {
                System.out.println("Oops! You lose. Better luck next time!");
            }
        }

        scanner.close();
    }
}
