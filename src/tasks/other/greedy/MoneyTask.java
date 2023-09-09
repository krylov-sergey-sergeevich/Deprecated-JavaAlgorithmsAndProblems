package tasks.other.greedy;

import utils.AlgGreedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

class Task implements Comparable<Task> {
    private final Integer countMonet;

    Task(Integer countMonet) {
        this.countMonet = countMonet;
    }

    public Integer getCountMonet() {
        return countMonet;
    }

    @Override
    public int compareTo(Task t) {
        // < 0  если t больше
        // = 0  если совпадает
        // > 0  если this больше
        return (int) (this.countMonet - t.countMonet);
    }

    @Override
    public String toString() {
        return countMonet.toString();
    }
}

@AlgGreedy(name = "Задача №1")
public class MoneyTask {
    public static Long solve(ArrayList<Task> tasks, Integer hour) {
        Collections.sort(tasks);
        Collections.reverse(tasks);
        System.out.println(tasks);
        long sum = 0;
        for (int i = 0; i < hour; i++) {
            if (i >= tasks.size()) {
                break;
            }
            sum += tasks.get(i).getCountMonet();
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>(Stream.of(4, 3, 1, 6, 4, 3).map(Task::new).toList());
        System.out.println("Result: " + solve(tasks, 4));
    }
}
