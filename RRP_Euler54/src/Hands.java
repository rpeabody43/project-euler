import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hands {

    File f;
    String[][][] hands = new String[1000][2][5]; //[Row (0 - 999)][Player (0 - 1)][Card (0 - 4)]
    public Hands (File file) {
        f = file;
        // Scan through each line of the doc
        // Each line is an array
        // Within each line are two arrays one per player, each 5 cards
        // All of this encapsulated in a massive array

        try {
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[][] lineArr; // looks like {{cardArr1} {cardArr2}}
                String p1Str = line.substring(0, 14);
                String p2Str = line.substring(15);
                // now these two strings are the individual player hands for that line
                // we can split them into arrays
                String[] cardArr1; // looks like {"8C", "TS", "KC", "9H", "4S"}
                String[] cardArr2; // looks like {"7D", "2S", "5D", "3S", "AC"}

                cardArr1 = p1Str.split(" ");
                cardArr2 = p2Str.split(" ");
                lineArr = new String[][]{cardArr1, cardArr2};

                hands[i] = lineArr;
                i++;
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("FnF");
            System.exit(0);
        }
    }

    public void print(int length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            result += i + ": ";
            for (String[] j : hands[i]) {
                for (String k : j) {
                    result += k + " ";
                }
                result += " | ";
            }
            result += "\n";
        }
        System.out.println(result);
    }

    public String[][] getLine (int line) {
        return hands[line];
    }
}