import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GetWordsInLongestSubsequence {
    /*
        题目: 2901. 最长相邻不相等子序列 II
        链接: https://leetcode.cn/problems/longest-unequal-adjacent-groups-subsequence-ii/description/?envType=daily-question&envId=2025-05-16
        难度: 中等
        思路: 直接题解。DP
        时间: 2025年5月16日19:38:09
    */

    public static void main(String[] args) {
        GetWordsInLongestSubsequence main = new GetWordsInLongestSubsequence();
        System.out.println(main.getWordsInLongestSubsequence(new String[] {"bab","dab","cab"}, new int[] {1,2,2}));
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(dp, 1);
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (check(words[i], words[j]) && dp[j] + 1 > dp[i] && groups[j] != groups[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            result.add(words[i]);
        }

        Collections.reverse(result);
        return result;
    }

    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}
