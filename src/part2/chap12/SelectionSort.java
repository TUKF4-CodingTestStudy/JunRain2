package part2.chap12;

import java.util.ArrayList;

public class SelectionSort {
    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int lowest = i;
            for (int j = i + 1; j < list.size() - 1; j++) {
                if (list.get(j) < list.get(lowest)) {
                    lowest = j;
                }
                int buffer = list.get(i);
                list.set(i, list.get((lowest)));
                list.set(lowest, buffer);
            }
        }
    }
}
