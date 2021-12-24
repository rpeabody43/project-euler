import java.util.ArrayList;

public class Main {

    static String arrayToString (int[] arr) {
        String returnStr = "";
        for (int i : arr) {
            if (i == 10)
                returnStr += '*';
            else
                returnStr += i;
        }
        return returnStr;
    }

    static int[] intToArray(int n) {
        String str = String.valueOf(n);

        int[] ret = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ret[i] = Character.getNumericValue(str.charAt(i));
        }
        return ret;
    }

    static boolean isPrime (int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static int primePairs (int[] arr) {
        String str = arrayToString(arr);

        ArrayList<Integer> replaced = new ArrayList<>();
        for (int n = 1; n < 10; n++) {
            int temp = Integer.parseInt(str.replace('*', String.valueOf(n).charAt(0)));
            replaced.add(temp);
        }

        int primes = 0;
        for (int i : replaced)
            if (isPrime(i))
                primes++;

        return primes;
    }

    static void printArray (int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void helper (ArrayList<int[]> list, int[] num, int start, int target) {
        if (start >= num.length) {
            if (target > 0 && target < num.length - 1) {
                list.add(num);
            }
        } else {
            helper(list, num, start + 1, target);

            int[] temp = num.clone();
            temp[start] = 10;
            helper(list, temp, start + 1, target + 1);
        }
    }

    static ArrayList<int[]> gen (int num) {
        ArrayList<int[]> list = new ArrayList<>();
        helper(list, intToArray(num), 0, 0);
        return list;
    }


    public static void main(String[] args) {
        // Prime digit replacements

        int[] result = new int[5];
        boolean end = false;
        for(int i = 56993; !end; i += 2) {
            if (!isPrime(i))
                continue;
            ArrayList<int[]> list = gen(i);
            for (int[] j : list) {
                if (primePairs(j) >= 8) {
                    result = j;
                    end = true;
                }
            }
        }

        printArray(result);
        boolean found = false;

        int[] minimum = new int[result.length];
        for (int i = 0; i < 10 && !found; i++) {
            minimum = result.clone();
            for (int j = 0; j < minimum.length; j++)
                if (minimum[j] == 10)
                    minimum[j] = i;
            if (isPrime(Integer.parseInt(arrayToString(minimum))))
                found = true;
        }
        printArray(minimum);
    }
}
