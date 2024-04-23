import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Rock, Paper, Scissors!");
            char playerAMove = getValidMove(in, "Player A, enter your move [R/P/S]: ");
            char playerBMove = getValidMove(in, "Player B, enter your move [R/P/S]: ");

            displayResults(playerAMove, playerBMove);

            if (!playAgain(in)) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

        in.close();
    }

    public static char getValidMove(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String move = scanner.nextLine().trim().toLowerCase();
            if (move.equals("r") || move.equals("p") || move.equals("s")) {
                return move.charAt(0);
            } else {
                System.out.println("Invalid move. Please choose R, P, or S.");
            }
        }
    }

    public static void displayResults(char playerAMove, char playerBMove) {
        if (playerAMove == playerBMove) {
            System.out.println(Character.toUpperCase(playerAMove) + " vs " + Character.toUpperCase(playerBMove) + " - It's a tie!");
        } else if ((playerAMove == 'r' && playerBMove == 's') ||
                (playerAMove == 'p' && playerBMove == 'r') ||
                (playerAMove == 's' && playerBMove == 'p')) {
            System.out.println(Character.toUpperCase(playerAMove) + " beats " + Character.toUpperCase(playerBMove) + " - Player A wins!");
        } else {
            System.out.println(Character.toUpperCase(playerBMove) + " beats " + Character.toUpperCase(playerAMove) + " - Player B wins!");
        }
    }

    public static boolean playAgain(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to play again? [Y/N]: ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                return true;
            } else if (choice.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter Y or N.");
            }
        }
    }
}
