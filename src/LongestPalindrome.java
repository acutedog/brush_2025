public class LongestPalindrome {
    /*
        题目：5. 最长回文子串
        描述：给你一个字符串s，找到s中最长的回文子串
        链接：https://leetcode.cn/problems/longest-palindromic-substring/
        难度：中等
        限制：1 <= s.length <= 1000; s 仅由数字和英文字母组成
        思路：中心扩散法
        时间：2025年4月20日19:32:03
    */

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        System.out.println(palindrome.longestPalindrome("babad")); // bab
        System.out.println(palindrome.longestPalindrome("cbbd")); // bb
        System.out.println(palindrome.longestPalindrome("bb")); // bb
    }

    public String longestPalindrome(String s) {
        String longest = s.substring(0, 1);
        for (int middle = 1; middle <= s.length() - 1; middle++) {
            int left = middle - 1, right = middle + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(middle)) {
                left--;
            }
            while (right < s.length() - 1 && s.charAt(right) == s.charAt(middle)) {
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if (right - left + 1 > longest.length()) {
                longest = s.substring(left, right + 1);
            }
        }
        return longest;
    }
}
