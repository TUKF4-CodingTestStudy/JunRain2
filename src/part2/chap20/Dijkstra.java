package part2.chap20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// 자바 자료형을 이용해서 파이썬처럼 구현할 수 있을까?
public class Dijkstra {
    public static void main(String[] args) {
        PriorityQueue<Graph> list = new PriorityQueue<>();

        HashMap<Character, List<Graph>> myGraph = new HashMap<>();
        myGraph.put('A', List.of(new Graph('B',8),new Graph('C',1),new Graph('D',2)));
        myGraph.put('B', new ArrayList<>());
        myGraph.put('C', List.of(new Graph('B',5),new Graph('D',2)));
        myGraph.put('D', List.of(new Graph('E',3),new Graph('F',5)));
        myGraph.put('E', List.of(new Graph('F',1)));
        myGraph.put('F', List.of(new Graph('A',5)));

    }

    // static List<Graph> dijkstra(HashMap<Character, List<Graph>> graph, char start)



}

class Graph implements Comparable<Graph> {

    char nodeName;
    int value;
    List<Graph> nextVertex;

    public Graph(char nodeName, int value) {
        this.nodeName = nodeName;
        this.value = value;
    }

    public char getNodeName() {
        return nodeName;
    }

    public int getValue() {
        return value;
    }

    // 올림차순으로 정렬.
    @Override
    public int compareTo(Graph o) {
        return value - o.value;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodeName=" + nodeName +
                ", value=" + value +
                '}';
    }
}