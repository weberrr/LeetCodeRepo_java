/**
 * 45. 跳跃游戏 II
 *
 * @date 2019/1/13
 */
public class _45 {

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int reach = 0; // 目前已经到达的
        int nextReach = nums[0]; //下一步要到达的
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextReach = Math.max(nextReach, nums[i] + i);
            if (nextReach >= nums.length - 1) return step + 1;
            if (i == reach) { //下标赶上了已经到达的，需要至少再走一步了
                step++;
                reach = nextReach;
            }
        }
        return step;
    }
}
