package part3.chap02.baek2250re;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 다시풀기
public class Main {
    static int n;
    static Node[] tree;
    static int[] level_left;
    static int[] level_right;
    static int[] level_max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tree = new Node[n + 1];
        level_left = new int[n + 1];
        level_right = new int[n + 1];
        level_max = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new Node(i);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int node_num = Integer.parseInt(st.nextToken());
            int left_child = Integer.parseInt(st.nextToken());
            int right_child = Integer.parseInt(st.nextToken());

            tree[node_num].left = left_child;
            tree[node_num].right = right_child;

            if (left_child != -1) {
                tree[left_child].parent = node_num;
            }

            if (right_child != -1) {
                tree[right_child].parent = node_num;
            }
        }

        int root = 0;

        for (int i = 1; i <= n; i++) {
            if (tree[i].parent == -1) {
                root = i;
                break;
            }
        }

        int level = 1;

        inorder(root, level);

        int ans_level = 1;
        int ans_width = level_right[1] - level_left[1] + 1;

        for (int i = 2; i <= n; i++) {
            int width = level_right[i] - level_left[i] + 1;

            if (level_max[i] > level_max[ans_level]) {
                ans_level = i;
                ans_width = width;
            } else if (level_max[i] == level_max[ans_level]) {
                if (width > ans_width) {
                    ans_level = i;
                    ans_width = width;
                }
            }
        }

        System.out.println(ans_level + " " + ans_width);
    }

    public static void inorder(int node, int level) {
        if (node == -1) {
            return;
        }

        inorder(tree[node].left, level + 1);

        level_max[level] = Math.max(level_max[level], tree[node].num);

        if (level_left[level] == 0) {
            level_left[level] = tree[node].num;
        }

        level_right[level] = tree[node].num;
        inorder(tree[node].right, level + 1);
        if (level_right[level] == 0) {
            level_right[level] = tree[node].num;
        }
    }
    static class Node {
        int left, right;
        int parent;
        int num;

        public Node(int num) {
            this.num = num;
            this.left = -1;
            this.right = -1;
            this.parent = -1;
        }
    }
}