package greedy;

import utils.AlgGreedy;

import java.util.ArrayList;
import java.util.Collections;


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

    public static int solve(ArrayList<Segment> segments) {
        if ((segments == null) || (segments.isEmpty())) {
            return 0;
        }
        Collections.sort(segments);
        System.out.println(segments);
        int last_r = segments.get(0).getL();
        int answer = 0;
        for (int i = 0; i < segments.size(); i++) {
            if (segments.get(i).getL() >= last_r) {
                answer += 1;
                last_r = segments.get(i).getR();
                System.out.println(segments.get(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayList segments = new ArrayList();
        segments.add(new Segment(1, 5));
        segments.add(new Segment(1, 2));
        segments.add(new Segment(3, 4));
        segments.add(new Segment(2, 3));
        System.out.println("Result: " + solve(segments));
    }
}
