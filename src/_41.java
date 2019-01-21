/**
 * 41. 缺失的第一个正数
 *
 * @date 2019/1/11
 */
public class _41 {

    /**
     * 关键词：交换排序
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 每次找到num[i]所对应的num[num[i]]，交换二者
     * 之后在做一次遍历，找到第一个num[i]!=i+1的值
     **/

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(new _41().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
