package tasks.leetcode.tasks1300to1400;

import java.util.*;

/**
 * 1337. The K Weakest Rows in a Matrix
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
 * 10 мин
 * Easy
 */
public class Task1337 {

    public static class Pair {
        int x;
        int y;

        public Pair(int cnt, int i) {
            this.x = cnt;
            this.y = i;
        }

        @Override
        public String toString() {
            return "x=" + x + ", y=" + y;
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                }
            }
            result.add(new Pair(cnt, i));
        }
        Collections.sort(result, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                } else {
                    return o1.y - o2.y;
                }
            }
        });
        System.out.println(result);
        if (result == null || k <= 0) {
            return null;
        }

        if (k > result.size()) {
            k = result.size();
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = result.get(i).y;
        }

        return res;
    }

    public static <T> T[] takeFirstKElements(List<T> list, int k) {
        if (list == null || k <= 0) {
            return null;
        }

        if (k > list.size()) {
            k = list.size();
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int[] ints = kWeakestRows(matrix, 3);
        System.out.println(Arrays.toString(ints));
    }
}
