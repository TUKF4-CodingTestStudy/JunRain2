package part2.chap15;

import java.util.ArrayList;

public class MergeSort {
    static ArrayList<Integer> mergeSplit(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        int medium = list.size() / 2;
        ArrayList<Integer> left = mergeSplit(new ArrayList<>(list.subList(0, medium))); // 리스트를 잘라줌
        ArrayList<Integer> right = mergeSplit(new ArrayList<>(list.subList(medium, list.size())));

        return merge(left, right);
    }

    static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {

        ArrayList<Integer> merged = new ArrayList<>();

        int leftPoint = 0;
        int rightPoint = 0;

        while (left.size() > leftPoint && right.size() > rightPoint) {
            if (left.get(leftPoint) > right.get(rightPoint)) {
                merged.add(right.get(rightPoint));
                rightPoint++;
            } else {
                merged.add(left.get(leftPoint));
                leftPoint++;
            }
        }
        while (left.size() > leftPoint) {
            merged.add(left.get(leftPoint));
            leftPoint++;
        }
        while (right.size() > rightPoint) {
            merged.add(right.get(rightPoint));
            rightPoint++;
        }

        return merged;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        ArrayList<Integer> merged = mergeSplit(list);
        System.out.println("merged = " + merged);
    }
}
