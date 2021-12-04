public class Main {
//Largest Palindrome Product

    public static String reverseString(String str) {
        String output = "";
        for (int i = str.length() - 1; i > -1; i--)
            output += str.substring(i, i + 1);
        return output;
    }

    public static boolean isPalindrome(int num) {
        String nString = Integer.toString(num);

        if (nString.length() == 1) {
            return true;
        }

        int half = (int) Math.ceil((double) nString.length() / 2);
        return (nString.substring(0, half + 1).equals(
                reverseString(nString).substring(0, half + 1)));
    }

    public static void main(String[] args) {

        int maxValue = 0;

        for (int y = 999; y > 99; y--) {
            for (int x = 999; x > 99; x--) {
                if (isPalindrome(x * y)) {
                    maxValue = Math.max(x*y, maxValue);
                    System.out.println(x + " x " + y);
                    break;
                }
            }
        }
        System.out.println(maxValue);
    }
}

