import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    /* Hand types from highest to lowest (If tie the highest card wins)
    Index: Name          - Condition                             X  MX S  F
    1  : Royal Flush     - T-A all in same suit                 [ ][ ][O][O] (high card handles this one)
    2  : Straight Flush  - All consecutive cards of same suit   [ ][ ][O][O]
    3  : Four of a Kind  - Four cards of same value             [O][ ][ ][ ]
    4  : Full House      - Three of a kind + a pair             [ ][O][ ][ ]
    5  : Flush           - All cards of the same suit           [ ][ ][ ][O]
    6  : Straight        - All consecutive cards                [ ][ ][O][ ]
    7  : Three of a Kind - Three cards of same value            [O][ ][ ][ ]
    8  : Two Pairs       - Two pairs of different cards         [ ][O][ ][ ]
    9  : One Pair        - Two cards of same value              [O][ ][ ][ ]
    10 : High card       - The highest card in hand             [ ][ ][ ][ ]
     */

    /**
     * Sorts the hand from the lowest card to highest
     * @param hand the hand to be processed
     * @return the sorted hand
     */
    public static ArrayList<Integer> sortedList (String[] hand) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (String i : hand)
            indexes.add(cardIndex(i));
        Collections.sort(indexes);
        Collections.reverse(indexes);
        return indexes;
    }

    /**
     * Determines the highest of two cards regardless of suit
     * @param card1 first card
     * @param card2 second card
     * @return the higher of the two cards in form of string
     */
    public static String maxVal (String card1, String card2) {
        card1 = card1.substring(0, 1);
        card2 = card2.substring(0, 1);
        String values = "0123456789TJQKAn";
        return String.valueOf(Math.max(values.indexOf(card1), values.indexOf(card2)));
    }

    /**
     * Gets the highest card from an array
     * @param hand the array of cards to be processed
     * @return The string of the highest card
     */
    public static String getMaxOfArray (String[] hand) {
        return Character.toString("0123456789TJQKAn".charAt(sortedList(hand).get(0)));
    }

    /**
     * Determines what the unique values are
     * @param hand hand to be processed
     * @return String arraylist with the unique values
     */
    static ArrayList<Integer> uniqueVals (String[] hand) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> l = sortedList(hand);
        for (int i : l) {
            boolean uniqueVal = true;
            for (int j : result) {
                if (i == j) {
                    uniqueVal = false;
                    break;
                }
            }
            if (uniqueVal)
                result.add(i);
        }
        return result;
    }

    /**
     * Determines the priority of the card value
     * @param card the card to be processed
     * @return 0-14 from 1 to Ace
     */
    public static int cardIndex(String card) {
        return "0123456789TJQKAn".indexOf(card.substring(0, 1));
    }

    /**
     * Determines how many of each unique value there are
     * @param hand hand to be processed
     * @return Integer arraylist with vals corresponding to uniqueVal(hand)
     */
    static ArrayList<Integer> amounts (String[] hand) {
        ArrayList<Integer> vals = uniqueVals(hand);

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (result.size() != vals.size()) {
            result.add(0);
        }

        for (String i : hand) {
            int x = cardIndex(i);
            for (int j = 0; j < vals.size(); j++) {
                if (x == vals.get(j))
                    result.set(j, result.get(j) + 1);
            }
        }
        return result;
    }

    //region Winning Hands
    /**
     * Determines if hand is a flush
     * @param hand the hand to be processed
     * @return T/F if is flush
     */
    public static boolean flush (String[] hand) {
        String suit = hand[0].substring(1);
        for (String i : hand) {
            if (!i.substring(1).equals(suit))
                return false;
        }
        return true;
    }

    /**
     * Determines if hand is a straight
     * @param hand the hand to be processed
     * @return T/F if is straight
     */
    public static boolean straight (String[] hand) {
        ArrayList<Integer> indexes = sortedList(hand);
        for (int i = 1; i < indexes.size(); i++) {
            if (indexes.get(i) != indexes.get(i - 1) - 1)
                return false;
        }
        return true;
    }

    /**
     * Determines the highest amount of alike cards
     * @param hand the hand to be processed
     * @return 1-4, from no pairs to four of a kind
     */
    static int ofKind (String[] hand) {
        return Collections.max(amounts(hand));
    }

    /**
     * Returns an int corresponding to a 'two pair' or 'full house' hand
     * @param hand hand to be processed
     * @return 1: nothing 2: two pair, 3: full house
     */
    static int multOfKind (String[] hand) {
        ArrayList<Integer> a = amounts(hand);
        Collections.sort(a);
        Collections.reverse(a);

        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(3);
        test.add(2);
        if (a.equals(test))
            return 3;

        test = new ArrayList<Integer>();
        test.add(2);
        test.add(2);
        test.add(1);
        if (a.equals(test))
            return 2;
        return 1;
    }

    public static int fourOfKind (String[] hand) {
        return (ofKind(hand) == 4) ? sortedList(hand).get(3) : 0;
    }

    /**
     * Determines if the hand is a full house
     * @param hand The hand to be processed
     * @return T/F if hand is a full house
     */
    public static int fullHouse (String[] hand) {
        return (multOfKind(hand) == 3) ? threeOfKind(hand) : 0;
    }

    public static int threeOfKind (String[] hand) {
        return (ofKind(hand) == 3) ? sortedList(hand).get(3) : 0;
    }

    /**
     * Determines if the hand has two pairs
     * @param hand The hand to be processed
     * @return T/F if hand has two pairs
     */
    public static int twoPair(String[] hand) {
        return (multOfKind(hand) == 2) ? pair(hand) : 0;
    }

    public static int pair (String[] hand) {
        return (ofKind(hand) == 2) ? uniqueVals(hand).get(amounts(hand).indexOf(2)) : 0;
    }

    //endregion

    /**
     * Determines the 'score' of the hand in order of priority 1-10
     * Lower is better
     * @param hand the hand to be processed
     * @return 1-10 priority, from royal flush to high card
     */
    static int[] score (String[] hand) {
        // Royal Flush / Straight Flush
        if (flush(hand) && straight(hand)) {
            return (getMaxOfArray(hand).charAt(0) == 'A') ?
                    new int[] {1, cardIndex(getMaxOfArray(hand))} :
                    new int[] {2, cardIndex(getMaxOfArray(hand))};
        }
        // Four of a Kind
        if (fourOfKind(hand) != 0)
            return new int[] {3, fourOfKind(hand)};
        // Full House
        if (fullHouse(hand) != 0)
            return new int[] {4, fullHouse(hand)};
        // Flush
        if (flush(hand))
            return new int[] {5, cardIndex(getMaxOfArray(hand))};
        // Straight
        if (straight(hand))
            return new int[] {6, cardIndex(getMaxOfArray(hand))};
        // Three of a Kind
        if (threeOfKind(hand) != 0)
            return new int[] {7, threeOfKind(hand)};
        // Two Pair
        if (twoPair(hand) != 0)
            return new int[] {8, twoPair(hand)};
        // One Pair
        if (pair(hand) != 0)
            return new int[] {9, pair(hand)};
        return new int[] {10, cardIndex(getMaxOfArray(hand))};
    }

    /**
     * Determines the player who won the hand
     * @param hand1 The first player's hand
     * @param hand2 The second player's hand
     * @return 1, 2, or 0 if tie
     */
    public static int winner (String[] hand1, String[] hand2) {
        int[] score1 = score(hand1);
        int[] score2 = score(hand2);

        if (score1[0] == score2[0]) {
            if (score1[1] != score2[1])
                return (score1[1] > score2[1]) ? 1 : 2;
            else return 0;
        }
        return (score1[0] < score2[0]) ? 1 : 2;
    }
}
