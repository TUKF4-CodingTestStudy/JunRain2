package part3.chap02.baek10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<User> list = new ArrayList<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            User user = new User(Integer.parseInt(st.nextToken()), st.nextToken());
            list.add(user);
        }

        Collections.sort(list);

        for (User user : list) {
            System.out.println(user.toString());
        }
    }

    static class User implements Comparable<User> {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(User o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}

