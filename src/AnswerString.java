/*
    题目: 3403. 从盒子中找出字典序最大的字符串 I
    链接: https://leetcode.cn/problems/find-the-lexicographically-largest-string-from-the-box-i/description/?envType=daily-question&envId=2025-06-04
    难度: 中等
    思路: 找到字母最大的前提下最长的子字符串
    时间: 2025/6/4 19:39
*/

public class AnswerString {
    public static void main(String[] args) {
        AnswerString main = new AnswerString();
        System.out.println(main.answerString("dbca", 2));
        System.out.println(main.answerString("gggg", 4));
        System.out.println(main.answerString("aann", 2));
        System.out.println(main.answerString("gh", 1));
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int maxLength = word.length() - numFriends + 1;
        String answer = word.substring(0, maxLength);
        char firstLetter = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) < firstLetter) {
                continue;
            }

            int currentLength = Math.min(maxLength, word.length() - i);
            if (word.charAt(i) == firstLetter) {
                for (int j = 1; j < currentLength; j++) {
                    if (answer.charAt(j) == word.charAt(i + j)) {
                        continue;
                    }

                    if (answer.charAt(j) < word.charAt(i + j)) {
                        answer = word.substring(i, i + currentLength);
                        break;
                    }
                    break;
                }
            } else {
                answer = word.substring(i,  i + currentLength);
                firstLetter = word.charAt(i);
            }
        }
        return answer;
    }
}
