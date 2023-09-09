package tasks.other.math;

import java.util.Arrays;
import java.util.Random;

public class ArrayMax {

    /**
     * Ищем макс число меньше заданного.
     */
    public static int findMaxUnderBoundary(int[] inputArray, int topBoundary) {
        int currentMax = Integer.MIN_VALUE;
        for (int element : inputArray) {
            if (element < topBoundary) {
                currentMax = Math.max(currentMax, element);
            }
        }
        return currentMax;
    }

    public static int[] findTopElement(int[] inputArray, int numberOfElements) {
        int[] topElements = new int[numberOfElements];
        int previousMax = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfElements; i++) {
            int currentMax = findMaxUnderBoundary(inputArray, previousMax);
            previousMax = currentMax;
            topElements[i] = currentMax;
        }
        return topElements;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        System.out.println(x + " " + y);
        System.out.println("Max: " + Math.max(x, y));

        int[] data = {1, 2, 5, 4, 3, 10, 18};
        int max_value = 0;
        for (int i = 0; i < data.length; i++) {
            max_value = Math.max(max_value, data[i]);
        }
        System.out.println("Max: " + max_value);

        System.out.println("Find 3 top elements:");
        int[] top3 = findTopElement(data, 3);
        System.out.println(Arrays.toString(top3));
    }
}
