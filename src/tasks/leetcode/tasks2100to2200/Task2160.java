package tasks.leetcode.tasks2100to2200;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2160. Minimum Sum of Four Digit Number After Splitting Digits
 * Просто математика
 * 8 мин
 * https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/
 */
public class Task2160 {

    public static int minimumSum(int num) {
        int[] digits = new int[4];

        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }

        Arrays.sort(digits);

        int x = digits[0] * 10 + digits[2];
        int y = digits[1] * 10 + digits[3];

        return x + y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("52 vs " + minimumSum(2932));
        System.out.println("13 vs " + minimumSum(4009));

        int value = sc.nextInt();
        System.out.println(minimumSum(value));
    }
}
