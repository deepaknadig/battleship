import java.util.Scanner;

/**
 * Created by dna on 6/1/16.
 */
public class battleshipTest {
    public static void main(String[] args) {
        int numOfGuesses = 0;

        int randomNumber = (int) (5*Math.random());
        int[] locations = {randomNumber, randomNumber+1,randomNumber+2};

        battleship b = new battleship();
        b.setLocations(locations);

        Scanner reader = new Scanner(System.in);
        Boolean isNotSunk = true;

        while (isNotSunk) {
            System.out.println("Enter a Guess!");
            int userGuess = reader.nextInt();
            String result = b.checkLocation(userGuess);
            numOfGuesses += 1;
            if (result.equals("You sunk a Battleship!")) {
                isNotSunk = false;
            }
        }
        System.out.println("You took " + numOfGuesses + " guesses.");

    }
}
