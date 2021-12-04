public class Main {
//Sum Square Difference

    public static void main(String[] args) {
        int sum = 0;
        int sqrSum = 0;

        for (int i = 1; i < 101; i++) {
            sum += i;
            sqrSum += Math.pow(i, 2);
        }
        sum = (int) Math.pow(sum, 2);
        System.out.println(sum + " - " + sqrSum + " =\n" + (sum - sqrSum));
    }
}
