import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dna on 6/1/16.
 */
public class battleshipTest {
    public static void main(String[] args) {
        int numOfGuesses = 0;

        int randomNumber = (int) (5*Math.random());
        ArrayList<String> locations = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            locations.add(Integer.toString(randomNumber));
            randomNumber++;
        }

        battleship b = new battleship();
        b.setLocations(locations);

        GameHelper helper = new GameHelper();

        Scanner reader = new Scanner(System.in);
        Boolean isNotSunk = true;

        while (isNotSunk) {
            String userGuess = helper.getInput("Enter a guess:");

            String result = b.checkLocation(userGuess);
            numOfGuesses += 1;
            if (result.equals("You sunk a Battleship!")) {
                isNotSunk = false;
            }
        }
        System.out.println("You took " + numOfGuesses + " guesses.");

    }
}
