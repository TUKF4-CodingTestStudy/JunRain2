package part3.chap02.baek1543;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        String n = br.readLine();
//
//        char[] sChar = s.toCharArray();
//        char[] nChar = n.toCharArray();
//
//        int count = 0;
//        int i = 0;
//
//        if(s.length() > 2500 || n.length() > 2500) {
//            System.out.println("문자열의 길이는 2500을 넘을 수 없습니다.");
//            return;
//        }
//
//        for (char tmp : sChar) {
//            if (tmp == nChar[i]) {
//                i++;
//            } else {
//                i = 0;
//            }
//            if (i == nChar.length) {
//                count++;
//                i = 0;
//            }
//        }
//
//        System.out.println(count);
//    }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String n = br.readLine();

        int count = 0;
        int index = 0;

        while (index <= s.length() - n.length()) {
            // index는 탐색을 시작할 위치.
            if (s.startsWith(n, index)) { // 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크하는 함수이다. index가 계속 변하기 때문에 count가 늘어난다.
                count++;
                index += n.length();
            } else {
                index++;
            }
        }

        System.out.println(count);
    }
}
