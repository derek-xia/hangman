import java.util.*;

class Singleplayer {
    static Scanner sc = new Scanner(System.in);
    private int lives = 10;
    static String[] words = {"pie","sky","heads"};

    public void start(){
        System.out.println("Welcome to Hangman. Please enter a guess:");
        Random rng = new Random();
        String word = words[rng.nextInt(words.length)];
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
    public final Integer guess(String w){
        int lettersGuessed = 0;
        char[] SelectedWord= w.toCharArray();
        char[] InputtedWord;
        int WinLose = 2;
        InputtedWord = new char[w.length()];
        List<String> WrongGuess = new ArrayList<String>();

        System.out.print("Lives: " + lives + "    ");
        for (int a = 0; a<w.length(); a++){
            InputtedWord[a] = '_';
            System.out.print("_ ");
        }
        System.out.println();
        while(lives>0){

            char input = sc.next().charAt(0);
            Boolean guessed = false;
            int curr = 0;
            for(char C : SelectedWord){
                if (input == SelectedWord[curr]){
                    InputtedWord[curr] = input;
                    guessed = true;
                }
                curr++;
            }
            if (!guessed){
                lives--;
                WrongGuess.add(String.valueOf(input));
            }

            System.out.print("Lives: " + lives + "    ");
            for (char C: InputtedWord) {
                System.out.print(C+" ");
            }
            System.out.println();

            if (Arrays.equals(InputtedWord,SelectedWord)){
                WinLose = 1;
                lives = -1;
            }

        }
        return WinLose;
    }

    public Singleplayer (){

    }
}
