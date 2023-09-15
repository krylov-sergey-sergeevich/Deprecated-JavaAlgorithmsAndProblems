package tasks.leetcode.tasks1600to1700;

import java.util.Scanner;

/**
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * 7 мин
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */
public class Task1689 {
    public static int minPartitionsV1(String n) {
        int m = 0;
        for (int i = 0; i < n.length(); i++) {
            m = Math.max(m, Integer.valueOf(n.substring(i, i + 1)));
        }
        return m;
    }

    /**
     * Это решение по скорости лучше тк нет преобразований лишних
     */
    public static int minPartitionsV2(String n) {
        int maxDigit = 0;
        for (char digitChar : n.toCharArray()) {
            int digit = digitChar - '0';
            maxDigit = Math.max(maxDigit, digit);
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println("3 vs " + minPartitionsV1("32"));
        System.out.println("8 vs " + minPartitionsV1("82734"));
        System.out.println("9 vs " + minPartitionsV1("27346209830709182346"));
        System.out.println(minPartitionsV1(input));
    }
}
