import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
        题目：1. 两数之和
        链接：https://leetcode.cn/problems/two-sum/description/
        难度：简单
        思路：双指针遍历
        时间：2025年4月10日21:49:47
        优化：使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)
     */

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        System.out.println(Arrays.toString(sum.twoSum(new int[] {3, 3}, 6)));
        System.out.println(Arrays.toString(sum.twoSumBetter(new int[] {3, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[0];
    }

    public int[] twoSumBetter(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
