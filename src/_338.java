/**
 * 比特位计数(Counting Bits)
 * <p>
 * 给定一个非负整数 num。
 * 对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * @date 2018/10/31
 */
public class _338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    public int countOne(int num) {
        int ans = 0;
        while (num > 1) {
            ans += num % 2;
            num = num / 2;
        }
        ans += num;
        return ans;
    }

    //o(n)的方法
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            if (i == 0) {
                res[i] = 0;
                continue;
            } else if (i == 1 || i == 2) {
                res[i] = 1;
                continue;
            } else {
                if (i % 2 == 0) {
                    res[i] = res[i / 2];
                } else {
                    res[i] = res[i - 1] + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _338 t = new _338();
        int[] res = t.countBits2(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(res[i]);
        }

    }
}
