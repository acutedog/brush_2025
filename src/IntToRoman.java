import java.util.ArrayList;
import java.util.List;

public class IntToRoman {
    /*
        题目: 12. 整数转罗马数字
        链接: https://leetcode.cn/problems/integer-to-roman/description/
        难度: 中等
        描述
            符号	值
            I	1
            V	5
            X	10
            L	50
            C	100
            D	500
            M	1000
            仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
            取值范围：1 <= num <= 3999
        思路: 倒序遍历
        时间: 2025年5月9日20:54:40
    */

    public static void main(String[] args) {
        IntToRoman main = new IntToRoman();
        System.out.println(main.intToRoman(3749)); //  MMMDCCXLIX
        System.out.println(main.intToRoman(58));  // LVIII
        System.out.println(main.intToRoman(1994));  // MCMXCIV
    }

    private final static char[][] ROMAN = {{'I','V','X'}, {'X', 'L','C'}, {'C', 'D','M'}, {'M', 'N', 'O'}};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] digits = new int[4];
        int count = 0;
        while (num > 0) {
            digits[count++] = num % 10;
            num /= 10;
        }
        for (int i = count - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit < 4) {
                while (digit-- > 0) {
                    sb.append(ROMAN[i][0]);
                }
            } else if (digit == 4) {
                sb.append(ROMAN[i][0]).append(ROMAN[i][1]);
            } else if (digit < 9) {
                sb.append(ROMAN[i][1]);
                digit -= 5;
                while (digit-- > 0) {
                    sb.append(ROMAN[i][0]);
                }
            } else {
                sb.append(ROMAN[i][0]).append(ROMAN[i][2]);
            }
        }
        return sb.toString();
    }
}
