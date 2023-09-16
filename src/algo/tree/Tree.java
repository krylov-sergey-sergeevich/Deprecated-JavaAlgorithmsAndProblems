package algo.tree;

import java.util.List;

class Edge {
    int a, b;
}

// DFS
public class Tree {
    private static List<List<Integer>> v;   // связи вершин
    private static List<Integer> d;     // глубина
    private static List<Integer> w;     // кол-во вершин в поддереве

    public static int dfs(int x, int depth, int pred) {
        d.set(x, depth);
        int weight = 1;
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (a == pred) continue;
            weight += dfs(a, depth + 1, x);
        }
        w.set(x, weight);
        return weight;
    }

    public static void dfs(int x) {
        dfs(x, 0, -1);
    }

    public static void main(String[] args) {
        int n = 5;
        int root = 3;

        dfs(root);

    }
}
