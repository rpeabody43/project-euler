public class Euler14 {

    public static void main (String[] args) {
        long startTime = System.currentTimeMillis();

        int range = 1000000;
        System.out.println(new Euler14().run(range));

        double totalTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println(totalTimeSeconds + "s");
    }

    /* test duplicate function
    public static int testLen (long num) {
        System.out.print(num + " -> ");
        if (num <= 1) return 1;

        int ret = 1;
        if (num % 2 == 0)
            ret = testLen(num/2) + 1;
        else ret = testLen(3*num + 1) + 1;

        return ret;
    }
 */

    private int len (long num) {
        if (num <= 1) return 1;

        int ret = 0;
        if (num % 2 == 0)
            ret = len(num/2) + 1;
        else ret = len(3*num + 1) + 1;;
        return ret;
    }

    public String run (int range) {
        int currentMax = 2;
        int currentMaxLen = 0;

        for (int i = 0; i < range; i++) {
            int len = len(i);
            if (len > currentMaxLen) {
                currentMaxLen = len;
                currentMax = i;
            }
        }
        return currentMax + " with a length of " + currentMaxLen;
    }
}
