/**
 * 盛最多水的容器
 *
 * @date 2019/1/1
 */
public class _11 {

    /**
     * 关键词：双指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大
     * 通过双指针，持续存储过程中的最大面积，并将指向较短线段的指针向较长线段那端移动一步
     **/

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area = 0;
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new _11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
