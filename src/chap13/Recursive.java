package chap13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Recursive {
    public static void main(String[] args) {
        System.out.println(multiple(10));
        LinkedList<Integer> integers = new LinkedList<>();

        System.out.println("----------------------------------------");

        for (int i = 0; i <= 10; i++) {
            integers.add(i);
        }
        System.out.println("integers = " + integers);
        System.out.println(listAdd(integers));

        System.out.println("----------------------------------------");

        String s = "level";
        if (palindrome(s)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("----------------------------------------");

        func(3);

        System.out.println("----------------------------------------");

        System.out.println(func2(4));

    }

    static int multiple(int num) {
        if (num <= 1) {
            return num;
        } else return num + multiple(--num);
    }

    static int listAdd(LinkedList<Integer> list) {
        if (list.size() <= 1) {
            return list.pop();
        } else {
            return list.pop() + listAdd(list);
        }
    }

    static boolean palindrome(String s) {
        if (s.length() <= 1) {
            return true;
        } else if (s.charAt(0) == s.charAt(s.length()-1)) { // index로 문자 반환.
            return palindrome(s.substring(1, s.length() - 1));// substring으로 문자열 자름.
        }
        return false;
    }

    static int func(int n) {
        if (n == 1) {
            System.out.println(n);
            return n;
        } else if (n % 2 == 0) {
            System.out.println(n);
            return func(n / 2);
        } else {
            System.out.println(n);
            return func(3 * n + 1);
        }
    }

    static int func2(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        return func2(n - 1) + func2(n - 2) + func2(n - 3);
    }
}
