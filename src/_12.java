/**
 * 整数转罗马数字
 *
 * @date 2019/1/2
 */
public class _12 {

    /**
     * 关键词：辅助表
     * 时间复杂度：o(1)
     * 空间复杂度：o(n)
     * <p>
     * 思路：将每位数字对应的罗马数字转成现成的表，直接将数字取模，从表中找每位对应的罗马值再拼接
     **/

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        String[][] help = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        res.append(help[3][num / 1000]);
        res.append(help[2][num % 1000 / 100]);
        res.append(help[1][num % 100 / 10]);
        res.append(help[0][num % 10]);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _12().intToRoman(58));
    }

}
