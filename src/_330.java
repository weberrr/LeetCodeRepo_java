/**
 * 按要求补齐数组 (Patching Array)
 *
 * @date 2018/11/27
 */
public class _330 {

    //贪心算法
    public int minPatches(int[] nums, int n) {
        long cover = 1;  // 目前数组可组成[0,cover)的值
        int index = 0;
        int number = 0;  // 需要添加的数字数量
        while (cover <= n) {
            //如果cover不能达到nums[index],加一个数，把cover翻倍
            if (index >= nums.length || cover < nums[index]) {
                number++;
                cover = cover * 2;
            } else {
                //如果cover能达到nums[index],则多了一个数，现在能组成 [0,cover + num[i])的所有数
                cover = cover + nums[index++];
            }
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new _330().minPatches(new int[]{1, 2, 31, 33}, 2147483647));
    }
}
