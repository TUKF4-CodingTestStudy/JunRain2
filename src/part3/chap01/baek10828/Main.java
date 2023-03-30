package part3.chap01.baek10828;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// String.format 보다는 String.valueOf가 훨씬 빠르다.
// StringTokenizer도 빠르다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (stack.size() == 0) sb.append("-1\n");
                    else sb.append(String.valueOf(stack.pop()+"\n"));
                    break;
                case "size":
                    sb.append(String.valueOf(stack.size()+"\n"));
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()) sb.append("-1\n");
                    else sb.append(String.valueOf(stack.peek()+"\n"));
                    break;
            }
        }
        System.out.println(sb);
    }
}

