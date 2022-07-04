import java.math.BigInteger;

public class Euler65 {

    private BigInteger[] nums;

    public Euler65 (int range) {
        nums = new BigInteger[range];
        nums[0] = BigInteger.valueOf(2);
        nums[1] = BigInteger.valueOf(3);
    }

    private BigInteger solveRecurs (int n) {
        if (nums[n] != null) return nums[n];
        int k = (n % 3 == 2) ? 2*((n+1)/3) : 1;
        BigInteger ret = solveRecurs(n-1).multiply(BigInteger.valueOf(k));
        nums[n] = ret.add(solveRecurs(n-2));
        return nums[n];
    }

    
    public int solve () {
        BigInteger num = solveRecurs(nums.length-1);
        System.out.println(num);
        return digitSum(num);
    }

    private static int digitSum (BigInteger n) {
        int sum = 0;
        while (n.compareTo(BigInteger.ZERO) == 1) {
            sum += n.mod(BigInteger.TEN).intValue();
            n = n.divide(BigInteger.TEN);
        }
        return sum;
    }

    public static void main (String[] args) {
        int range = 100;
        Euler65 p065 = new Euler65(range);
        System.out.println(p065.solve());
    }
}