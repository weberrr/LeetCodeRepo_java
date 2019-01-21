/**
 * 42. 接雨水
 *
 * @date 2019/1/12
 */
public class _42 {

    /**
     * 关键词：双指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 记录左右指针 l r，左右最高 ml mr
     * 从矮的一边进行向中行进，每次行进，如果高度下降了， res += ml - height[l] ，如果高度上升了，接不到雨水，更新 l r ml mr即可
     **/

    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int ml = height[0]; // 左边最高
        int mr = height[height.length - 1]; //右边最高
        int l = 1;
        int r = height.length - 2;
        int res = 0;
        while (l <= r) {
            if (ml < mr) {
                if (height[l] < ml) {
                    res += ml - height[l];
                } else {
                    ml = height[l];
                }
                l++;
            } else {
                if (height[r] < mr) {
                    res += mr - height[r];
                } else {
                    mr = height[r];
                }
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
