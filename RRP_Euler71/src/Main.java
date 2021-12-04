import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
// Ordered fractions

    static boolean containsFraction (ArrayList<Fraction> arrayList, Fraction fraction) {
        return arrayList.stream().anyMatch(f -> f.getDecimal() == fraction.getDecimal());
    }

    public static void main(String[] args) {
        // fraction class with numerator, denominator, and decimal form
        // arraylist with every reduced proper fraction where d < 1,000,000
        int range = 1000000;
        double max = (double) 3 / 7;
        double min = (double) 2 / 5;
        ArrayList<Fraction> fractionList = new ArrayList<>();
        for (int i = 2; i < range; i++) {
            if (i % 1000 == 0) System.out.println(i);
            for (int j = 1; j < i; j++) {
                if ((double) j / i > min && (double) j / i < max && !containsFraction(fractionList, new Fraction(j, i))) {
                    fractionList.add(new Fraction(j, i));
                }
            }
        }
        fractionList.sort(Comparator.comparing(Fraction::getDecimal));
        System.out.println(fractionList.get(fractionList.size() - 1));
    }
}
