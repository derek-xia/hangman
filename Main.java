import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        System.out.println("To play single-player, enter '1'. To play with 2 players, enter '2'.");
        try {
            int players = sc.nextInt();
            if (players == 1) {
                Singleplayer game = new Singleplayer();
                game.start();
            } else if (players == 2) {
                Multiplayer game = new Multiplayer();
                game.start();
            } else {
                System.out.println(players + " is not a valid number.");
            }

        }
        catch(InputMismatchException e){
            System.out.println("That is not a valid number.");
        }

    }
}
