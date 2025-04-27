public class CountSubarrays {


    public static void main(String[] args) {
        CountSubarrays main = new CountSubarrays();
        System.out.println(main.countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(main.countSubarrays(new int[]{1,2,1,4,1}));
        System.out.println(main.countSubarrays(new int[]{1,1,1}));
        System.out.println(main.countSubarrays(new int[]{1,4,1}));
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        /*
            题目：2444. 统计定界子数组的数目
            链接：https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/description/?envType=daily-question&envId=2025-04-26
            难度：困难
            时间：2025年4月26日16:47:46
            思路：老子直接抄
         */
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

    public int countSubarrays(int[] nums) {
        /*
            题目：3392. 统计符合条件长度为 3 的子数组数目
            链接：https://leetcode.cn/problems/count-subarrays-of-length-three-with-a-condition/description/?envType=daily-question&envId=2025-04-27
            难度：简单
            描述：给你一个整数数组nums ，请你返回长度为3的子数组的数量，满足第一个数和第三个数的和恰好为第二个数的一半。
            时间：2025年4月27日19:04:04
            思路：index从1遍历到length - 2
         */

        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                res++;
            }
        }

        return res;
    }
}
