import java.util.HashMap;
import java.util.Map;

public class ConvertByZ {
    public static void main(String[] args) {
        ConvertByZ z = new ConvertByZ();
        System.out.println(z.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(z.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(z.convert("AB", 1)); // AB
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Map<Integer, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }
        int step = 1, index = 0;
        for (int i = 0; i < s.length(); i++) {
            map.get(index).append(s.charAt(i));
            index += step;
            if (index == numRows - 1 || index == 0) {
                step = -step;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(map.get(i));
        }
        return res.toString();
    }
}
