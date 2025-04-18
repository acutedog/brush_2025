import java.util.HashMap;
import java.util.Map;

public class CountBadPairs {
     /*
        题目：2364. 统计坏数对的数目
        链接：https://leetcode.cn/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-04-18
        难度：中等
        示例：[4,1,3,3] --> 5
        示例：[1,2,3,4,5] --> 0
        bad 思路：直接for循环
        时间：2025年4月18日19:21:33
        官方题解：j − i != nums[j] − nums[i]  --> nums[i] − i != nums[j] − j
     */

    public static void main(String[] args) {
        CountBadPairs main = new CountBadPairs();
        System.out.println(main.countBadPairs(new int[]{4, 1, 3, 3}));
        System.out.println(main.countBadPairs(new int[]{1,2,3,4,5}));
    }

    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;
            // 关键在此行，为何加上i - map()? map.get(key)拿到第i个数之前的与当前值相同的数，我们的目标是找到与当前值不同的
            // 容易得出公式：i + 1 - (map.get(key) + 1) = i - map.get(key)
            res += i - map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return res;
    }
}
