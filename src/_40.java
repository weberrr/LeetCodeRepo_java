import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @date 2019/1/11
 */
public class _40 {

    /**
     * 关键词：回溯
     * 时间复杂度：o(^n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 选择：从下标index开始，选择candidates中的不重复值
     * 条件：遇到重复的值跳过，remain = target - candidates[i]>0
     * 结束：remain <=0
     **/

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> perAns = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, perAns, 0, target, candidates);
        return list;
    }

    //每次从index开始找
    private void backtrack(List<List<Integer>> list, List<Integer> perAns, int index, int target, int[] candidates) {
        if (target == 0) {
            //深拷贝
            list.add(new ArrayList<>(perAns));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            perAns.add(candidates[i]);
            backtrack(list, perAns, i + 1, target - candidates[i], candidates);
            perAns.remove(perAns.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _40().combinationSum2(new int[]{1, 1, 5, 6}, 7));
    }
}
