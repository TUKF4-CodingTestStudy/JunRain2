package part2.chap16;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    static boolean binarySearch(List<Integer> list, int search) {
        if (list.size() == 1 && search == list.get(0)) {
            return true;
        } else if (list.size() == 1 && search != list.get(0)) {
            return false;
        } else if (list.size() == 0) {
            return false;
        }

        int medium = list.size() / 2;
        if (search == list.get(medium)) {
            return true;
        } else {
            if (search > list.get(medium)) {
                return binarySearch(list.subList(medium + 1, list.size()), search);
            } else {
                return binarySearch(list.subList(0, medium),search);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);


        if (binarySearch(list, 11)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
