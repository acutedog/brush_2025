import java.util.Arrays;

public class BuildArray {
    /*
        题目: 1920. 基于排列构建数组
        链接: https://leetcode.cn/problems/build-array-from-permutation/description/?envType=daily-question&envId=2025-05-06
        难度: 简单
        思路: 要啥思路
        时间: 2025年5月6日21:41:57
    */

    public static void main(String[] args) {
        BuildArray main = new BuildArray();
        System.out.println(Arrays.toString(main.buildArray(new int[] {0,2,1,5,3,4})));
    }

    public int[] buildArray(int[] nums) {
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[nums[i]];
        }
        return newNums;
    }
}

