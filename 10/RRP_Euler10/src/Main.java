public class Main {
//Summation of Primes
    static boolean isPrime(int num) {
        for (int i = 2; i < (int) (Math.sqrt(num) + 1); i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long sum = 2;
        for (int i = 3; i < 2000000; i+=2) {
            if (isPrime(i)) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
