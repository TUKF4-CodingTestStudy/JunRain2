package chap15;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) return list;
        int pivot = list.get(0);

        List<Integer> left = new LinkedList<>();
        List<Integer> equalArr = new LinkedList<>();
        List<Integer> right = new LinkedList<>();

        for (int num : list) {
            if (num < pivot) left.add(num);
            else if (num > pivot) right.add(num);
            else equalArr.add(num);
        }

        return Stream.of(quickSort(left), equalArr, quickSort(right))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}

