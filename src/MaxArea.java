public class MaxArea {
    /*
        题目: 11. 盛最多水的容器
        链接: https://leetcode.cn/problems/container-with-most-water/description/
        难度: 中等
        描述: 给定一个长度为n的整数数组height。有n条垂线，第i条线的两个端点是(i, 0)和(i, height[i])
        描述: 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        思路: 双指针，从两边开始推进，高度较短的边界向内推进
        时间: 2025年5月6日21:53:29
    */

    public static void main(String[] args) {
        MaxArea main = new MaxArea();
        System.out.println(main.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(main.maxArea(new int[]{1,1}));
    }

    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
