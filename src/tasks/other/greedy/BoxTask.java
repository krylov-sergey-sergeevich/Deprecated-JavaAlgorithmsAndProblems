package tasks.other.greedy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Box implements Comparable<Box> {
    private final int w;
    private final int m;

    Box(int w, int m) {
        this.w = w;
        this.m = m;
    }

    public int getW() {
        return w;
    }

    public int getM() {
        return m;
    }

    @Override
    public int compareTo(Box b) {
        // < 0  если b больше
        // = 0  если совпадает
        // > 0  если this больше
        return (w + m) - (b.w + b.m);
    }
}

class BoxComparator implements Comparator<Box> {

    @Override
    public int compare(Box o1, Box o2) {
        return o2.getW() - o1.getW();
    }
}

public class BoxTask {

    public static int solve(ArrayList<Box> boxes) {
        Collections.sort(boxes);
        PriorityQueue<Box> q = new PriorityQueue<>(1, new BoxComparator());
        int sum_w = 0;
        int cnt = 0;
        for (int i = 0; i < boxes.size(); i++) {
            Box box = boxes.get(i);
            if (box.getM() >= sum_w) {
                cnt += 1;
                sum_w += box.getW();
                q.add(box);
            } else {
                if (q.peek().getW() > box.getW()) {
                    sum_w -= q.peek().getW();
                    q.poll();
                    q.add(box);
                    sum_w += box.getW();
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
    }
}
