package algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private static List<List<Integer>> v;   // связи вершин
    private static List<Integer> d;     // глубина
    private static int N;   // кол-во вершин

    public static void bfs(int x) {
        List<Integer> cur = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        int D = 0;  // глубина
        boolean[] visited = new boolean[N];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        // Начало с вершины x
        cur.add(x);
        visited[x] = true;

        while (!cur.isEmpty()) {
            for (int i = 0; i < cur.size(); i++) {
                int a = cur.get(i);
                d.set(a, D);
                for (int j = 0; j < v.get(a).size(); j++) {
                    int b = v.get(a).get(j);
                    if (!visited[b]) {
                        next.add(b);
                        visited[b] = true;
                    }
                }
            }
            cur = next;
            next = new ArrayList<>();
            D++; // Инкремент глубины
        }
    }

    public static void bfsQueue(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int D = 0; // глубина
        boolean[] visited = new boolean[N];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        queue.offer(x); // Добавляем начальную вершину в очередь
        visited[x] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int a = queue.poll();
                d.set(a, D);
                for (int j = 0; j < v.get(a).size(); j++) {
                    int b = v.get(a).get(j);
                    if (!visited[b]) {
                        queue.offer(b);
                        visited[b] = true;
                    }
                }
            }
            D++; // Инкремент глубины
        }
    }
}
