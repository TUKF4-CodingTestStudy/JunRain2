package part2.chap14;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibo(10));

    }

    static int fibo(int n) {
        int[] integers = new int[n + 1];
        integers[0] = 0;
        integers[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            integers[i] = integers[i - 1] + integers[i - 2];
        }
        return integers[n];
    }
}
