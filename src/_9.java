/**
 * 回文数
 *
 * @date 2018/12/20
 */
public class _9 {

    /**
     * 关键词：回文数
     * 时间复杂度：o(log(x)) 即x的数字长度
     * 空间复杂度：o(1)
     * <p>
     * 思路：看看翻转以后的数字是否和
     **/

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int origin = x;
        int result = 0;
        while (x > 0) {
            int temp = x % 10;
            x = x / 10;
            result = result * 10 + temp;
        }
        return result == origin;
    }

    //转成字符串做，较慢
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        for (int i = 0, j = str.length() - 1; i < j; ) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _9().isPalindrome(1));
    }
}
