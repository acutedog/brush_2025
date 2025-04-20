public class NumRabbits {
    /*
        题目：781. 森林中的兔子
        描述：提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?"
        链接：https://leetcode.cn/problems/rabbits-in-forest/description/?envType=daily-question&envId=2025-04-20
        难度：中等
        限制：1 <= answers.length <= 1000; 0 <= answers[i] < 1000
        思路：
        时间：2025年4月20日18:58:21
    */

    public static void main(String[] args) {
        NumRabbits rabbits = new NumRabbits();
        System.out.println(rabbits.numRabbits(new int[]{1,1,2})); // 5
        System.out.println(rabbits.numRabbits(new int[]{10,10,10})); // 12
    }

    public int numRabbits(int[] answers) {
        int[] counts = new int[1001];
        for (int answer : answers) {
            counts[answer]++;
        }
        int result = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0) {
                int max = i + 1;
                result += counts[i] / max * max + (counts[i] % max > 0 ? max : 0);
            }
        }
        return result;
    }
}
