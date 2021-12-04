public class Main {
// Highly divisible triangular number

    static int factorsOf(long num) {
        int factors = 0;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors += 2;
            }
        }
        if (Math.sqrt(num) % 1 == 0)
            factors++;
        if (num != 1 && num != 0) {
            factors += 2;
        }
        return factors;
    }

    public static void main(String[] args) {
        long currentVal = 0;
        long end = 0;
        int i = 1;
        int maxFactors = 1;
        while (true) {
            currentVal += i;
            if (factorsOf(currentVal) > maxFactors) {
                maxFactors = factorsOf(currentVal);
                System.out.println(maxFactors + "("+currentVal+")");
            }
            if (factorsOf(currentVal) >= 500) {
                end = currentVal;
                break;
            }
            i++;
        }
        System.out.println(end);
    }
}
