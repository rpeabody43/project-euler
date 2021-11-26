import java.io.File;

public class Main {
// Poker hands

    public static void main(String[] args) {
        File handsF = new File ("src\\Hands.txt");
        Hands h = new Hands(handsF);

        int player1Score = 0;
        for (int i = 1; i < h.length() + 1; i++) {
            String[][] l = h.getLine(i);
            System.out.print("p1: " + String.join(", ", l[0]) +
                    " | p2: " + String.join(", ", l[1]) + " | Winner: ");

            if (Poker.winner(l[0], l[1]) == 1) {
                System.out.print("p1: ");
                System.out.print(Poker.score(l[0])[0] + ", " + Poker.score(l[0])[1]);
                player1Score++;
            }
            else if (Poker.winner(l[0], l[1]) == 2) {
                System.out.print("p2: ");
                System.out.print(Poker.score(l[1])[0] + ", " + Poker.score(l[1])[1]);
            }
            System.out.println();
        }
        System.out.println(player1Score);

    }
}
