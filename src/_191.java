/**
 * 位1的个数
 *
 * @date 2018/12/4
 */
public class _191 {

    //位运算
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n & 1;
            n >>>= 1;
        }
        return sum;
    }

    public int hammingWeight2(int n) {
        int sum = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int t = 11;
        System.out.println(new _191().hammingWeight(t));
    }

}
