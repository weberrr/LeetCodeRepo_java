import java.util.*;

/**
 * 47. 全排列 II
 *
 * @date 2019/1/13
 */
public class _47 {

    /**
     * 关键词：符号位 + 回溯
     * 时间复杂度：o(^n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 先给数组排个序，设定一个符号位，记录当前位置的数字是否被使用
     * 如果和前一个数相等，并且前一个数没使用，则说明重复了
     **/
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _47().permuteUnique(new int[]{1, 2, 1}));
    }
}
