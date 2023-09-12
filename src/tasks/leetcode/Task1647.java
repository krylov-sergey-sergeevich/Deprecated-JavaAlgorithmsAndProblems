package tasks.leetcode;

import java.util.*;

/**
 * Подсчет букв и попытка итеративно удалить лишние. Неэффективно пока реализовано.
 * 20 мин
 * Больше всего сложность было то что в голове написать тк сходу не сложилась идея.
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique
 */
public class Task1647 {
    public static int minDeletionsSlowly(String s) {
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

    public static int minDeletions(String s) {
        int[] letterCounts = new int[26]; // Массив для подсчета количества каждой буквы (a-z)

        // Подсчитываем количество каждой буквы в строке
        for (char c : s.toCharArray()) {
            letterCounts[c - 'a']++;
        }

        Set<Integer> uniqueCounts = new HashSet<>(); // Множество для уникальных значений
        int deletions = 0;

        // Идем по массиву с количеством букв
        for (int count : letterCounts) {
            if (count == 0) continue; // Пропускаем отсутствующие буквы

            // Пока текущее количество уже встречалось, увеличиваем удаления
            while (uniqueCounts.contains(count)) {
                count--;
                deletions++;
            }

            if (count > 0) {
                uniqueCounts.add(count);
            }
        }

        return deletions;
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
