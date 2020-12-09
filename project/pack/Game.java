package pack;

import pack.Record;

import java.util.Scanner;

public class Game{

    //member variables

    Integer playerChoice;

    Integer computerChoice;

    boolean donePlaying;

    public Integer playerScore;

    Record record;

    public boolean quitProgram;

    static Integer mainMenuChoice;

    Scanner scanner;


    // play, see high scores, or quit
    String openingMessage;

    // message for when player quits
    String endMessage;

    
    //default constructor
    public Game()
    {

        quitProgram = false;

        // https://www.w3schools.com/java/java_user_input.asp
        scanner = new Scanner(System.in);

        record = new Record();

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
        if (victory)
            record.points++;
    }

    //prompt player for input, ie their choice between rock, paper, scissors, 
    //or quitting.
    public void playPrompt(){

        String prompt = "Please choose move:\n" +
                        "1: Rock\n" + 
                        "2: Paper\n" +
                        "3: Scissors\n" +
                        "4: Quit\n\n" +
                        "Choice: ";

        String reprompt = "Please input valid choice\n";

        boolean valid = false;

        //code to reprompt if not allowed input
        while (!valid){
            System.out.print(prompt);
            playerChoice = getUserInput();
            valid = checkIfInputValid(playerChoice, 4);
            if (!valid)
                System.out.print(reprompt);
        }
        

    }

    // checks whether player's input was valid
    public boolean checkIfInputValid(Integer input, Integer range){

        return true;
    }

    public void updateDonePlaying(boolean victory){
        if (!victory)
            donePlaying = true;

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

        //prompt for main menu in a while loop
        while (!quitProgram)
        {
            mainMenuPrompt();
            
            //put below stuff in a while loop that checks for loss or quit
            while (!donePlaying){
                
                playPrompt();
        
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
                
    }

        //while loop that checks for quitProgram
        //player chooses between play, quit, or see record by
        // being prompted for mainScreenChoice

    public void mainMenuPrompt(){

        String prompt = "Please choose:\n" +
                        "1: Play Rock Paper Scissors\n" + 
                        "2: See High Scores\n" +
                        "3: Quit Program\n\n" +
                        "Choice: ";

        String reprompt = "Please input valid choice\n";

        boolean valid = false;

        //code to reprompt if not allowed input
        while (!valid){
            System.out.print(prompt);
            mainMenuChoice = getUserInput();
            valid = checkIfInputValid(mainMenuChoice, 3);
            if (!valid)
                System.out.print(reprompt);
        }

    }


    // method to get user input for various methods
    public Integer getUserInput(){
        // integer is set to 0 in case no numerical input is detected.
        // this will result in the input being seen as invalid by
        // checkIfInputValid, hence the user will be reprompted
        Integer integer = 0;
        integer = scanner.nextInt();
        return integer;
    }
}