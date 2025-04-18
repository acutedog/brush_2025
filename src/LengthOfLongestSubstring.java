import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
     /*
        题目：3. 无重复字符的最长子串
        链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
        描述：给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
        示例："abcabcbb" --> 3
        示例："pwwkew" --> 3
        思路：HashMap + 滑动窗口
        时间：2025年4月18日19:56:17
     */


    public static void main(String[] args) {
        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        System.out.println(length.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(length.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                res = Math.max(res, i - left);
                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
        }
        return res;
    }
}
