import java.util.List;

public class Cyclical {
    public static boolean isCyclical (int[] nums) {
        int prev = nums[nums.length - 1];
        for (int num : nums) {
            if (num / 100 != prev % 100) return false;
            prev = num;
        }
        return true;
    }

    public static boolean isCyclical (List<Integer> nums) {
        int prev = nums.get(nums.size() - 1);
        for (int num : nums) {
            if (num / 100 != prev % 100) return false;
            prev = num;
        }
        return true;
    }

    public static boolean partialCyclical (int[] nums) {
        if (nums.length <= 1) return true;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) return true;
            if (num / 100 != prev % 100) return false;
            prev = num;
        }
        return true;
    }
}
