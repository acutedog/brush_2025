import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfPowerfulInt {
     /*
        题目：2999. 统计强大整数的数目
        链接：https://leetcode.cn/problems/count-the-number-of-powerful-integers/description/?envType=daily-question&envId=2025-04-10
        难度：困难
        示例：start = 15, finish = 215, limit = 6, s = "10" --> 2(110、210)
        示例：start = 1, finish = 6000, limit = 4, s = "124" --> 5(124 ，1124 ，2124 ，3124 和 4124)
        思路：首先确保s小于finish，否则直接返回0; 随后计算出<start有几个符合条件, <=finish有几个符合条件，二者可以调用公共方法
        时间：2025年4月10日22:19:23 --> 2025年4月11日23:29:11
        优化：未做出来，最好成绩756 / 932，看官方题解，真优雅啊
     */

    public static void main(String[] args) {
        NumberOfPowerfulInt main = new NumberOfPowerfulInt();
        System.out.println(main.numberOfPowerfulInt(1, 6000, 4, "124"));  // 5
        System.out.println(main.numberOfPowerfulInt(15, 215, 6, "10"));  // 2
        System.out.println(main.numberOfPowerfulInt(1000, 2000, 4, "3000")); // 0
        System.out.println(main.numberOfPowerfulInt(1, 971, 9, "17")); // 10
        System.out.println(main.numberOfPowerfulInt(1, 971, 9, "72")); // 9
        System.out.println(main.numberOfPowerfulInt(20, 1159, 5, "20")); // 8
        System.out.println(main.numberOfPowerfulInt(15000, 15001, 9, "9")); // 0
        System.out.println(main.numberOfPowerfulInt(10, 1844, 5, "12")); // 12
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suffix = Long.parseLong(s);
        if (suffix > finish) {
            return 0;
        }
        long large = getNumOfPowerfulInt(finish, limit, suffix, s.length());
        long small = getNumOfPowerfulInt(start - 1, limit, suffix, s.length());
        System.out.println(finish + ": " + large);
        System.out.println(start - 1 + ": " + small);
        return large - small;
    }

    private long getNumOfPowerfulInt(long bound, int limit, long suffix, int suffixLength) {
        if (bound < suffix) {
            return 0;
        }

        List<Integer> boundDigits = getDigitList(bound);
        if (boundDigits.size() == suffixLength) {
            return 1;
        }

        int diff = boundDigits.size() - suffixLength;
        long boundSuffix = 0;
        for (int i = 0; i < suffixLength; i++) {
            boundSuffix = boundSuffix * 10 + boundDigits.get(i + diff);
        }
        boolean isSmaller = boundSuffix < suffix;
        long result = (Math.min(boundDigits.get(0), limit) - (diff == 1 ? 0 : 1)) * (long) Math.pow(limit + 1, diff - 1);
        for (int i = 1; i < diff; i++) {
             result += Math.min(boundDigits.get(i), limit) * (long) Math.pow(limit + 1, diff - 1 - i);
             if (diff == 2) {
                 result++;
             }
        }
        int count = diff - 1;
        while (count > 0) {
            result += Math.min(9, limit) * (long) Math.pow(limit + 1, count - 1);
            count--;
        }

        return result + 1 + (isSmaller & boundDigits.get(0) <= limit ? -1 : 0);
    }

    private List<Integer> getDigitList(long bound) {
        List<Integer> digits = new ArrayList<>();
        while (bound > 0) {
            digits.add((int) (bound % 10));
            bound = bound / 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    public long numberOfPowerfulIntAnswer(long start, long finish, int limit, String s) {
        String start_ = Long.toString(start - 1);
        String finish_ = Long.toString(finish);
        return calculate(finish_, s, limit) - calculate(start_, s, limit);
    }

    private long calculate(String x, String s, int limit) {
        /*
            x为取值范围，s为后缀
            整体思路：判断不同长度下的数字有多少符合要求
            假设x为abcdefg, s为xyz，则abcd为x多出的数字，对abcd中的每个值digit存在如下情况
                其一，若这个值大于等于limit，则其取值范围为0到limit，而其后面的位也都可以取值0到limit。
                    当其为0时，相当于当前位不存在，以此类推，相当于所有长度的数字都取到了
                    当其不为0时，从1到limit取遍当前长度的所有数值
                    综上，当当前位大于limit时，可以取值limit+1的剩余次方，直接返回
                其二，小于limit时，取值1到digit，后面的前缀可取值0到limit
                其三，如果没有任意一个前缀位符合要求可以直接返回，则需要判断x的后缀efg和xyz的大小，如efg>=xyz，需要加1，否则不加。
                    原因：对于1019和20, 1020明显大于1019，不符合要求，而20符合要求，则不增不减；对于1021，1020符合要求，则要把20这个值加上
         */
        if (x.length() < s.length()) {
            return 0;
        }
        if (x.length() == s.length()) {
            return x.compareTo(s) >= 0 ? 1 : 0;
        }

        String suffix = x.substring(x.length() - s.length());
        long count = 0;
        int preLen = x.length() - s.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long) Math.pow(limit + 1, preLen - i);
                return count;
            }
            count += (long) (digit) * (long) Math.pow(limit + 1, preLen - 1 - i);
        }
        if (suffix.compareTo(s) >= 0) {
            count++;
        }
        return count;
    }
}
