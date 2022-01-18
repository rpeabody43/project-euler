public class Euler112 {

    public static void main (String[] args) {
        // Bouncy Numbers
        long startTime = System.currentTimeMillis();

        int start = 1;
        System.out.println(new Euler112().run(start, 0.99));

        double totalTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalTimeSeconds + "s");
    }

    public String run (int start, double percent) {
        int ans = 0;
        int bouncy = 0;
        for (int i = start; ans == 0; i++) {
            if (isBouncy(i))
                bouncy++;
            if (bouncy == i * percent)
                ans = i;
        }
        return String.valueOf(ans);
    }

    private boolean isIncreasing (int number) {
        String numAsStr = String.valueOf(number);
        int max = Character.getNumericValue(numAsStr.charAt(0));
        for (int i = 0; i < numAsStr.length(); i++) {
            int currentDigit = Character.getNumericValue(numAsStr.charAt(i));
            if (currentDigit < max)
                return false;
            else max = currentDigit;
        }
        return true;
    }

    private boolean isDecreasing (int number) {
        String numAsStr = String.valueOf(number);
        int min = Character.getNumericValue(numAsStr.charAt(0));
        for (int i = 0; i < numAsStr.length(); i++) {
            int currentDigit = Character.getNumericValue(numAsStr.charAt(i));
            if (currentDigit > min)
                return false;
            else min = currentDigit;
        }
        return true;
    }

    private boolean isBouncy (int number) {
        return !isIncreasing(number) && !isDecreasing(number);
    }

}
