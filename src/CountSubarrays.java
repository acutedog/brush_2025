import java.util.HashMap;
import java.util.Map;

public class CountSubarrays {
     /*
        题目：
代码
测试用例
测试结果
测试结果
2444. 统计定界子数组的数目
        链接：https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/description/?envType=daily-question&envId=2025-04-26
        难度：困难
        时间：2025年4月26日16:47:46
        思路：老子直接抄
     */

    public static void main(String[] args) {
        CountSubarrays main = new CountSubarrays();
        System.out.println(main.countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minIndex = -1, maxIndex = -1, invalidIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) {
                minIndex = i;
            }

            if (nums[i] == maxK) {
                maxIndex = i;
            }

            if (nums[i] > maxK || nums[i] < minK) {
                invalidIndex = i;
            }
            res += Math.max(Math.min(minIndex, maxIndex) - invalidIndex, 0);
        }

        return res;
    }
}
