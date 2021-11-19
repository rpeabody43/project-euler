import java.io.File;

public class Main {
// Poker hands

    public static void main(String[] args) {
        File handsF = new File ("src\\Hands.txt");
        Hands h = new Hands(handsF);

        String[] test = {"1C", "2C", "3C", "4C", "5C"};
        System.out.println(Poker.flush(test) && Poker.straight(test));
    }
}
