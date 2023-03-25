package part2.chap21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.awt.geom.Rectangle2D.union;

public class Kruskal {
    static HashMap<Character, Character> parent = new HashMap<>();
    static HashMap<Character, Integer> rank = new HashMap<>();


    public static void main(String[] args) {
        List<Character> vertices = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G');
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(7, 'A', 'B'));
        edges.add(new Edge(5, 'A', 'D'));
        edges.add(new Edge(7, 'B', 'A'));
        edges.add(new Edge(8, 'B', 'C'));
        edges.add(new Edge(9, 'B', 'D'));
        edges.add(new Edge(7, 'B', 'E'));
        edges.add(new Edge(8, 'C', 'B'));
        edges.add(new Edge(5, 'C', 'E'));
        edges.add(new Edge(5, 'D', 'A'));
        edges.add(new Edge(9, 'D', 'B'));
        edges.add(new Edge(7, 'D', 'E'));
        edges.add(new Edge(6, 'D', 'F'));
        edges.add(new Edge(7, 'E', 'B'));
        edges.add(new Edge(5, 'E', 'C'));
        edges.add(new Edge(7, 'E', 'D'));
        edges.add(new Edge(8, 'E', 'F'));
        edges.add(new Edge(9, 'E', 'G'));
        edges.add(new Edge(6, 'F', 'D'));
        edges.add(new Edge(8, 'F', 'E'));
        edges.add(new Edge(11, 'F', 'G'));
        edges.add(new Edge(9, 'G', 'E'));
        edges.add(new Edge(11, 'G', 'F'));


        List<Edge> edges1 = kruskal(edges, vertices);
        System.out.println("edges1 = " + edges1);
    }


    static List<Edge> kruskal(List<Edge> edges, List<Character> vertices) {
        List<Edge> mst = new ArrayList<>();

        for (char vertex : vertices) {
            makeSet(vertex);
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            int weight = edge.getValue();
            char startNode = edge.getStartVertex();
            char endNode = edge.getEndVertex();

            if (find(startNode) != find(endNode)) {
                union(startNode, endNode);
                mst.add(edge);
            }
        }
        return mst;
    }

    private static void union(char startNode, char endNode) {
        char root1 = find(startNode);
        char root2 = find(endNode);

        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (rank.get(root1).equals(rank.get(root2))) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    private static char find(char node) {
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    private static void makeSet(char vertex) {
        parent.put(vertex, vertex);
        rank.put(vertex, 0);
    }
}

class Edge implements Comparable<Edge> {
    int value;
    char startVertex;
    char endVertex;

    public Edge(int value, char startVertex, char endVertex) {
        this.value = value;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "value=" + value +
                ", startVertex=" + startVertex +
                ", endVertex=" + endVertex +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return value - o.value;
    }

    public int getValue() {
        return value;
    }

    public char getStartVertex() {
        return startVertex;
    }

    public char getEndVertex() {
        return endVertex;
    }
}