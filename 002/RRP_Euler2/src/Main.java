public class Main {
//Even Fibonacci Numbers

    public static void main(String[] args) {
        int x = 1;
        int y = 0;

        int count = 0;
        int sum = 0;
        while (count < 4000000){
            count = x + y;
            y = x;
            x = count;
            if (count%2 == 0) {
                sum += count;
            }
        }
        System.out.println(sum);

    }
}
