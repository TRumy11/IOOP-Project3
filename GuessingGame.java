import java.util.*;

public class GuessingGame {
    public static void guessingGame () {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        boolean play = false;
        do {
            System.out.print("Please input a number to guess between zero and: ");
            String boundString = scn.next();
            int bound = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    bound = Integer.parseInt(boundString);
                    valid = bound > 0;
                } catch (NumberFormatException except) {
                    System.out.print("\nNot a valid input, please try again: ");
                    boundString = scn.next();
                }
            }
            int correct = rnd.nextInt(1, bound);
            System.out.printf("\nOk, I'm thinking of a number between 0 and %d. It cannot be zero.\n" +
                    "Can you guess what it is in 5 tries?\n", bound);
            int guessNum = 0;
            int guess = 0;
            boolean win = false;
            while (guessNum < 5) {
                guessNum += 1;
                System.out.printf("Guess %d: ", guessNum);
                String inp = scn.next();
                boolean validInp = false;
                while (!validInp) {
                    try {
                        guess = Integer.parseInt(inp);
                        validInp = guess > 0 && guess <= bound;
                    } catch (NumberFormatException except) {
                        System.out.print("\nNot a valid input, please try again: ");
                        inp = scn.next();
                    }
                }
                if (correctGuess(guess, correct)) {
                    win = true;
                    break;
                }
            }
            if (!win) {
                System.out.printf("Sorry, the correct answer was %d. Better luck next time.\n", correct);
            }

            System.out.print("\nPlay again? y/n: ");
            String input = scn.next();
            System.out.println();
            boolean playValid = false;
            while (!playValid) {
                if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                    playValid = true;
                    play = true;
                }
                else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                    playValid = true;
                    play = false;
                }
                else {
                    System.out.print("Not a valid input, please try again: ");
                    input = scn.next();
                }
            }
        } while(play);
    }

    public static boolean correctGuess (int guess, int correct) {
        boolean correctGuess = false;
        if (guess > correct) {
            System.out.println("Too high, try again.");
        }
        else if (guess < correct) {
            System.out.println("Too low, try again.");
        }
        else {
            System.out.println("Awesome! You got it.");
            correctGuess = true;
        }
        return correctGuess;
    }
}
