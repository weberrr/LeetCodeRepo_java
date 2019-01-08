/**
 * 33. 搜索旋转排序数组
 *
 * @date 2019/1/8
 */
public class _33 {

    /**

     采用二分搜索，主要问题在于确定每次搜索的左右边界。
     根据目标的大小，可以将搜索分为两种情况，根据中点的情况又可细分为 6 种具体情况。
     每种情况由三个条件区分
     a = A[0] > target ；b = A[m] >= A[0] ；c = A[m] > target

     其中m为每次搜索中点，t为可能的target所在索引。l，r为搜索的左右边界。

     情况1： l ----- m -----|----- t ----- r 条件：a=t,b=t,c=t； 结果： l=m+1；a ^ b ^ c = t
     情况2： l -------------|- m - t ----- r 条件：a=t,b=f,c=f； 结果： l=m+1；a ^ b ^ c = t
     情况3： l - m - t -----|------------- r 条件：a=f,b=t,c=f； 结果： l=m+1；a ^ b ^ c = t

     情况4： l -------------|----- t - m - r 条件：a=t,b=f,c=t； 结果： r=m-1；a ^ b ^ c = f
     情况5： l ----- t - m -|------------- r 条件：a=f,b=t,c=t； 结果： r=m-1；a ^ b ^ c = f
     情况6： l ----- t -----|----- m ----- r 条件：a=f,b=f,c=f； 结果： r=m-1；a ^ b ^ c = f

     情况123，需要将左边界右移，对应条件为 a ^ b ^ c == t
     情况456，需要将右边界左移，对应条件为 a ^ b ^ c == f

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
