import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;

           
            System.out.println("\nGuess the number between " + minRange + " and " + maxRange + ":");
            
            for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                System.out.print("Attempt " + attempts + ": ");
                int userGuess = scanner.nextInt();

                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += attempts;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
                }
            }

          
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("no")) {
                break;
            }
        } while (true);

       
        System.out.println("Your total score is: " + score);

        scanner.close();
    }
}
/* OUTPUT
Welcome to the Number Guessing Game!

Guess the number between 1 and 100:
Attempt 1: 50
Too low! Try again.
Attempt 2: 60
Too low! Try again.
Attempt 3: 70
Too low! Try again.
Attempt 4: 80
Too low! Try again.
Attempt 5: 90
Too low! Try again.
Attempt 6: 100
Too high! Try again.
Attempt 7: 95
Too high! Try again.
Attempt 8: 94
Too high! Try again.
Attempt 9: 93
Congratulations! You guessed the correct number.
Do you want to play again? (yes/no): */