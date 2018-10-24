import java.util.Arrays;

/**
 * 公平的糖果交换
 * <p>
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 * @date 2018/10/24
 */
public class _888 {
    //遍历数组A，B 求值
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int[] ans = new int[2];
        int need = (sum(A) - sum(B)) / 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] - B[j] == need) {
                    ans[0] = A[i];
                    ans[1] = B[j];
                    return ans;
                } else {
                    continue;
                }
            }
        }
        return ans;
    }

    public int sum(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }
        return res;
    }

    public static void main(String[] args) {
        _888 t = new _888();
        int[] A = {1, 1};
        int[] B = {2, 2};
        for (int i : t.fairCandySwap(A, B)
                ) {
            System.out.println(i);
        }

    }

}
