import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * @date 2019/2/20
 */
public class _90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int startIndex, ArrayList<Integer> list) {
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(res, nums, i + 1, list);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _90().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
