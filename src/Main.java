import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minOperations(new int[] {5,2,5,4,5}, 2));
    }

    public int[] twoSum(int[] nums, int target) {
        /*
            题目：
            链接：https://leetcode.cn/problems/two-sum/description/
            难度：简单
            思路：双指针遍历

            可优化：
         */

        return new int[] {0,0};
    }

    public int minOperations(int[] nums, int k) {
        /*
            题目: 3375. 使数组的值全部为 K 的最少操作次数
            链接：https://leetcode.cn/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09
            难度：简单
            思路: 找到比k大的元素的个数；如发现有比k小的值，直接返回-1
            调试：System.out.println(main.minOperations(new int[] {5,2,5,4,5}, 2));
            时间：2025年4月9日21:31:15
            可优化: 无。
         */

        boolean[] flags = new boolean[101];
        int weight = 0;
        for (int num : nums) {
            if (num < k) {
                return -1;
            } else if (num > k) {
                if (!flags[num]) {
                    weight++;
                    flags[num] = true;
                }
            }
        }
        return weight;
    }

    public int minimumOperations(int[] nums) {
        /*
            思路：倒着遍历，将值放入一个set，当有值重复出现时，stop，记录下index，计算出需要pop的次数
            题目链接：https://leetcode.cn/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/?envType=daily-question&envId=2025-04-08
            可优化：将Set替换为一个bool数组，记录数值是否重复出现，因为元素是有范围的，都是100以内的值；Set每次插入都是O(1)的时间复杂度，但空间肯定比数组大
            调试：System.out.println(main.minimumOperations(new int[] {1,2,3,4,2,3,3,5,7}));
         */
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return (i + 1) / 3 + ((i + 1) % 3 > 0 ? 1 : 0);
            }
            set.add(nums[i]);
        }
        return 0;
    }
}
