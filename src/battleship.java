/**
 * Created by dna on 6/1/16.
 */
public class battleship {

    private int[] locations;
    private int numOfHits = 0;

    public void setLocations(int[] locations) {
        this.locations = locations;
    }

    public String checkLocation(int stringGuess) {
        int guess = stringGuess;

        String result = "Miss!";
        for (int cell:this.locations) {
            if (guess == cell) {
                result = "Hit!";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == this.locations.length) {
            result = "You sunk a Battleship!";
        }
        System.out.println(result);

        return result;
    }
}
