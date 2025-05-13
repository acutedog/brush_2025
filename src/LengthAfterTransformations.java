public class LengthAfterTransformations {
    /*
        题目: 3335. 字符串转换后的长度 I
        链接: https://leetcode.cn/problems/total-characters-in-string-after-transformations-i/description/?envType=daily-question&envId=2025-05-13
        难度: 中等
        思路: 递归公式，0代表a，1代表b，25代表z
            f(i,0)=f(i−1,25)
            f(i,1)=f(i−1,25)+f(i−1,0)
            f(i,c)=f(i−1,c−1)
        时间: 2025年5月13日19:21:54
    */

    public static void main(String[] args) {
        LengthAfterTransformations main = new LengthAfterTransformations();
        System.out.println(main.lengthAfterTransformations("abcyy", 2));  // 7
        System.out.println(main.lengthAfterTransformations("azbk", 1));  // 5
    }

    private static final int MOD = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int[] dp = new int[26];
        for (char ch : s.toCharArray()) {
            dp[ch - 'a']++;
        }

        for (int round = 0; round < t; round++) {
            int[] next = new int[26];
            next[0] = dp[25];
            next[1] = (dp[25] + dp[0]) % MOD;
            for (int i = 2; i < 26; i++) {
                next[i] = dp[i - 1];
            }
            dp = next;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + dp[i]) % MOD;
        }
        return result;
    }
}
