import java.util.*;

/**
 * 47. 全排列 II
 *
 * @date 2019/1/13
 */
public class _47 {

    //回溯
    //https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51644993
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> perAns = new ArrayList<>();
            for (int num : nums) {
                perAns.add(num);
            }
            list.add(perAns);
        } else {
            Set<Integer> appeared = new HashSet<>();
            for (int i = index; i < nums.length; i++) {
                if (appeared.add(nums[i])) {
                    swap(nums, i, index);
                    backtrack(list, nums, index + 1);
                    swap(nums, i, index);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //最快的方法：设定符号位
    public List<List<Integer>> permuteUnique2(int[] nums) {
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
