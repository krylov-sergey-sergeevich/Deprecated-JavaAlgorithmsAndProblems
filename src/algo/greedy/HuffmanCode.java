package algo.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int w;  // частота
    Node zero;
    Node one;

    char c;

    public Node(int w, Node zero, Node one, char c) {
        this.w = w;
        this.zero = zero;
        this.one = one;
        this.c = c;
    }

    @Override
    public int compareTo(Node node) {
        return this.w - node.w;
    }
}

public class HuffmanCode {

    public static void dfs(Node x, ArrayList<Integer> res) {
        if (x.zero == null) {
            System.out.println("Code for " + x.c + ":");
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i).intValue());
            }
            System.out.println();
            return;
        }
        res.add(0);
        dfs(x.zero, res);
        res.remove(res.size() - 1);
        res.add(1);
        dfs(x.one, res);
    }

    public static void huffman(String s) {
        int[] data = new int[256];
        for (int i = 0; i < s.length(); i++) {
            data[s.charAt(i)] += 1;
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < 256; i++) {
            if (data[i] > 0) {
                q.add(new Node(data[i], null, null, (char) i));
            }
        }
        while (q.size() > 1) {
            Node t1 = q.poll();
            Node t2 = q.poll();
            Node n = new Node(t1.w + t2.w, t1, t2, '\0');
            q.add(n);
        }

        dfs(q.peek(), new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        huffman("Hello");
    }
}
