package tasks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Применено просто разложение по hashMap с учетом переполнения.
 * 10 мин
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to
 */
public class Task1282 {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> storage = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> t = storage.getOrDefault(groupSizes[i], new ArrayList<>());
            t.add(i);
            storage.put(groupSizes[i], t);
            if (t.size() == groupSizes[i]) {
                result.add(t);
                storage.remove(groupSizes[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = groupThePeople(input);
        for (List<Integer> el : result) {
            System.out.println(el);
        }
    }
}
