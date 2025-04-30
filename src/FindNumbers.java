import java.util.HashMap;
import java.util.Map;

public class FindNumbers {
    /*
        题目: 1295. 统计位数为偶数的数字
        链接: https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/description/?envType=daily-question&envId=2025-04-30
        难度: 简单
        思路: 不需要
        时间: 2025年4月30日21:08:30
        其他思路：转换成字符串然后计算长度；用log然后取整；(int) (Math.log10(num) + 1)；还有直接判断数据是否在某个范围的：num >9 && num < 100、num>999 && num < 10000、num == 100000
    */

    public static void main(String[] args) {
        FindNumbers main = new FindNumbers();
        System.out.println(main.findNumbers(new int[]{555,901,482,1771})); // 1
        System.out.println(main.findNumbers(new int[]{12,345,2,6,7896})); // 2
    }

    public int findNumbers(int[] nums) {
        int result = 0;
        Map<Integer, Boolean> memo = new HashMap<>();
        for (int num : nums) {

            if (memo.containsKey(num)) {
                if (memo.get(num)) {
                    result++;
                }
            } else {
                int count = 0;
                while (num > 0) {
                    num /= 10;
                    count++;
                }
                if (count % 2 == 0) {
                    result++;
                    memo.put(num, true);
                } else {
                    memo.put(num, false);
                }
            }
        }
        return result;
    }
}
