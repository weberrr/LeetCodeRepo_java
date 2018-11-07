import java.util.ArrayList;

/**
 * 报数(Count and Say)
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项
 *
 * @date 2018/11/7
 */
public class _38 {
    public String countAndSay(int n) {
        ArrayList<String> res = new ArrayList<String>();
        res.add("1");
        for (int i = 0; i < n; i++) {
            int count = 0;
            char[] num = res.get(i).toCharArray();
            char temp = num[0];
            String ans = "";
            for (int j = 0; j < num.length; j++) {
                if (num[j] == temp) {
                    count++;
                } else {
                    ans += String.valueOf(count);
                    ans += String.valueOf(temp);
                    temp = num[j];
                    count = 1;
                }
            }
            ans += String.valueOf(count);
            ans += String.valueOf(temp);
            res.add(ans);
        }
        return res.get(n - 1);
    }

    public static void main(String[] args) {
        _38 test = new _38();
        System.out.println(test.countAndSay(6));
    }
}
