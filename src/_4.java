/**
 * 寻找两个有序数组的中位数
 *
 * @dnums1te 2019/1/1
 */
public class _4 {

    /**
     * 关键词：堆 + 中位数的性质
     * 时间复杂度：o(log(min(m,n)))
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 1. 将数组 A,B 各分为两部分，如下图所示：
     * |      left_part          |          right_part       |
     * |A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]|
     * |B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]|
     * 2. 由中位数的性质可知,分组需满足：
     * len(left_part) = len(right_part)
     * max(left_part) <= min(right_part)
     * 则 median = (max(left_part) + min(right_part))/2
     * 3. 要满足上述，则有：
     * i + j = m - i + n - j (或 m -i + n - j + 1) . 如果 n > m 则 只需要 i = 0~m , j = (m + n + 1)/2 - i
     * B[j-1] <= A[i] 且 A[i-1] <= B[j]
     * 4. 条件有了，考虑情况：
     * (1)  B[j−1] ≤ A[i] 且 A[i-1] <= B[j] 则 i 完美
     * (2)  B[j−1] > A[i] 则需 j⬇即i⬆️，要增大 i
     * ️(2)  A[i-1] > B[j] 则需 i⬇️，要减小 i
     * 5. 对于i的增减，可以使用二分法，减少循环中的时间复杂度
     * 6. 实现的时候在输出中位数时，注意考虑边界条件：如i=0或i=m等
     **/

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
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }

}
