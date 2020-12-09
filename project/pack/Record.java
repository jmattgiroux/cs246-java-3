package pack;

import java.util.ArrayList;

import java.util.Scanner;

// w3schools.com/java/java_files_create.asp
import java.io.File;
import java.io.IOException;

// https://www.w3schools.com/java/java_files_read.asp
import java.io.FileNotFoundException;
import java.io.FileWriter;
// https://stackoverflow.com/questions/16751540/sorting-an-object-arraylist-by-an-attribute-value-in-java/43129819
import java.util.Collections;


public class Record {

    // Score nested class
    public class Score {

        // Score class member variables

        String playerName;
        Integer points;

        // default constructor

        public Score(){
            playerName = "-----";
            points = 0;
        }

        // non-default constructor
        // this constructor will be used for when we 
        // parse the high scores file into Scores for
        // our scoresRecord ArrayList
        public Score(String playerName, Integer points)
        {
            this.playerName = playerName;
            this.points = points;

        }
    }

    

    // Record class member variables
    ArrayList<Score> scoresRecord;

    Integer points;

    Scanner scanner;
    
    // default constructor
    public Record()
    {
        //instantiate scoresRecord
        scoresRecord = new ArrayList<Score>();

        //add 10 blank scores to scoresRecord
        for (int i = 0; i < 10; i++)
            scoresRecord.add(new Score());

        // // Done: Comment out block of code below
        // //add 10 increasing scores to scoresRecord
        // for (int i = 0; i < 10; i++)
        //     scoresRecord.add(new Score("" + i, i));

        //set points to 0
        points = 0;

        //update scoresRecord with saved highscores file
        readFile();

        scanner = new Scanner(System.in);

    }

    // member methods

    // reads strings from txt file and puts strings into scoresRecord ArrayList
    public void readFile(){

        //resets scoresRecord before we read in the file
        scoresRecord = new ArrayList<Score>();

        try {
            File file = new File("save.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                Score score = new Score(scanner.next(), scanner.nextInt());
                scoresRecord.add(score);
            }
            scanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File Read Error Occured");
            e.printStackTrace();
        }

    }

    //clears old save file, basically does opposite process
    // of readFile using a similar looping mechanism
    // https://www.w3schools.com/java/java_files_create.asp
    public void writeFile(){
        try {
            FileWriter fileWriter = new FileWriter("save.txt");
            for (int i = 0; i < scoresRecord.size(); i++){
                fileWriter.write(scoresRecord.get(i).playerName +
                                 " " + 
                                 scoresRecord.get(i).points +
                                 "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            // https://www.w3schools.com/java/java_files_create.asp
            System.out.println("Write error occurred.");
            e.printStackTrace();
        }

    }

    // for if no highscores file exists
    // https://www.w3schools.com/java/java_files_create.asp
    public void createFile(){
        try {

        File file = new File("save.txt");
        file.createNewFile();
            
        } catch (IOException e) {
            // https://www.w3schools.com/java/java_files_create.asp
            System.out.println("File Creation Error Occurred");
            e.printStackTrace();
        }

    }

    // https://stackoverflow.com/questions/16751540/sorting-an-object-arraylist-by-an-attribute-value-in-java/43129819
   public void sortScores(){
       scoresRecord.sort((Score s1, Score s2) -> (Integer.compare(s1.points, s2.points)));
   }



    // displays top 10 scores
    public void displayScores(){
        String header = "----- High Scores -----\n" +
                        "-----------------------\n";
        
        sortScores();

        System.out.print(header);
        for (int i = 1; i < 11; i++)
        {
            // TODO: add indents so spacing is regular
            String string = scoresRecord.get(scoresRecord.size() - i).playerName +
                            " || " +
                            scoresRecord.get(scoresRecord.size() - i).points;

            System.out.println(string);
        }

        System.out.print("\n");
    }


    public String promptForName(){

        String prompt = "Please type your name: ";

        System.out.print(prompt);
        System.out.print("\n");

        return scanner.nextLine();

        

    }

    // for after points have been recorded and for if player wants
    // to play again
    public void resetPoints(){

    }

    // calls promptForName, adds a new Score element to our scoresRecord ArrayList
    public void recordScore(){
        //something like
        Score score = new Score(promptForName(), points);
        scoresRecord.add(score);

        

        //writes to file
        writeFile();

        //reads back from file
        readFile();

        // displayScores comes last since that way it will be most apparent if
        // there's an issue
        displayScores();

    }
}

