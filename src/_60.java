/**
 * 60. 第k个排列
 *
 * @date 2019/1/16
 */
public class _60 {

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        int factor = factorial(n - 1);
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = k / factor;  // 获取当前位的数字index
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (!used[j]) {
                    if (index > 0) {
                        index--;
                    } else {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        break;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - i - 1);
            }
        }
        return sb.toString();
    }

    private int factorial(int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println(new _60().getPermutation(3, 3));
    }
}
