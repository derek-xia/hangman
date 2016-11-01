import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileReader;

class Singleplayer {
    static Scanner sc = new Scanner(System.in);
    private int maxlives = 10;

    public void start(){

        System.out.println("Welcome to Hangman. Please enter a guess:");
        Random rng = new Random();
        String[] words = checkWords();
        String word = words[rng.nextInt(words.length)];
        Integer win = this.guess(word,maxlives);

        switch (win) {
            case 1:
                System.out.println("Congratulations, you won! The word was: " + word);
                break;
            case 2:
                System.out.println("Sorry, you lost. The word was: " + word);
                break;
        }
    }

    public String[] checkWords(){

        try{
            FileReader filereader = new FileReader(new File("WordList.txt"));
            Scanner fileInput = new Scanner(filereader);

            ArrayList<String> wd = new ArrayList<String>();
            fileInput.nextLine(); //skips the first line of text

            while(fileInput.hasNextLine()){
                wd.add(fileInput.nextLine());
            }
            String[] inputwordlist = new String[wd.size()];
            wd.toArray(inputwordlist);
            return inputwordlist;
        }

        catch(FileNotFoundException e){
            System.out.println("Word file not found.");
            String[] inputwordlist = {"pie","sky","heads"};
            return inputwordlist;
        }

        catch(IllegalArgumentException e){
            System.out.println("Add words to the list.");
            String[] inputwordlist = {"pie","sky","heads"};
            return inputwordlist;
        }

    }

    public final Integer guess(String w,int lives){
        int WinLose = 2;
        //default lose
        lives = maxlives;

        char[] SelectedWord = w.toCharArray(); //
        char[] InputtedWord; //string to print out
        InputtedWord = new char[w.length()];

        int charLocation = 0; //
        for(char c:w.toCharArray()){
            if(c == ' ' ){
                InputtedWord[charLocation] = ' ';
                System.out.print(" ");
            }
            if(c == '-' ){
                InputtedWord[charLocation] = '-';
                System.out.print("- ");
            }
            if(c!=' ' && c!='-'){
                InputtedWord[charLocation] = '_';
                System.out.print("_ ");
            } //makes inputted word to underscore and -/space and prints it out

        charLocation++;
        }

        List<Character> AlreadyGuessed = new ArrayList<Character>();

        System.out.print("Lives: ");
        for(int h = 0;h<lives;h++){
            System.out.print("♥");
        }
        System.out.println("   \n ");
        while(lives>0){

            char input = sc.next().charAt(0);
            Boolean guessed = false;
            Boolean repeat = false;
            int curr = 0; //iterator to check through selectedword
            for(int it=0;it<AlreadyGuessed.size();it++){//check for already typed character
                if(input == AlreadyGuessed.get(it)){
                    System.out.println("This letter has already been guessed. Please try another letter.");
                    repeat = true;
                    guessed = true;
                    break;
                }
            }

            for(char C : SelectedWord){
                if (input == SelectedWord[curr] && repeat == false){ //if entered character is equal to any existing value
                    InputtedWord[curr] = input;
                    guessed = true;
                }
                curr++;
            }

            if (!guessed){
                lives--;
            }

            if(repeat==false){
                AlreadyGuessed.add(input);
                System.out.print("Lives: ");
                for(int h = 0;h<lives;h++){
                    System.out.print("♥");
                }
                /*for(int h = 0;h<maxlives-lives;h++){
                    System.out.print(" ♡");
                }*/
                System.out.println("     ");
                for (char C: InputtedWord) {
                    System.out.print(C+" ");
                }
                System.out.println();
            }

            System.out.println("Previously guessed letters:"+AlreadyGuessed+"\n");

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
