import java.util.*;

class Multiplayer extends Singleplayer{
    public final void start(){
        System.out.println("Welcome to Hangman. Please enter a word:");
        String word = sc.nextLine();
        System.out.println("Now enter the number of lives:");
        int maxlives = sc.nextInt();
        System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+
                "     _    _\n" +
                "    (o)--(o)\n" +
                "   /.______.\\\n" +
                "   \\________/\n" +
                "  ./        \\.\n" +
                " ( .        , )\n" +
                "  \\ \\_\\\\//_/ /\n" +
                "   ~~  ~~  ~~"+
                "\n"+"\n");
        Integer win = this.checkGuesses(word,maxlives);

        switch (win) {
            case 1:
                System.out.println("Congratulations, you won! The word was: " + word);
                break;
            case 2:
                System.out.println("You're bad. The word was: " + word);
                break;
        }
    }

    public Multiplayer(){

    }
}
