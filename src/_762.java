/**
 * 二进制表示中质数个计算置位
 *
 * @date 2018/12/4
 */
public class _762 {

    //位运算
    //20以内的质数有：2，3，5，7，11，13，17，19
    public int countPrimeSetBits(int L, int R) {
        int sum = 0;
        for (int i = L; i <= R; i++) {
            int oneNum = countBinaryNum(i);
            sum += judgePrime(oneNum) ? 1 : 0;
        }
        return sum;
    }

    private boolean judgePrime(int num) {
        return num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num == 13 || num == 17 || num == 19;
    }

    private int countBinaryNum(int n) {
        String binaryStr = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1')  res++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Math.pow(2, 20));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new _762().countPrimeSetBits(10,15));
    }
}
