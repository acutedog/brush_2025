public class CountBadPairs {
     /*
        题目：2364. 统计坏数对的数目
        链接：https://leetcode.cn/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-04-18
        难度：中等
        示例：[4,1,3,3] --> 5
        示例：[1,2,3,4,5] --> 0
        思路：直接for循环
        时间：2025年4月18日19:21:33
     */

    public static void main(String[] args) {
        CountBadPairs main = new CountBadPairs();
        System.out.println(main.countBadPairs(new int[]{4, 1, 3, 3}));
        System.out.println(main.countBadPairs(new int[]{1,2,3,4,5}));
    }

    public long countBadPairs(int[] nums) {
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] != j - i) {
                    count++;
                }
            }
        }
        return count;
    }
}
