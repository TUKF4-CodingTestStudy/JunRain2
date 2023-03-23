package chap12;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    List<Integer> list;
    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j + 1) < list.get(j)) {
                    int buffer = list.get(j);
                    list.set(j, list.get((j + 1)));
                    list.set(j + 1, buffer);
                    swap = true;
                }
                if (swap == false) {
                    break;
                }
            }
        }
    }
}

