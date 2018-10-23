import java.util.*;

/**
 * Smallest Range II
 *
 * @author wangz
 * @date 2018/10/22
 */
public class _910 {
    public static int smallestRangeII(int[] A, int K) {
       Arrays.sort(A);
       int n = A.length;
       int min = A[0];
       int max = A[n-1];
       int res = max-min;
        for (int i = 0; i < n-1; i++) {
            max = Math.max(max,A[i]+2*K);
            min = Math.min(A[0]+2*K,A[i+1]);
            res = Math.min(res,max-min);
        }
        return res;
    }
    public static void main(String[] args){
        int[] A = {1};
        System.out.println(smallestRangeII(A,0));
    }

}
