import java.util.ArrayList;

public class Primes {

    private static ArrayList<Integer> l = new ArrayList<>();

    public static boolean isPrime (int num) {
        if (num % 2 == 0 || num <= 1) return false;
        for (int i = 3; i <= Math.sqrt(num); i+=2)
            if (num % i == 0)
                return false;
        return true;
    }

    private static void setList (int range) {
        l.clear();
        for (int i = 0; i < range; i++)
            if (isPrime(i))
                l.add(i);
    }

    public static ArrayList<Integer> getPrimes (int range) {
        if (l.size() != range) {
            setList(range);
        }
        return l;
    }

}
