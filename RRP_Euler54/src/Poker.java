public class Poker {
    /* Hand types from highest to lowest (If tie the highest card wins)
    Index: Name          - Condition                             X  MX S  F
    N/A: Royal Flush     - T-A all in same suit                 [ ][ ][O][O] (high card handles this one)
    1  : Straight Flush  - All consecutive cards of same suit   [ ][ ][O][O]
    2  : Four of a Kind  - Four cards of same value             [O][ ][ ][ ]
    3  : Full House      - Three of a kind + a pair             [ ][O][ ][ ]
    4  : Flush           - All cards of the same suit           [ ][ ][ ][O]
    5  : Straight        - All consecutive cards                [ ][ ][O][ ]
    6  : Three of a Kind - Three cards of same value            [O][ ][ ][ ]
    7  : Two Pairs       - Two pairs of different cards         [ ][O][ ][ ]
    8  : One Pair        - Two cards of same value              [O][ ][ ][ ]
    9  : High card       - The highest card in hand             [ ][ ][ ][ ]
     */

    public static String maxVal (String str1, String str2) {
        String values = "0123456789TJQKA";
        return String.valueOf(Math.max(values.indexOf(str1), values.indexOf(str2)));
    }

    public static String getMaxOfArray (String[] hand) {
        String values = "123456789TJQKA";
        int maxIndex = 0;
        for (int i = 0; i < hand.length; i++) {
            String str = hand[i].substring(0, 1);
            if (values.indexOf(str) > maxIndex)
                maxIndex = i;
        }
        return hand[maxIndex];
    }

    public static boolean flush (String[] hand) {
        String suit = hand[0].substring(1);
        for (String i : hand) {
            if (!i.substring(1).equals(suit))
                return false;
        }
        return true;
    }

    public static boolean straight (String[] hand) {
        int start = Integer.parseInt(hand[0].substring(0, 1));
        for (int i = 0; i < hand.length; i++) {
            if (Integer.parseInt(hand[i].substring(0, 1)) != start + i)
                return false;
        }
        return true;
    }

    static int score (String[] hand) {
        // Straight Flush
        if (flush(hand) && straight(hand))
            return 1;
        return 0;
    }

    public static int winner (String[] hand1, String[] hand2)

}
