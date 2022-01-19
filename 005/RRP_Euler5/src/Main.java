public class Main {
//Smallest Multiple

    public static void main(String[] args) {
        int num = 2520;
        boolean divisible = false;
        while (!divisible) {
            for (int i = 20; i > 10; i--) {
                if (num % i == 0) {
                    if (i == 11) {
                        divisible = true;
                        System.out.println(num);
                    }
                    continue;
                }
                else {num++; break;}
            }
        }

    }
}
