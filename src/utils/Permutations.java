package utils;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        long result = calculatePermutations(n);
        System.out.println(result);
    }

    // Функция для вычисления факториала числа n
    private static long calculateFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    // Функция для вычисления числа перестановок P(n)
    private static long calculatePermutations(int n) {
        return calculateFactorial(n);
    }
}
