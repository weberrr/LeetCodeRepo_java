import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * @date 2019/2/21
 */
public class _88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = --m + --n + 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new _88().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
