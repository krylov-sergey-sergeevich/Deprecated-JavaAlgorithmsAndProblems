package tasks.codeforces.round143Div2;

import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/231/A
 * Done
 */
public class TeamTask {
    public static int[][] input() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][3];

        // Считываем матрицу из ввода
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        return matrix;
    }

    public static void main(String[] args) {
        int[][] input = input();
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            int cnt = 0;
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] > 0) {
                    cnt += 1;
                }
            }
            if (cnt >= 2) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}