import java.util.HashMap;

/**
 * Two Sum (两数之和)
 *
 * @date 2018/11/15
 */
public class _1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])&& i != map.get(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
        }
        return res;
    }

}
