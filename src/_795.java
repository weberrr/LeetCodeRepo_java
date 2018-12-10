import java.util.Arrays;

/**
 * 区间子数组个数
 *
 * @date 2018/12/10
 */
public class _795 {

    //时间复杂度o(n)
    //以 2 1 3 4 5 L=2,R=4为例
    // num = 1 时，当前所有可以为head的子数组（即2），都多了一种情况（后面加个1）
    // num = 3 时，开头多了情况（213,13,3），即之前的tails数量+1（本身作为开头）
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans = 0, heads = 0, tails = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                heads += tails + 1;    // heads多了：前面的tails作为开头前缀 + A[i]本身作为开头
                ans += heads;   // 目前的A[i]作为结尾的所有情况
                tails = 0;     // 新一轮heads下的tails数清零
            }else if(A[i]<L){
                tails ++;
                ans += heads;
            }else {
                heads = 0;
                tails = 0;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] A = new int[]{2, 9, 2, 5, 6};
        System.out.println(new _795().numSubarrayBoundedMax(A, 2, 8));
    }

}
