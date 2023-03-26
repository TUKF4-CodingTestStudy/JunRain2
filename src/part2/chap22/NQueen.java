package part2.chap22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class NQueen {
    static List<LinkedList<Integer>> solveNQueens(int n) {
        LinkedList<LinkedList<Integer>> finalResult = new LinkedList<>();
        dfs(n, 0, new LinkedList<Integer>(), finalResult);
        return finalResult;
    }

    static void dfs(int n, int currentRow, LinkedList<Integer> currentCandidate, LinkedList<LinkedList<Integer>> finalResult) {
        if (currentRow == n) {
            finalResult.add((LinkedList<Integer>) currentCandidate.clone());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isAvailable(currentCandidate, i)) {
                currentCandidate.add(i);
                dfs(n, currentRow + 1, currentCandidate, finalResult);
                currentCandidate.remove(currentCandidate.size()-1);
            }
        }
    }

    private static boolean isAvailable(LinkedList<Integer> candidate, int currentCol) {
        int currentRow = candidate.size();
        for (int i = 0; i < currentRow; i++) {
            if (candidate.get(i) == currentCol || abs(candidate.get(i) - currentCol) == currentRow - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("solveNQueens(4) = " + solveNQueens(4));

    }
}
