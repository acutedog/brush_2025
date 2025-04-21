public class NumberOfArrays {
    /*
         题目：2145. 统计隐藏数组数目
         描述：请你返回符合要求的隐藏数组的数目。如果没有符合要求的隐藏数组，请返回0
         链接：https://leetcode.cn/problems/count-the-hidden-sequences/description/?envType=daily-question&envId=2025-04-21
         难度：中等
         思路：一次遍历，从lower开始计算所有数组的实际值，找到最大，与upper比较
         时间：2025年4月21日17:17:13
     */

    public static void main(String[] args) {
        NumberOfArrays arrays = new NumberOfArrays();
        System.out.println(arrays.numberOfArrays(new int[]{1, -3, 4}, 1, 6)); // 2
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int max = Math.max(-100000, lower);
        int min = Math.min(100000, lower);
        int cur = lower;
        for (int difference : differences) {
            cur += difference;
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            if ((max - min) > 200000) {
                return 0;
            }
        }

        max += min >= lower ? 0 : lower - min;
        return upper < max ?  0: upper - max + 1;
    }
}
