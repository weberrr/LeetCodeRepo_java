/**
 * 55. 跳跃游戏
 *
 * @date 2019/1/15
 */
public class _55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        else if (nums[0] == 0) return nums.length == 1;

        int maxReach = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == 0 && i >= maxReach) return false;
            maxReach = Math.max(i + nums[i], maxReach);
            if (maxReach >= nums.length - 1) return true;
        }
        return maxReach >= nums.length - 1;
    }

    //优化 从后往前贪心
    public boolean canJump2(int[] nums) {
        int leftMostGoodPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= leftMostGoodPosition) {
                leftMostGoodPosition = i;
            }
        }

        return leftMostGoodPosition == 0;
    }

    public static void main(String[] args) {
        System.out.println(new _55().canJump(new int[]{}));
    }
}
