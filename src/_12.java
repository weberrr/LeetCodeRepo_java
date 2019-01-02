/**
 * 整数转罗马数字
 *
 * @date 2019/1/2
 */
public class _12 {

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
