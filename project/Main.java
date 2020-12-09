import pack.Game;

public class Main {

    // member variables
    static Game game;


    // our program; it prompts user in a loop.
    // user chooses between playing, seeing high scores, or quitting
    // upon choosing to quit, loop is exited and program ends with a cheery message

    public static void main(String[] args) {
        
        game = new Game();

        while (!game.quitProgram){
            game.play();
        }

    }

}