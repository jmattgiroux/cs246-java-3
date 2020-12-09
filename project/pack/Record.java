package pack;

import java.util.ArrayList;

public class Record {

    // Score nested class
    public class Score {

        // Score class member variables

        String playerName;
        Integer score;

        // default constructor

        public Score(){

        }

        // non-default constructor
        // this constructor will be used for when we 
        // parse the high scores file into Scores for
        // our scoresRecord ArrayList
        public Score(String playerName, Integer score)
        {

        }
    }

    // Record class member variables
    ArrayList<Score> scoresRecord;
    
    // default constructor
    public Record()
    {

    }

    // member methods

    // reads strings from txt file and puts strings into
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


    public void promptForName(){

    }

    // calls promptForName, adds a new Score element to our scoresRecord ArrayList
    public void recordScore(){
        //something like
        // Score score = new Score(promptForName(), score);
        //scoresRecord.add(score);

    }
}

