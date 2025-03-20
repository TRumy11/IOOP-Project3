import java.util.*;
import java.util.Dictionary;

public class RockPaperScissors {
    public static void rps() {
        Random rnd = new Random();
        Scanner scn = new Scanner(System.in);
        boolean play = false;
        do {
            System.out.print("What would you like to throw?  1. Rock  2. Paper  3. Scissors: ");
            String inp = scn.next();
            System.out.println();
            int playerChoice = 0;
            boolean valid = false;
            while (!valid) {
                try {
                    playerChoice = Integer.parseInt(inp);
                    valid = playerChoice > 0 && playerChoice <= 3;
                } catch (NumberFormatException except) {
                    switch (inp.toLowerCase()) {
                        case "rock":
                            playerChoice = 1;
                            valid = true;
                            break;
                        case "paper":
                            playerChoice = 2;
                            valid = true;
                            break;
                        case "scissors":
                            playerChoice = 3;
                            valid = true;
                            break;
                        default:
                            break;
                    }
                }
                if (!valid) {
                    System.out.print("Not a valid input, please try again: ");
                    inp = scn.next();
                }
            }
            System.out.println(playerChoice);
            int compChoice = rnd.nextInt(1,4);
            System.out.println(compChoice);
            winner(playerChoice, compChoice);
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
        } while (play);
    }
    public static void winner (int pChoice, int cChoice) {
        // 1:Rock, 2:Paper, 3:Scissors
        int wdl = 0; // 1:Win, 2:Draw, 3:Loss
        if (pChoice == cChoice) {
            wdl = 2;
        }
        else if (pChoice == 1 && cChoice == 3) {
            wdl = 1;
        }
        else if (pChoice == 3 && cChoice == 1) {
            wdl = 3;
        }
        else if (pChoice == (cChoice + 1)) {
            wdl = 1;
        }
        else if ((pChoice + 1) == cChoice){
            wdl = 3;
        }
        Dictionary<Integer, String> rps = new Hashtable<>();
        rps.put(1, "Rock"); rps.put(2, "Paper"); rps.put(3, "Scissors");
        System.out.printf("You threw: %s\n vs.\nThe opponent's: %s\n\n", rps.get(pChoice), rps.get(cChoice));
        switch (wdl) {
            case 1:
                System.out.println("You win, congrats!");
                break;
            case 2:
                System.out.println("It's a draw!");
                break;
            case 3:
                System.out.println("You lose, too bad.");
                break;
            default:
                System.out.println("Something went wrong.");
                break;
        }
    }
}
