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

    private static int T = 0;       // время
    private static List<Integer> t_in;      // время входа
    private static List<Integer> t_out;     // время выхода

    public static int dfs(int x, int depth, int pred) {
        t_in.set(x, T++);
        d.set(x, depth);
        int weight = 1;
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (a == pred) continue;
            weight += dfs(a, depth + 1, x);
        }
        w.set(x, weight);
        t_out.set(x, T++);
        return weight;
    }

    public static void dfs(int x) {
        dfs(x, 0, -1);
    }

    /**
     * Функция проверки является ли одна вершина в поддереве другой.
     *
     * @param from от какой вершины смотрим вниз
     * @param who  какую вершину ищем в поддереве
     * @return true - есть, false - нет
     */
    public static boolean is_in_subtree(int from, int who) {
        // who is in subtree from
        if ((t_in.get(who).compareTo(t_in.get(from))) < 0) {
            return false;
        }
        if ((t_out.get(who).compareTo(t_out.get(from))) > 0) {
            return false;
        }
        return true;
    }

    private List<Integer> order;
    private List<Integer> first;    // массив первого вхождения
    private List<Integer> last;    // массив последнего вхождения

    /**
     * Алгоритм DFS заточенный под поиск LCA (Least Common Ancestor).
     */
    public void dfs2(int x, int depth, int pred) {
        d.set(x, depth);
        first.set(x, order.size());
        order.add(x);
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (a == pred) continue;
            order.add(x);
        }
        last.set(x, order.size());
        order.add(x);
    }

    /**
     * LCA.
     *
     * @param x первая вершина
     * @param y вторая вершина
     * @return наименьший общий предок
     */
    public int get_lca(int x, int y) {
        int l = first.get(x);
        if (first.get(y) < l) {
            l = first.get(y);
        }
        int r = last.get(x);
        if (last.get(y) > r) {
            r = last.get(y);
        }
        int ans = 0;
        int D = d.get(x);   // предварительно ставим просто
        for (int i = l; i <= r; i++) {
            if (d.get(order.get(i)) < D) {
                D = d.get(order.get(i));
                ans = order.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int root = 3;

        dfs(root);

    }
}
