public class Euler62 {
// Cubic permutations

    public static void printArr (int[] arr) {
        System.out.print("[");
        for (int i : arr) System.out.print(i);
        System.out.println("]");
    }

    public static boolean isPermutation (long first, long second) {
        if ((int) Math.log10(first) != (int) Math.log10(second)) return false;
        
        int[] firstCounts = new int[10];
        while (first > 0) {
            firstCounts[(int) (first % 10)]++;
            first /= 10;
        }

        int[] secondCounts = new int[10];
        while (second > 0) {
            int num = (int) (second % 10);
            secondCounts[num]++;
            if (secondCounts[num] > firstCounts[num])
                return false;
            
            second /= 10;
        }
        return true;
    }

    public static long[] cubesInRange (long range) {
        long[] ret = new long[(int) Math.cbrt((double) range)];
        for (int i = 0; i < ret.length; i++)
            ret[i] = (long)i*i*i;
        return ret;
    }

    public long solve (int perms) {
        int max = 0;
        long[] cubes = cubesInRange(Long.MAX_VALUE);
        for (int i = 0; i < cubes.length; i++) {
            long cube = cubes[i];
            int count = 0;
            for (int j = i; j < cubes.length && cubes[j] < (long) Math.pow(10, (long) Math.log10(cube) + 1); j++) {
                // System.out.println(cube + ", " + cubes[j]);
                if (isPermutation(cube, cubes[j])) count++;
                if (count >= perms) return cube;
            }
            if (count > max) max = count;
        }
        System.out.println(max);
        return -1;
    }

    public static void main (String[] args) {
        long startTime = System.currentTimeMillis();
        
        Euler62 p062 = new Euler62();
        System.out.println(p062.solve(5));
        
        double totalTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalTimeSeconds + "s");
        // System.out.println(isPermutation(125, 216));
    }
}