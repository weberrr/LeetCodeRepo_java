/**
 * 42. 接雨水
 *
 * @date 2019/1/12
 */
public class _42 {

    //双指针
    //可以考虑dp？
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
