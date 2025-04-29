import java.util.ArrayList;
import java.util.List;

public class CountSubarrays {


    public static void main(String[] args) {
        CountSubarrays main = new CountSubarrays();
        System.out.println(main.countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5));
        System.out.println(main.countSubarrays(new int[]{1,2,1,4,1}));
        System.out.println(main.countSubarrays(new int[]{1,1,1}));
        System.out.println(main.countSubarrays(new int[]{1,4,1}));
        System.out.println(main.countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(main.countSubarrays(new int[]{1,4,2,1}, 3));
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

    public long countSubarrays(int[] nums, long k) {
         /*
            题目：2302. 统计得分小于 K 的子数组数目
            链接：https://leetcode.cn/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28
            难度：困难
            描述1：[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75。
            描述2：给你一个正整数数组nums和一个整数 k ，请你返回nums中分数严格小于k的非空整数子数组数目
            时间：2025年4月28日22:11:41
            思路：从i=0到i=len-1依次遍历，记录下i-1有效的边界，防止重复
         */

        long result = 0;
        int right = 0;
        long sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (right < i) {
                right = i;
                sum += nums[i];
            }
            boolean inCircle = false;
            while (sum * (right - i + 1) < k && right < nums.length - 1) {
                right++;
                sum += nums[right];
                inCircle = true;
            }

            if (!inCircle && sum * (right - i + 1) >= k) {
                right--;
            }

            if (!(right == nums.length - 1 && sum * (right - i + 1) < k) && inCircle) {
                sum -= nums[right];
                right--;
            }
            sum -= nums[i];
            result += Math.max(0, right - i + 1);
        }
        return result;
    }

    public long countSubarrays(int[] nums, int k) {
         /*
            题目：2962. 统计最大元素出现至少 K 次的子数组
            链接：https://leetcode.cn/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29
            难度：中等
            描述1：给你一个整数数组 nums 和一个 正整数 k 。
            描述2：请你统计有多少满足nums中的最大元素至少出现k次的子数组，并返回满足这一条件的子数组的数目
            时间：2025年4月29日21:48:18
         */

        long result = 0;
        int max = nums[0];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max) {
                list.add(i);
            } else if (nums[i] > max) {
                list = new ArrayList<>();
                list.add(i);
                max = nums[i];
            }
        }

        if (list.size() < k) {
            return 0;
        }

        for (int i = 0; i <= list.size() - k; i++) {
            int left = i > 0 ? list.get(i) - list.get(i - 1) - 1 : list.get(i);
            int right = nums.length - 1 - list.get(i + k - 1);
            result += (long) (left + 1) * (right + 1);
        }

        return result;
    }
}
