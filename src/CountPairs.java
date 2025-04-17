import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPairs {
    /*
        题目：2176. 统计数组中相等且可以被整除的数对
        描述：给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目
        链接：https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/description/?envType=daily-question&envId=2025-04-17
        难度：简单
        限制：1 <= nums.length <= 100; 1 <= nums[i], k <= 100
        思路：
        时间：2025年4月17日22:57:09
    */
    public static void main(String[] args) {
        System.out.println(new CountPairs().countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));
    }

    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int res = 0;
        for (List<Integer> value : map.values()) {
            if (value.size() > 1) {
                for (int i = 0; i < value.size() - 1; i++) {
                    for (int j = i + 1; j < value.size(); j++) {
                        if (value.get(i) * value.get(j) % k == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
