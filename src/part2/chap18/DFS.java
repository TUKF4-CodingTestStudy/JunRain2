package part2.chap18;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DFS {
    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', List.of('B', 'C'));
        graph.put('B', List.of('A', 'D'));
        graph.put('C', List.of('A', 'G', 'H', 'I'));
        graph.put('D', List.of('B', 'E', 'F'));
        graph.put('E', List.of('D'));
        graph.put('F', List.of('D'));
        graph.put('G', List.of('C'));
        graph.put('H', List.of('C'));
        graph.put('I', List.of('C', 'J'));
        graph.put('J', List.of('I'));

        List<Character> result = dfs(graph, 'A');
        System.out.println("result = " + result);
    }

    private static List<Character> dfs(Map<Character, List<Character>> graph, char startNode) {
        LinkedList<Character> visited = new LinkedList<>();
        LinkedList<Character> needVisited = new LinkedList<>(); // stack

        needVisited.add(startNode);

        while (needVisited.size() != 0) {
            char node = needVisited.remove(needVisited.size()-1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisited.addAll(graph.get(node));
            }
        }
        return visited;
    }
}
