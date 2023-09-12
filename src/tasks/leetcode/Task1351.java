package tasks.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Задача простая если просто пройтись по всей матрице, но есть решение насколько я понимаю интереснее через бин поиск.
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * <p>
 * Решение интереснее на каждом столбце запускается бин поиск и ищем эл-т которые < 0 считаем сколько их будет и далее складываем.
 * </p>
 * 5 мин
 */
public class Task1351 {
    public static ArrayList<ArrayList<Integer>> inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break; // Завершаем ввод, если строка пуста
            }
            String[] elements = line.split("\\s+"); // Разделяем строку на элементы по пробелам
            ArrayList<Integer> row = new ArrayList<>();
            for (String element : elements) {
                try {
                    int value = Integer.parseInt(element);
                    row.add(value);
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: Введите только целые числа.");
                }
            }
            matrix.add(row);
        }
        return matrix;
    }

    public static int[][] convertToGrid(ArrayList<ArrayList<Integer>> matrix) {
        int numRows = matrix.size();
        if (numRows == 0) {
            return new int[0][0]; // Пустая матрица
        }
        int numCols = matrix.get(0).size();
        int[][] grid = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = matrix.get(i);
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = row.get(j);
            }
        }
        return grid;
    }

    public static int countNegatives(int[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = inputMatrix();
        int[][] grid = convertToGrid(matrix);
        System.out.println(countNegatives(grid));
    }
}
