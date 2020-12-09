package pack;

import pack.Record;

public class Game{

    //member variables

    Integer playerChoice;

    Integer computerChoice;

    boolean donePlaying;

    public Integer playerScore;

    Record record;
    
    //default constructor
    public Game()
    {

    }

    // member methods

    // generate's computer's choice
    public void generateComputerChoice(){

    }

    // uses compare method to see what result to display
    public void displayResultOfMatch(boolean playerIsVictorious){

    }

    // returns trueIfWon
    public boolean playerIsVictorious(){

        return true;
    }

    // increment playerScore
    public void updatePoints(boolean victory){
        //increments record.points
    }

    //prompt player for input, ie their choice between rock, paper, scissors, 
    //or quitting.
    public void prompt(){
        checkIfInputValid();

    }

    // checks whether player's input was valid
    public void checkIfInputValid(){

    }

    public void updateDonePlaying(boolean victory){

    }

    public void promptToRecord(){

        //if statement for if player wants to record score
        record.recordScore();

        record.displayScores();
    }
    

    // loop that runs until the player quits or loses, at which point
    // the program is handed off to the record class which handles
    // high scores and such, until finally the program goes back to main
    public void play(){

        //put below stuff in a while loop that checks for loss or quit
        prompt();

        // below stuff is in if statement that checks whether input was not to quit
        generateComputerChoice();

        // if player lost, we're done playing
        updateDonePlaying(playerIsVictorious());

        // increment points if player won
        updatePoints(playerIsVictorious());

        // display results
        displayResultOfMatch(playerIsVictorious());

        //outside of while loop, ie after the game has ended
        promptToRecord();
    }
}