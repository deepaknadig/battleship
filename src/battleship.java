import java.util.ArrayList;

/**
 * Created by dna on 6/1/16.
 */
public class battleship {

    private ArrayList<String> locations;
    private String name;
    private int numOfHits = 0;

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String checkLocation(String stringGuess) {
        String result = "Miss!";

        int idx = this.locations.indexOf(stringGuess);
        if (idx >= 0) {
            this.locations.remove(idx);

            if (this.locations.isEmpty()) {
                result = "Kill";
                System.out.println("You sunk a the Battleship " + name + "!");
            }
            else {
                result = "Hit!";
                numOfHits++;
            }
        }

//        System.out.println(result);

        return result;
    }

    public String getName() {
        return name;
    }
}
