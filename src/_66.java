/**
 * 66. 加一
 *
 * @date 2019/1/17
 */

public class _66 {

    public int[] plusOne(int[] digits) {
        int bit = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (bit == 0) break;
            digits[i] = digits[i] + bit;
            bit = (digits[i] == 10 ? 1 : 0);
            digits[i] = (digits[i] == 10 ? 0 : digits[i]);
        }
        if (bit == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
       int[] res =  new _66().plusOne(new int[]{9, 9, 9});
        for (int i = 0; i < res.length; i++) {
            System.out.print( res[i] + " ");
        }
    }
}
