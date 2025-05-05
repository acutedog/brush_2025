public class IsPalindrome {
    /*
        题目: 9. 回文数
        链接: https://leetcode.cn/problems/palindrome-number/
        难度: 简单
        思路: 一次遍历，负数直接返回，不是回文
        时间: 2025年5月5日19:25:22
    */

    public static void main(String[] args) {
        IsPalindrome main = new IsPalindrome();
        System.out.println(main.isPalindrome(121));
        System.out.println(main.isPalindrome(-121));
        System.out.println(main.isPalindrome(0));
        System.out.println(main.isPalindrome(1221));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        int[] nums = new int[10];
        int index = 0;
        while (x != 0) {
            nums[index++] = x % 10;
            x /= 10;
        }

        for (int i = 0; i <= index / 2; i++) {
            if (nums[i] != nums[index - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
