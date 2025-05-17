import java.util.Arrays;

public class SortColors {
    /*
        题目: 75. 颜色分类
        链接: https://leetcode.cn/problems/sort-colors/description/?envType=daily-question&envId=2025-05-17
        难度: 中等
        思路: 一次遍历，统计0、1、2的个数
        时间: 2025年5月17日19:19:50
    */

    public static void main(String[] args) {
        SortColors main = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        main.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int zeroCount = 0, oneCount = 0, twoCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else if (num == 1) {
                oneCount++;
            } else if (num == 2) {
                twoCount++;
            }
        }

        oneCount += zeroCount;
        twoCount += oneCount;
        for (int i = 0; i < nums.length; i++) {
            if (i < zeroCount) {
                nums[i] = 0;
            } else if (i < oneCount) {
                nums[i] = 1;
            } else if (i < twoCount) {
                nums[i] = 2;
            }
        }
    }
}
