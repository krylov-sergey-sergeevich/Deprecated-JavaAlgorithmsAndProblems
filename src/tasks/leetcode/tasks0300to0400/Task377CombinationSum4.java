package tasks.leetcode.tasks0300to0400;

/**
 * Применено Динамическое программирование.
 * 26 минут заняло (с наливанием чая =) )
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class Task377CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        int[] data = new int[target + 1];
        data[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    data[i] += data[i - num];
                }
            }
        }
        return data[target];
    }

    public static void main(String[] args) {
        int result1 = combinationSum4(new int[]{1, 2, 3}, 4);
        if (result1 != 7) {
            System.out.println("#1 Error => " + result1);
        }
        int result2 = combinationSum4(new int[]{9}, 3);
        if (result2 != 0) {
            System.out.println("#2 Error => " + result2);
        }
    }
}
