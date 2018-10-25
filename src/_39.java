import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @date 2018/10/25
 */
public class _39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }

    private boolean backTrack(List<List<Integer>> result, List<Integer> ansList, int[] candidates, int start, int remain) {
        if (remain < 0) {
            return false;
        } else if (remain == 0) {
            result.add(new ArrayList<>(ansList));
            return false;
        } else {
            for (int i = start; i < candidates.length; i++) {
                ansList.add(candidates[i]);
                boolean flag = backTrack(result, ansList, candidates, i, remain - candidates[i]);
                ansList.remove(ansList.size() - 1);
                if (!flag) {
                    break;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        _39 t = new _39();
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(t.combinationSum(candidates, 8));
    }
}
