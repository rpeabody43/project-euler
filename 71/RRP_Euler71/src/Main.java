
public class Main {
// Ordered fractions

    public static void main(String[] args) {
        // fraction class with numerator, denominator, and decimal form
        // arraylist with every reduced proper fraction where d < 1,000,000
        int range = 1000000;
        double max = (double) 3 / 7;

        int n = 2;
        int d = 5;
        double result = (double) n / d;
        for (int i = 2; i < range; i++) {
            for (int j = (int) (i*result); j < (int) (i*max); j++) {
                double x = (double) j / i;
                if (x < max && x > result) {
                    result = x;
                    n = j;
                    d = i;
                }
            }
        }
        System.out.println(n + "/" + d);
    }
}
