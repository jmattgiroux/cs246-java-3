package pack;

import pack.Record;

// https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
import java.util.Random;
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

        // https://www.w3schools.com/java/java_user_input.asp
        scanner = new Scanner(System.in);

        record = new Record();

    }

    // member methods

    // updates computer's choice
    public void updateComputerChoice(){
        Random random = new Random();
        computerChoice = (random.nextInt() % 3) + 1;
    }

    // uses compare method to see what result to display
    public void displayResultOfMatch(Integer result){

        String win = "\nYou win! + 1 Points!\n" + 
                     "Total Points: " + record.points +
                     "\n\n";

        String tie = "\nTie! No change in points!\n\n";

        String loss = "\nYou lose! Game Over!\n" +
                      "Final Score: " + record.points + 
                      "\n\n";

        if (result == 1)
            System.out.print(win);
        
        if (result == 2)
            System.out.print(tie);

        if (result == 3)
            System.out.print(loss);

    }

    // returns trueIfWon
    public Integer compare(){

        // 1: Rock
        // 2: Paper
        // 3: Scissors

        if ((computerChoice % 3) == (playerChoice - 1))
        {
            // 1 is win
            return 1;
        }

        else if (computerChoice == playerChoice)
            // 2 is tie
            return 2;

        else 
            // 3 is loss
            return 3;
    }

    // increment playerScore
    public void updatePoints(Integer result){
        //increments record.points
        // 1 is victory
        if (result == 1)
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

        String reprompt = "Please input valid choice\n\n";

        boolean valid = false;

        //code to reprompt if not allowed input
        while (!valid){
            System.out.print(prompt);
            playerChoice = getUserInput();
            System.out.print("\n");
            valid = checkIfInputValid(playerChoice, 4);
            if (!valid)
                System.out.print(reprompt);
        }
        

    }

    // checks whether player's input was valid
    public boolean checkIfInputValid(Integer input, Integer range){

        return (input > 0 && input < (range + 1));
    }

    public void updateDonePlaying(Integer result){
        if (result == 3 || playerChoice == 4)
            donePlaying = true;

    }

    public void updateQuitProgram(Integer input)
    {
        quitProgram = input == 3;
    }

    public void recordPrompt(){

        String prompt = "Would you like to record your score?\n" +
                        "1: Yes\n" + 
                        "2: No\n" +
                        "Choice: ";

        String reprompt = "Please input valid choice\n\n";

        boolean valid = false;

        //code to reprompt if not allowed input
        while (!valid){
            System.out.print(prompt);
            playerChoice = getUserInput();
            System.out.print("\n");
            valid = checkIfInputValid(playerChoice, 2);
            if (!valid)
                System.out.print(reprompt);
        }
        //if statement for if player wants to record score
        if (playerChoice == 1)
            record.recordScore();
    }

    

    // loop that runs until the player quits or loses, at which point
    // the program is handed off to the record class which handles
    // high scores and such, until finally the program goes back to main
    public void play(){


        //prompt for main menu in a while loop
        while (!quitProgram)
        {
            mainMenuPrompt();
            updateQuitProgram(mainMenuChoice);

            if (!quitProgram && mainMenuChoice == 2){
                record.displayScores();
            }

            
            if (!quitProgram && mainMenuChoice == 1){
                
                //reset donePlaying
                donePlaying = false;

                //put below stuff in a while loop that checks for loss or quit
                while (!donePlaying){
                
                    playPrompt();
            
                    // below stuff is in if statement that checks whether
                    // input was not to quit
                    updateComputerChoice();
            
                    // if player lost, we're done playing
                    updateDonePlaying(compare());
            
                    // increment points if player won
                    updatePoints(compare());
            
                    // display results
                    displayResultOfMatch(compare());                    
                }

                //outside of while loop, ie after the game has ended
                recordPrompt();
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
        try {
        integer = scanner.nextInt();
        } catch (Exception e) { 

            // infinite loop fix attempt 1: Failure
            // resets scanner in order to prevent infinite loop
            // ^see commit history, search "infinite loop"
            // scanner.reset();
            // ^ Doesn't fix infinite loop

            // infinite loop fix attempt 2: Success
            // https://stackoverflow.com/questions/1794281/java-infinite-loop-using-scanner-in-hasnextint
            scanner.next();

            // TODO: Bug where user only inputs ' ' or '\n'. 
            // This doesn't break anything, but until an actual character
            // is input, it just spaces the cursor forward and down until
            // the user inputs a character followed by pressing Enter
        }
        return integer;
    }
}