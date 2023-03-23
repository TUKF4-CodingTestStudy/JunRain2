package part2.chap16;

import java.util.List;

public class SequentialSearch {
    static boolean sequential(List<Integer> list, int search) {
        for (int integer : list) {
            if (integer == search) {
                return true;
            }
        }
        return false;
    }
}
