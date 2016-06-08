import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dna on 6/2/16.
 */
public class GameHelper {
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

        return input;
    }
}
