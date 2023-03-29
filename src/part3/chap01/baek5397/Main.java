package part3.chap01.baek5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String password = br.readLine();
            LinkedList<Character> leftList = new LinkedList<>();
            LinkedList<Character> rightList = new LinkedList<>();

            for(int j = 0; j < password.length(); j++) {
                char buffer = password.charAt(j);

                if (buffer == '<') {
                    if(!leftList.isEmpty()) rightList.push(leftList.pop());
                } else if (buffer == '>') {
                    if(!rightList.isEmpty()) leftList.push(rightList.pop());
                } else if (buffer == '-') {
                    if(!leftList.isEmpty()) leftList.pop();
                } else {
                    leftList.push(buffer);
                }
            }
            Collections.reverse(leftList);
            List<Character> result = new LinkedList<>();
            result.addAll(leftList);
            result.addAll(rightList);
            for (char s: result) {
               sb.append(s);
            }
            System.out.println(sb);
        }
    }
}

// 처음 푼 방식
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//        for (int i = 0; i < n; i++) {
//            String password = scanner.nextLine();
//            LinkedList<Character> list = new LinkedList<>();
//
//            for (int j = 0; j < password.length(); j++) {
//                char currentCharacter = password.charAt(j);
//                list.add(currentCharacter);
//            }
//
//            LinkedList<Character> result = new LinkedList<>();
//            int index = 0;
//            while (!list.isEmpty()) {
//                char buffer = list.pop();
//
//                if (buffer == '<') {
//                    if(index != 0) index--;
//                } else if (buffer == '>') {
//                    if(index != result.size()) index++;
//                } else if (buffer == '-') {
//                    result.remove(--index);
//                } else {
//                    result.add(index++, buffer);
//                }
//            }
//            for (char s: result) {
//                System.out.print(s);
//            }
//            System.out.println();
//        }
//    }
//}
