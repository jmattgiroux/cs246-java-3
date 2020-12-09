package pack;

import java.util.ArrayList;

public class Record {

    // Score nested class
    public class Score {

        // Score class member variables

        String playerName;
        Integer points;

        // default constructor

        public Score(){

        }

        // non-default constructor
        // this constructor will be used for when we 
        // parse the high scores file into Scores for
        // our scoresRecord ArrayList
        public Score(String playerName, Integer points)
        {

        }
    }

    Integer points;

    // Record class member variables
    ArrayList<Score> scoresRecord;
    
    // default constructor
    public Record()
    {
        //instantiate scoresRecord
        scoresRecord = new ArrayList<Score>();

        //set points to 0
        points = 0;

        //update scoresRecord with saved highscores file
        readFile();

    }

    // member methods

    // reads strings from txt file and puts strings into scoresRecord ArrayList
    public void readFile(){

    }

    //clears old save file, basically does opposite process
    // of readFile using a similar looping mechanism
    public void writeFile(){

    }

    // for if no highscores file exists
    public void createFile(){

    }

    // displays top 10 scores
    public void displayScores(){

    }


    public String promptForName(){

        return " ";
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

    }
}

