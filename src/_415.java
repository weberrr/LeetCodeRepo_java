import java.util.Arrays;

/**
 * 字符串相加
 *
 * @date 2018/12/10
 */
public class _415 {

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int i = char1.length - 1, j = char2.length - 1;
        StringBuilder res = new StringBuilder();
        int temp = 0;
        int perNum = 0;
        for (; i >= 0 && j >= 0; i--, j--) {
            perNum = char1[i] + char2[j] - 2 * '0' + temp;
            temp = perNum / 10;
            res.insert(0, String.valueOf(perNum % 10));
        }
        while (i >= 0) {
            perNum = char1[i] - '0' + temp;
            temp = perNum / 10;
            res.insert(0, String.valueOf(perNum % 10));
            i--;
        }
        if (temp != 0) {
            res.insert(0, temp);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";
        System.out.println(new _415().addStrings(num1, num2));
    }

}
