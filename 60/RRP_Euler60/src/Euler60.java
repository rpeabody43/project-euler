import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Euler60 {

    private final int[] primes;

    public Euler60(int range) {
        ArrayList<Integer> tempPrimes = Primes.getPrimes(range);
        primes = new int[tempPrimes.size()];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = tempPrimes.get(i);
        }
    }

    public static void main(String[] args) {
        // Prime pair sets
        long startTime = System.currentTimeMillis();

        int target = 5;
        int range = 10000;

        Euler60 euler60 = new Euler60(range);
//        System.out.println(euler60.new BruteForce().bruteForceRecursive(target));
        System.out.println(euler60.new Iteration().iteration());

        double totalTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalTimeSeconds + "s");

    }

    static boolean works(int[] nums) {
        if (nums.length == 0)
            return true;
        for (int x = 0; x < nums.length; x++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[x])
                    if (i != x) return false;
                    else continue;
                int concat1 = Integer.parseInt(String.valueOf(nums[x]) + nums[i]);
                int concat2 = Integer.parseInt(String.valueOf(nums[i]) + nums[x]);
                if (!(Primes.isPrime(concat1) && Primes.isPrime(concat2)))
                    return false;
            }
        }
        return true;
    }

    private int arraySum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    private int[] getMinArrSumOfList(ArrayList<int[]> list) {
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

    private void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // ! 270.887s or 4min30s
    public class BruteForce {

        private int min = Integer.MAX_VALUE;
        private int[] minArr;

        private int[] removeZeros(int[] arr) {
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

        private void helper(int[] current,  int start, int idx, int end) {
            if (arraySum(current) >= min || !works(removeZeros(current)))
                return;
            if (idx >= end || start >= primes.length) {
                if (arraySum(current) < min && works(current)) {
                    min = arraySum(current);
                    minArr = current.clone();
                }
            } else {
                helper(current, start + 1, idx, end);

                if (primes[start] * 5 < min) {
                    int[] temp = current.clone();
                    temp[idx] = primes[start];
                    helper(temp, start + 1, idx + 1, end);
                }
            }
        }

        public int[] recursiveGen(int target) {
            helper(new int[target], 0, 0, target);
            return minArr;
        }

        public String bruteForceRecursive(int target) {
            int[] answer = recursiveGen(target);
            printArray(answer);
            return String.valueOf(arraySum(answer));
        }
    }

    public class Iteration {
        int min = Integer.MAX_VALUE;
        int[] minArr;

        private boolean arrayContains(int[] arr, int num) {
            for (int i : arr)
                if (i == num) return false;
            return true;
        }

        private int[] concatArray(int[] arr1, int [] arr2) {
            int[] ret = new int[arr1.length + arr2.length];
            System.arraycopy(arr1, 0, ret, 0, arr1.length);
            System.arraycopy(arr2, 0, ret, arr1.length, arr2.length);
            return ret;
        }

        private ArrayList<int[]> helper(ArrayList<int[]> previous, ArrayList<int[]> primes) {
            ArrayList<int[]> ret = new ArrayList<>();
            for (int i = previous.size() - 1; i > 0; i--) {
                int[] pair1 = previous.get(i);
                for (int j = 0; j < primes.size(); j++) {
                    int[] pair2 = primes.get(j);
                    if (pair1 != pair2) {
                        int[] test = concatArray(pair1, pair2);
                        if (works(test))
                            ret.add(test);
                    }
                }
            }
            return ret;
        }

        // ! THIS IS EVEN SLOWER AND I DON'T FEEL LIKE FIXING IT
        public String iteration () {
            ArrayList<int[]> primesAsArrs = new ArrayList<>();
            for (int i : primes) {
                primesAsArrs.add(new int[]{i});
            }

            ArrayList<int[]> pairs = helper(primesAsArrs, primesAsArrs);

            System.out.println("genned 2s");
            ArrayList<int[]> trios = helper(pairs, primesAsArrs);
            System.out.println("genned 3s");
            ArrayList<int[]> quads = helper(trios, primesAsArrs);
            System.out.println("genned 4s");
            ArrayList<int[]> quints = helper(quads, primesAsArrs);
            System.out.println("genned 5s");
            printArray(minArr);
            return (String.valueOf(min));
        }
    }
}
