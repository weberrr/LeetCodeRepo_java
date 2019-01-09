import java.util.HashMap;

/**
 * 1. Two Sum (两数之和)
 *
 * @date 2018/11/15
 */
public class _1 {

    /**
     * 关键词：哈希表
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：将数组转为哈希表，map中存入数组中的每个 (value,index) ， 一次循环，查取 target-nums[i] 是否在map中
     **/

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
            }
        }
        return res;
    }


    /**
     * 改进：法1使用了两遍哈希表，法2可以只是用一遍哈希表，时间、空间复杂度相同
     */
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(nums[i]), map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }

}
