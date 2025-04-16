import java.util.HashMap;
import java.util.Map;

public class CountGood {
    /*
    题目：2537. 统计好子数组的数目
    描述：
        给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
        一个子数组arr如果有至少k对下标(i, j)满足i < j且arr[i] == arr[j] ，那么称它是一个好子数组。
    链接：https://leetcode.cn/problems/count-the-number-of-good-subarrays/description/?envType=daily-question&envId=2025-04-16
    难度：中等
    思路：无思路，看题解
    时间：2025年4月16日20:59:10
    题解：双指针(滑动窗口)+HashMap，想不到，真的想不到
    题解链接：https://leetcode.cn/problems/count-the-number-of-good-subarrays/?envType=daily-question&envId=2025-04-16
 */
    public static void main(String[] args) {
        CountGood good = new CountGood();
        System.err.println(good.countGood(new int[]{1,1,1,1,1}, 10));
        System.err.println(good.countGood(new int[]{3,1,4,3,2,2,4}, 2));
    }

    public long countGood(int[] nums, int k) {
        /*
            整体思路：left从0开始，right从0开始，right一直增加，直到count满足要求，于是把left干掉，同时去除因left去除造成的count影响
            问1：为何right从-1开始？因为right++不能放在while的最后一行，必须等count < K判断成功后才能将right增加，而right又必须递增，因此只能从-1开始。
            问2：最后两行为何先将sameCount里的num计数-1，再从count中减少？因为假如在移除left之前，有N个num，那么减少left之后，有N-1个num，根据公式可知count减少了N-1。
         */
        int count = 0, right = -1;
        long res = 0;
        Map<Integer, Integer> sameCount = new HashMap<>();
        for (int num : nums) {
            while (count < k && ++right < nums.length) {
                count += sameCount.getOrDefault(nums[right], 0);
                sameCount.put(nums[right], sameCount.getOrDefault(nums[right], 0) + 1);
            }

            if (count >= k) {
                res += nums.length - right;
            }

            sameCount.put(num, sameCount.get(num) - 1);
            count -= sameCount.get(num);
        }
        return res;
    }
}
