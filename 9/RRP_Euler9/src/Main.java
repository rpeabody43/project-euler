public class Main {
    //Special Pythagorean Triplet

    public static void main(String[] args) {
        //loop through list of every triplet < 1000,
        //check if the sum is 1000, then check if it's a pythagorean triplet
        outerloop :
        for (int c = 5; c < 1001; c++) {
            for (int b = 4; b < 1000; b++) {
                for (int a = 3; a < 999; a++) {
                    if (a + b + c == 1000 && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                        System.out.println(a +" "+ b +" "+ c);
                        System.out.print(a*b*c);
                        break outerloop;
                    }
                }
            }
        }
    }
}
