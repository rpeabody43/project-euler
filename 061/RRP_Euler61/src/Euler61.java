import polygonal.*;

import java.util.ArrayList;
import java.util.List;

public class Euler61 {
    // Cyclical figurate numbers

    int[][] numbers;

    public Euler61() {
        numbers = new int[6][];
        Polygon[] polygons = Polygon.polygons();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = polygons[i].inRange(1000, 10000);
        }
    }

    private void helper (List<int[]> possibilities, Polygon[] polygons, int[] working, int start, int[] targets, int target) {
        if (target >= polygons.length) {
            possibilities.add(working);
            return;
        }
        if (start >= numbers[targets[target]].length) return;
        int test = numbers[targets[target]][start];
        int[] temp = working.clone();
        temp[target] = test;
        if (Cyclical.partialCyclical(temp))
            helper(possibilities, polygons, temp, 0, targets, target + 1);
        helper(possibilities, polygons, temp, start + 1, targets, target);
    }

    private int[] generate () {
        List<int[]> possibilites = new ArrayList<>();
        Polygon[] polygons = Polygon.polygons();
        List<int[]> fact = factorial(6);
        for (int[] i : fact)
            helper(possibilites, polygons, new int[polygons.length], 0, i, 0);


        for (int[] nums : possibilites) {
            if (Cyclical.isCyclical(nums)) return nums;
        }
        return new int[] {-1};
    }

    private static void factHelper (List<int[]> combos, int[] nums, int start) {
        if (start >= nums.length) {
            combos.add(nums.clone());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;

            factHelper(combos, nums, start + 1);

            temp = nums[start];
            nums[start] = nums[i];
            nums[i] = temp;
        }
    }

    private static List<int[]> factorial (int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++)
            numbers[i] = i;
        List<int[]> combos = new ArrayList<>();
        factHelper(combos, numbers, 0);
        return combos;
    }

    private static void printArr (int[] arr) {
        String print = "[";
        for (int num : arr) {
            print += num + ",";
        }
        print = print.substring(0, print.length() - 1) + "]";
        System.out.println(print);
    }

    private String solve () {
        int[] result = generate();
        printArr(result);
        int sum = 0;
        for (int i : result)
            sum += i;
        return String.valueOf(sum);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Euler61 p061 = new Euler61();
        System.out.println(p061.solve());

        double totalTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalTimeSeconds + "s");
    }
}
