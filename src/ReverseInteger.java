public class ReverseInteger {
    /*
        题目: 7. 整数反转
        链接: https://leetcode.cn/problems/reverse-integer/description/
        难度: 中等
        思路: 倒转，判断是否越界
        时间: 2025年4月26日17:36:08
    */
    
    public static void main(String[] args) {
        ReverseInteger main = new ReverseInteger();
        System.out.println(main.reverse(0));
        System.out.println(main.reverse(-123));
        System.out.println(main.reverse(120));
        System.out.println(main.reverse(Integer.MAX_VALUE));
        System.out.println(main.reverse(Integer.MIN_VALUE));
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE ||x == 0) {
            return 0;
        }
        boolean negative = false;
        if (x < 0) {
            x = Math.abs(x);
            negative = true;
        }

        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            if ((reverse == Integer.MAX_VALUE / 10 && ((negative && pop > 8) || (!negative && pop > 7))) || reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + pop;
            x = x / 10;

        }
        return reverse * (negative ? -1 : 1);
    }
}
