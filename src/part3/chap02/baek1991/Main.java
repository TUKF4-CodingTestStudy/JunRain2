package part3.chap02.baek1991;

import java.util.*;

public class Main {
    static Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 지우기

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            char parent = s.charAt(0);
            char leftChild = s.charAt(2);
            char rightChild = s.charAt(4);

            // 노드 생성
            if (i == 0) {
                root = new Node(parent);
            }
            Node parent_node = search(root, parent);

            if (leftChild != '.') {
                parent_node.left = new Node(leftChild);
            }
            if (rightChild != '.') {
                parent_node.right = new Node(rightChild);
            }
        }

        // 전위 순회
        preorder(root);
        System.out.println();

        // 중위 순회
        inorder(root);
        System.out.println();

        // 후위 순회
        postorder(root);
        System.out.println();
    }

    // 트리에서 해당 데이터를 갖는 노드를 찾는 메소드
    public static Node search(Node root, char data) {
        if (root == null) { // 노드가 null 이면
            return null;
        }
        if (root.data == data) {// 노드 자신이면
            return root;
        }
        Node left = search(root.left, data); // 왼쪽 자식 노드
        if (left != null) {//왼쪽 노드가 비어있으면
            return left;
        }
        Node right = search(root.right, data);// 오른쪽 자식 노드
        if (right != null) {// 오른쪽 자식 노드가 비어있으면
            return right;
        }
        return null;
    }

    // 전위 순회
    public static void preorder(Node node) {
        System.out.print(node.data);
        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node.left != null) {
            inorder(node.left);
        }
        System.out.print(node.data);
        if (node.right != null) {
            inorder(node.right);
        }
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        System.out.print(node.data);
    }

    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
