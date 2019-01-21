/**
 * 55. 跳跃游戏
 *
 * @date 2019/1/15
 */
public class _55 {

    /**
     * 关键词：贪心算法
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 从后往前贪心：i + nums[i] >= leftMostGoodPosition时，更新leftMostGoodPosition为i
     **/

    public boolean canJump(int[] nums) {
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
