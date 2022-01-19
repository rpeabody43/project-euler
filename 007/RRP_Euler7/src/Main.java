public class Main {
//10001st Prime

    static boolean isPrime (int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int target = 10001;
        int count = 1;
        int currentVal = 3;
        int lastPrime = 3;

        while (count < target) {
            if (isPrime(currentVal)) {
                lastPrime = currentVal;
                count++;
            }
            currentVal += 2;
        }
        System.out.println(lastPrime);

    }
}
