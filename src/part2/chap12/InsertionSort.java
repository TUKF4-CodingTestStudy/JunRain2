package part2.chap12;

import java.util.ArrayList;

public class InsertionSort {
    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (list.get(j) < list.get(j-1)) {
                    int buffer = list.get(j);
                    list.set(j, list.get((j-1)));
                    list.set(j-1, buffer);
                }
                else break;
            }
        }
    }
}

// 비교하면서 내려가는 부분은 버블정렬과 유사하게 느껴짐
// 하지만 결과적으로 보면 삽입 되는 것이 맞음
// 버블은 뒤로 갈수록 쌓이지만 삽입정렬은 그런거 없이 그냥 자기 자리 찾아가 삽입.

