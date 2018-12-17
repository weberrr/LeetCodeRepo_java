import java.util.*;

/**
 * 优美的排列
 *
 * @date 2018/12/17
 */
public class _526 {


    private int res = 0;

    // 回溯问题  用0 1表示数字是否使用的状态 从后往前依次填数 并遍历所有情况
    public int countArrangement(int N) {
        int[] nums = new int[N + 1];
        dfs(nums, N);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == 1) {
            res++;
        }
        for (int n = 1; n < nums.length; n++) {
            if (nums[n] == 0 && (n % index == 0 || index % n == 0)) {
                nums[n] = 1;
                dfs(nums, index - 1);
                nums[n] = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _526().countArrangement(3));
    }

}
