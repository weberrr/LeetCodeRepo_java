/**
 * 寻找两个有序数组的中位数
 *
 * @dnums1te 2019/1/1
 */
public class _4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = nums1.length;
            n = nums2.length;
        }
        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = (imax + imin) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < imax && nums2[j - 1] > nums1[i]) {
                imin = i + 1; // i is too small
            } else if (i > imin && nums1[i - 1] > nums2[j]) {
                imax = i - 1; // i is too big
            } else { // i is perfect
                int minLeft = 0;
                if (i == 0) {
                    minLeft = nums2[j - 1];
                } else if (j == 0) {
                    minLeft = nums1[i - 1];
                } else {
                    minLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return minLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (minLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }

}
