import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dna on 6/2/16.
 */
public class GameHelper {

    private static final String alphabets = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int [] grid = new int[gridSize];
    private int shipCount = 0;

    public String getInput(String prompt) {
        String input = null;
        System.out.println(prompt + "  ");

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            input = reader.readLine();
            if (input.length() == 0) {
                return null;
            }
        }
        catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return input.toLowerCase();
    }

    public ArrayList<String> placeBattleships(int i) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String [] alphaCoords = new String[i];
        String temp = null;

        int [] coords = new int[i];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        shipCount++;
        int incr = 1;
        if ((shipCount % 2) == 1) {
            incr = gridLength;
        }

        while (!success & attempts++ < 200) {
            location = (int)(Math.random() * gridSize);
            System.out.println("Try locations: " + location);

            int x = 0;
            success = true;
            while (success && x < i) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x>0 && (location % gridLength == 0)) {
                        success = false;
                    }
                }
                else {
                    success = false;
                }
            }
        }

        int x=0;
        int row = 0;
        int col = 0;
        while (x<i) {
            grid[coords[x]] =1;
            row = (int) (coords[x] / gridLength);
            col = coords[x] % gridLength;
            temp = String.valueOf(alphabets.charAt(col));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.println("    Coords " + x + " = " + alphaCells.get(x-1));
        }
        return alphaCells;
    }
}
