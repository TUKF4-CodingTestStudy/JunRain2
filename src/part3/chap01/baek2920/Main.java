package part3.chap01.baek2920;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        boolean ascending = true, descending = true;
        for (int i = 0; i < 8; i++) {
            list.add(scanner.nextInt());
        }

        for (int i = 0; i < 7; i++) {
            if (list.get(i) - list.get(i + 1) > 0) {
                ascending = false;
            } else {
                descending = false;
            }
        }
        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }

}
