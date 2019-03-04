
/**
 * 96. 不同的二叉搜索树
 *
 * @date 2019/3/4
 */
public class _96 {

    //G(n) = G(0)*G(n-1) + G(1)*G(n-2) +...
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] temp = new int[n + 1];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                temp[i] += temp[j] * temp[i - 1 - j];
            }
        }
        return temp[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new _96().numTrees(i));
        }
    }

}
