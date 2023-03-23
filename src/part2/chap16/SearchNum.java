package part2.chap16;

import java.util.Arrays;
import java.util.List;

public class SearchNum {
    public static void main(String[] args) {
        int[] n = {4, 1, 5, 2, 3};
        int[] m = {1, 3, 7, 9, 5};

        Arrays.stream(n).sorted();

        for (int i : m) {
            System.out.println(binarySearch(n, i));
        }
    }


    static int binarySearch(int[] list, int search) {
        if (list.length == 1 && search == list[0]) {
            return 1;
        } else if (list.length == 1) {
            return 0;
        } else if (list.length == 0) {
            return 0;
        }

        int medium = list.length / 2;
        if (search == list[medium]) {
            return 1;
        } else {
            if (search > list[medium]) {
                return binarySearch(Arrays.copyOfRange(list, medium + 1, list.length), search);
            } else {
                return binarySearch(Arrays.copyOfRange(list, 0, medium), search);
            }
        }
    }
}
