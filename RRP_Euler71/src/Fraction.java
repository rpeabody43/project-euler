import java.util.ArrayList;

public class Fraction {
    private int n;
    private int d;
    private final double decimal;

    //region Constructors
    /**
     * set numerator and denominator with simplify option
     * @param numerator > 0
     * @param denominator > 0
     * @param s should fraction be simplified at construction?
     */
    public Fraction (int numerator, int denominator, boolean s) {
        n = numerator;
        d = denominator;
        decimal = (double) n / d;
        if (s) simplify();
    }

    /**
     * set numerator and denominator and auto simplify
     * @param numerator > 0
     * @param denominator > 0
     */
    public Fraction (int numerator, int denominator) {
        n = numerator;
        d = denominator;
        decimal = (double) n / d;
        simplify();
    }
    //endregion

    private static ArrayList<Integer> factors (int num) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= num; i++)
            if (num % i == 0)
                result.add(i);
        return result;
    }

    /**
     * Precondition 0 < n < d
     * @param n < d
     * @param d > n
     * @return The greatest common factor
     */
    private static int GCF (int n, int d) {
        ArrayList<Integer> dFactors = factors(d);
        ArrayList<Integer> nFactors = factors(n);
        for (int i  = nFactors.size() - 1; i >= 0; i--) {
            if (dFactors.contains(nFactors.get(i))) {
                return nFactors.get(i);
            }
        }
        System.out.println("either 0 was entered or you fucked up");
        return 0;
    }

    public int getN () {
        return n;
    }
    public int getD () {
        return d;
    }
    public double getDecimal (){
        return decimal;
    }

    public void simplify () {
        int gcf = GCF(n, d);
        n /= gcf;
        d /= gcf;
    }

    public boolean equals (Fraction f) {
        return (f.getDecimal() == getDecimal());
    }
    public String toString () {
        return n + "/" + d;
    }
}
