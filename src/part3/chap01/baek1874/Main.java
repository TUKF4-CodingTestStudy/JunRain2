package part3.chap01.baek1874;

import java.util.LinkedList;
import java.util.Scanner;

// 뭔지도 모르겠다
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Character> result = new LinkedList<>();
        int n = scanner.nextInt();
        int count = 1;

        for (int i = 1; i < n + 1; i++) {
            int data = scanner.nextInt();
            while (count <= data) {
                stack.push(count);
                count++; // N개의 숫자 모두 스택에 들어갔는지 확인하는 변수.
                result.add('+');
            }
            if (stack.peek() == data) {
                stack.pop();
                result.add('-');
            } else { // count == n && stack.peek != data
                System.out.println("NO");
                return;
            }
        }
        for (char c : result) {
            System.out.println(c);
        }
    }
}

