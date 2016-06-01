/**
 * Created by dna on 6/1/16.
 */
public class battleshipTest {
    public static void main(String[] args) {
        battleship b = new battleship();
        int[] locations = {3,4,5};
        b.setLocations(locations);

        String userGuess = "3";
        String result = b.checkLocation(userGuess);

    }
}
