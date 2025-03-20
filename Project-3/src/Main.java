import java.util.Scanner;
/**
 * Project 3 Main class
 * @author Thom Rumberger
 */
public class Main {
    /**
     * The 'main' method is the menu, allowing the user to select either the rock paper scissors or guessing games.
     * It also allows the user to select a different (or the same) game after the previous game finished running,
     * with an option to re-display the options they can select from.
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("""
                Hi, in this program you can play 1 of 2 games:\s
                    1. Rock, Paper, Scissors (which should be self explanatory)
                    2. A guessing game, where you have to guess the correct number between zero and some number
                    'Exit' can be used to exit without playing.""");
        boolean cont = false;
        boolean first = true;
        do {
            if (first) {
                System.out.print("\nPlease select one of these games using its corresponding number: ");
                first = false;
            }
            else {
                System.out.print("\nPlease select one of these games using its corresponding number or '3' to relist the options: ");
            }
            String gameInp = scn.next();
            boolean valid = false;
            int game = 0;
            while (!valid) {
                try {
                    game = Integer.parseInt(gameInp);
                    valid = game == 1 || game == 2 || game == 3;
                } catch (NumberFormatException except) {
                    if (gameInp.equalsIgnoreCase("exit")) {
                        game = 4;
                        valid = true;
                    }
                    else {
                        System.out.print("\nNot a valid input, please try again: ");
                        gameInp = scn.next();
                    }
                }
            }
            boolean relist = false;
            switch (game) {
                case 1:
                    RockPaperScissors.rps();
                    break;
                case 2:
                    GuessingGame.guessingGame();
                    break;
                case 3:
                    relist = true;
                    System.out.println("1. Rock, Paper, Scissors\n2. A guessing game\n'Exit' to quit");
                    cont = true;
                    break;
                case 4:
                    relist = true;
                    cont = false;
                    break;
                default:
                    System.out.println("Something went wrong. Sorry.");
                    break;
            }
            if (!relist) {
                System.out.print("Would you like to play a different game? y/n: ");
                String input = scn.next();
                System.out.println();
                boolean playValid = false;
                while (!playValid) {
                    if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                        playValid = true;
                        cont = true;
                    } else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no") ||
                            input.equalsIgnoreCase("exit")) {
                        playValid = true;
                        cont = false;
                    } else {
                        System.out.print("Not a valid input, please try again: ");
                        input = scn.next();
                    }
                }
            }
        } while (cont);
        System.out.println("Ok, see you later!");
    }
}
