/**
 * 33. 搜索旋转排序数组
 *
 * @date 2019/1/8
 */
public class _33 {

    /**
     * 关键词：二分搜索
     * 时间复杂度：o(log n)
     * 空间复杂度：o(1)
     * <p>
     * 思路：
     * 因为要求时间复杂度o(log n)，所以考虑二分
     * 根据目标的大小，可将搜索分为两种情况，根据中点的情况，可将搜索再细分为6中情况
     * 每种情况由3个条件区分：
     * a: A[mid] >= A[0]?    t:左边为增，f:右边为增
     * b: A[0] > target?     t:target在旋转后的右半边， f:target在旋转后的左半边
     * c: A[mid] > target?   根据 a，b 情况而定（但a为t，b为t时，A[mid] >= A[0]> target，c一定为t）
     *
     * 记 ：m为每次搜索中点，t为可能的target所在索引，l,r为每次搜索边界
     * 情况1： l ------------- m ----- t ----- r   条件：a=t,b=t,c=t   结果： l=m+1；a ^ b ^ c = t
     * e.g    4               7       2       3
     * 情况2： l ------------- m --- t ------- r   条件：a=t,b=f,c=f   结果： l=m+1；a ^ b ^ c = t
     * e.g    4               6     7         3
     * 情况3： l ------------- m - t --------- r   条件：a=f,b=t,c=f   结果： l=m+1；a ^ b ^ c = t
     * e.g    4               1   2           3
     *
     * 情况4： l ----- t ----- m ------------- r   条件：a=t,b=f,c=t   结果： r=m-1；a ^ b ^ c = f
     * e.g    4       5       7               3
     * 情况5： l ------- t --- m ------------- r   条件：a=f,b=t,c=t   结果： r=m-1；a ^ b ^ c = f
     * e.g    4         1     2               3
     * 情况6： l - t --------- m ------------- r   条件：a=f,b=f,c=f   结果： r=m-1；a ^ b ^ c = f
     * e.g    4   7           2               3
     *
     * 情况123，需要将左边界右移，对应条件为 a ^ b ^ c == t
     * 情况456，需要将右边界左移，对应条件为 a ^ b ^ c == f
     **/

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if ((nums[0] > target) ^ (nums[mid] >= nums[0]) ^ (nums[mid] > target)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new _33().search(new int[]{1, 3}, 3));
    }
}
