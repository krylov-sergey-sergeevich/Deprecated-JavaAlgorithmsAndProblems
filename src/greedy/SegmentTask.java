package greedy;

import utils.AlgGreedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


class Segment implements Comparable<Segment> {
    private final int l;
    private final int r;

    Segment(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Segment t) {
        return this.r - t.r;
    }

    public int getR() {
        return r;
    }

    public int getL() {
        return l;
    }

    @Override
    public String toString() {
        return "[" + this.l + ":" + this.r + "]";
    }
}

@AlgGreedy(name = "Задача №3")
public class SegmentTask {
    private final static Random rnd = new Random();

    public static int solve(ArrayList<Segment> segments) {
        if ((segments == null) || (segments.isEmpty())) {
            return 0;
        }
        Collections.sort(segments);
        int last_r = segments.get(0).getL();
        int answer = 0;
        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).getL() >= last_r) {
                answer += 1;
                last_r = segments.get(i).getR();
            }
        }
        return answer;
    }

    /**
     * Перебором пытаюсь найти решение.
     */
    public static int solve_slow(ArrayList<Segment> segments) {
        int ans = 0;
        // 1 << segments.size() == 2^размер листа
        for (int mask = 0; mask < (1 << segments.size()); mask++) {
            boolean intersect = isIntersect(segments, mask);
            if (!intersect) {
                int cnt = 0;
                for (int i = 0; i < segments.size(); i++) {
                    if ((mask & (1 << i)) > 0) {
                        cnt += 1;
                    }
                }
                if (cnt > ans) {
                    ans = cnt;
                }
            }
        }
        return ans;
    }

    private static boolean isIntersect(ArrayList<Segment> segments, int mask) {
        boolean intersect = false;
        for (int i = 0; i < segments.size(); i++) {
            for (int j = i + 1; j < segments.size(); j++) {
                // 1 << i - это 1 бит под номером i
                if ((mask & (1 << i)) == 0) continue;
                if ((mask & (1 << j)) == 0) continue;
                int l = Math.max(segments.get(i).getL(), segments.get(j).getL());
                int r = Math.min(segments.get(i).getR(), segments.get(j).getR());
                // если пересекаются то l < r
                if (l < r) {
                    intersect = true;
                    break;
                }
            }
        }
        return intersect;
    }


    public static ArrayList<Segment> generate() {
        ArrayList<Segment> test = new ArrayList<>();
        int N = rnd.nextInt(10) + 1;
        for (int i = 0; i < N; i++) {
            int r = rnd.nextInt(100) + 1;
            int l = rnd.nextInt(r);
            test.add(new Segment(l, r));
        }
        return test;
    }

    public static void stress_test() {
        while (true) {
            ArrayList<Segment> test = generate();
            if (solve(test) != solve_slow(test)) {
                System.out.println("Stress test failed!");
                for (int i = 0; i < test.size(); i++) {
                    System.out.println(test.get(i));
                }
                break;
            } else {
                System.out.println("Success attempt");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList segments = new ArrayList();
        segments.add(new Segment(1, 5));
        segments.add(new Segment(1, 2));
        segments.add(new Segment(3, 4));
        segments.add(new Segment(2, 3));
        System.out.println("Result: " + solve(segments));
        System.out.println("Result Slow: " + solve_slow(segments));
        stress_test();
    }
}
