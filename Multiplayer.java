import java.util.*;

class Multiplayer extends Singleplayer{
    public final void start(){
        System.out.println("Welcome to Hangman. Please enter a word:");
        String word = sc.nextLine();
        System.out.println("Now enter the number of lives:");
        int lives = sc.nextInt();

        Integer win = this.guess(word);

        switch (win) {
            case 1:
                System.out.println("Congratulations, you won! The word was: " + word);
                break;
            case 2:
                System.out.println("Sorry, you lost. The word was: " + word);
                break;
        }
    }

    public Multiplayer(){

    }
}
