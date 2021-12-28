import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static boolean works (int[] nums) {
        if (nums.length == 0)
            return true;
        for (int x : nums) {
            for (int i : nums) {
                if (i == x && i != 0)
                    continue;
                int concat1 = Integer.parseInt(x + "" + i);
                int concat2 = Integer.parseInt(i + "" + x);
                if (!(Primes.isPrime(concat1) && Primes.isPrime(concat2)))
                    return false;
            }
        }
        return true;
    }

    static int arraySum (int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    static int[] getMinArrSumOfList (ArrayList<int[]> list) {
        int min = arraySum(list.get(0));
        int minIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (arraySum(list.get(i)) < min) {
                min = arraySum(list.get(i));
                minIndex = i;
            }
        }
        return list.get(minIndex);
    }

    static void printArray (int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int[] removeZeros (int[] arr) {
        ArrayList<Integer> nonZeros = new ArrayList<>();
        for (int i : arr)
            if (i != 0)
                nonZeros.add(i);

        int[] ret = new int[nonZeros.size()];
        for (int i = 0; i < nonZeros.size(); i++) {
            ret[i] = nonZeros.get(i);
        }
        return ret;
    }

    private static void helper (ArrayList<int[]> list, int[] current, ArrayList<Integer> allPrimes, int start, int idx, int end) {
        if (!works(removeZeros(current)))
            return;
        if (idx >= end || start >= allPrimes.size()) {
            if (works(current))
                list.add(current);
        } else {
            helper(list, current, allPrimes, start + 1, idx, end);

            int[] temp = current.clone();
            temp[idx] = allPrimes.get(start);
            helper(list, temp, allPrimes, start + 1, idx + 1, end);
        }
    }

    static int[] recursiveGen (int target, ArrayList<Integer> primes) {
        ArrayList<int[]> ret = new ArrayList<>();
        helper(ret, new int[target], primes, 0, 0, target);
        return getMinArrSumOfList(ret);
    }

    public static void main(String[] args) {
        // Prime pair sets

        long startTime = System.currentTimeMillis();


        ArrayList<Integer> allPrimes = Primes.getPrimes(10000);
        int[] answer = recursiveGen(5, allPrimes);
        printArray(answer);
        System.out.println(arraySum(answer));

        double totalTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalTimeSeconds + "s");

    }
}
