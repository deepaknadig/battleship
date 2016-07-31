import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dna on 6/1/16.
 */
public class battleshipTest {

    private ArrayList<battleship> battleshipArrayList = new ArrayList<battleship>();
    private int numOfGuesses = 0;
    private GameHelper helper = new GameHelper();

    public static void main(String[] args) {
        battleshipTest game = new battleshipTest();
        game.gameSetup();
        game.startPlay();
    }

    private void gameSetup () {
        battleship first = new battleship();
        first.setName("SS Aurora");

        battleship second = new battleship();
        second.setName("SS Albatross");

        battleship third = new battleship();
        third.setName("SS Titanic");

        battleshipArrayList.add(first);
        battleshipArrayList.add(second);
        battleshipArrayList.add(third);

        System.out.print("To win the game you must sink all three Battle Ships namely: ");
        System.out.println(first.getName() + ", " + second.getName() + ", and " + third.getName());
        System.out.println("You goal is to sink all the Battle Ships in the minimum number of Guesses.");

        for (battleship bs : battleshipArrayList) {
            ArrayList<String> newLocation = helper.placeBattleships(3);
            bs.setLocations(newLocation);
        }
    }

    private void startPlay() {
        while (!battleshipArrayList.isEmpty()) {
            String userGuess = helper.getInput("Enter a Guess: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Miss";

        for (battleship bs : battleshipArrayList) {
            result = bs.checkLocation(userGuess);
            if (result.equals("Hit")) {
                break;
            }
            if (result.equals("Kill")) {
                battleshipArrayList.remove(bs);
                break;
            }
        }
        System.out.println(result);

    }

    private void finishGame() {
        System.out.println("All Battleships have been destroyed!");
        /**
         * Add any additional finish details
         */
    }
}
