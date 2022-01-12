import java.util.HashMap;

public class Euler14 {

    public static void main (String[] args) {
        long startTime = System.currentTimeMillis();

//        int range = 1000000;
//        System.out.println(new Euler14().run(range));
        int test = testLen(910107);
        System.out.println();
        System.out.println(test);

        double totalTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalTimeSeconds + "s");
    }

    private final HashMap<Integer, Integer> lens;

    public Euler14 () {
        lens = new HashMap<>();
    }

    public static int testLen (int num) {
        System.out.print(num + " ");
        if (num <= 1) return 1;

        int ret = 1;
        if (num % 2 == 0)
            ret = testLen(num/2) + 1;
        else ret = testLen(3*num + 1) + 1;

        return ret;
    }

    private int len (int num) {
//        if (lens.containsKey(num)) return lens.get(num);
        if (num <= 1) return 0;

        int ret = 0;
        if (num % 2 == 0)
            ret = len(num/2) + 1;
        else ret = len(3*num + 1) + 1;
//        lens.put(num, ret);
        return ret;
    }

    public String run (int range) {
        int currentMax = 2;
        int currentMaxLen = 0;

        for (int i = 1; i < range; i++) {
            int len = len(i);
            if (len > currentMaxLen) {
                currentMaxLen = len;
                currentMax = i;
            }
        }
//        System.out.println(lens);
        return currentMax + " with a length of " + currentMaxLen;
    }
}
