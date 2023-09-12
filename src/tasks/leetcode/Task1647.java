package tasks.leetcode;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Подсчет букв и попытка итеративно удалить лишние. Неэффективно пока реализовано.
 * 20 мин
 * Больше всего сложность было то что в голове написать тк сходу не сложилась идея.
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
 */
public class Task1647 {
    public static int minDeletions(String s) {
        Map<String, Integer> letterToCount = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = s.substring(i, i + 1);
            Integer letter = letterToCount.getOrDefault(key, 0);
            letterToCount.put(key, letter + 1);
        }
        //System.out.println(letterToCount);
        TreeSet<Integer> elements = new TreeSet<>();
        ArrayList<Integer> doubles = new ArrayList<>();
        letterToCount.values().forEach(el -> {
            if (elements.contains(el)) {
                doubles.add(el);
            } else {
                elements.add(el);
            }
        });
        int cnt = 0;
        while (!doubles.isEmpty()) {
            Integer el = doubles.remove(0);
            while (elements.contains(el)) {
                el -= 1;
                cnt += 1;
            }
            if (el != 0) {
                elements.add(el);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int result = minDeletions("aab");
        System.out.println(result + " vs 0");

        result = minDeletions("aaabbbcc");
        System.out.println(result + " vs 2");

        result = minDeletions("ceabaacb");
        System.out.println(result + " vs 2");

        result = minDeletions("bbcebab");
        System.out.println(result + " vs 2");
    }
}
