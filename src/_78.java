import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 *
 * @date 2019/2/19
 */
public class _78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        res.add(new ArrayList<>());
        dfs(0, res, nums, new ArrayList<>());
        return res;
    }

    private void dfs(int curIndex, List<List<Integer>> res, int[] nums, List<Integer> list) {
        for (int i = curIndex; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(i + 1, res, nums, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = 1 << nums.length;
        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) > 0) {
                    temp.add(nums[j]);
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _78().subsets2(new int[]{1, 2, 3}));
    }
}
