import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final String winMessage = "You win!";
    private final String loseMessage = "You lose!";
    private final String drawMessage = "Draw!";

    private Scanner read = new Scanner(System.in);
    private Random selector = new Random();
    private static Map<Integer, String> hands = new HashMap<>();
    private int playerPoints = 0;
    private int computerPoints = 0;

    public static void main(String[] args) {

        Game game = new Game();
        hands.put(1, "Rock");
        hands.put(2, "Paper");
        hands.put(3, "Scissors");

        game.callGame();

    }

    public void play() {

        boolean isPlaying = false;
        boolean startedGame = false;

        while(!isPlaying) {
            if(playerPoints == 5) {
                System.out.println("\nYou have defeated the computer!");
                System.out.println("Would you like to play again? [Yes] [No]");
                String choice = read.nextLine();
                if(choice.equalsIgnoreCase("yes")) {
                    playerPoints = 0;
                    computerPoints = 0;
                    callGame();
                } else {
                    System.out.println("Thanks for playing!");
                    System.exit(1);
                }
            } else if(computerPoints == 5) {
                System.out.println("\nYou have been defeated by the computer!");
                System.out.println("Would you like to play again? [Yes] [No]\n");
                String choice = read.nextLine();
                if(choice.equalsIgnoreCase("yes")) {
                    callGame();
                } else {
                    System.out.println("Thanks for playing!");
                    System.exit(1);
                }
            }
            
            System.out.println("Please select a hand: ");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");

            String choice = read.nextLine();
            if(choice.equals("0")) {
                System.exit(1);
            } else if(!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                System.out.println("Please enter a valid selection.");
                play();
            }else {
                String computer = new String();
                int computerChoice = 0;
                computerChoice = selector.nextInt(1, 3);
                computer = hands.get(computerChoice);

                if(choice.equals("1")) {

                    if(computer.equals("Rock")) {
                        System.out.println("Draw!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    } else if(computer.equals("Paper")) {
                        computerPoints++;
                        System.out.println("You lose!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    } else if(computer.equals("Scissors")) {
                        playerPoints++;
                        System.out.println("You win!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    }

                } else if(choice.equals("2")) {

                    if(computer.equals("Rock")) {
                        playerPoints++;
                        System.out.println("You win!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    } else if(computer.equals("Paper")) {
                        System.out.println("Draw!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    } else if(computer.equals("Scissors")) {
                        computerPoints++;
                        System.out.println("You lose!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    }

                } else if(choice.equals("3")) {

                    if(computer.equals("Rock")) {
                        computerPoints++;
                        System.out.println("You lose!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    } else if(computer.equals("Paper")) {
                        playerPoints++;
                        System.out.println("You win!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    } else if(computer.equals("Scissors")) {
                        System.out.println("Draw!");
                        System.out.println("Computer Score: " + computerPoints + " | " + "Your Score: " + playerPoints);
                        play();
                    }

                }
            }
        }
    }

    public void callGame() {
        playerPoints = 0;
        computerPoints = 0;
        System.out.println("See if you can get five points before the computer!");
        play();
    }

}
