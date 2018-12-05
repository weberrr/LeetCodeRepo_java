/**
 * 第三大的数
 *
 * @date 2018/12/5
 */
public class _414 {
    public int thirdMax(int[] nums) {
        int min = Integer.MIN_VALUE;
        int mid = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int status = 7; // 二进制 111
        for (int i = 0; i < nums.length; i++) {
            //max更新过1次  mid更新过1次  min更新过1次
            if ((nums[i] == max && (status & 4) == 0) ||
                    (nums[i] == mid && (status & 2) == 0) ||
                    (nums[i] == min && (status & 1) == 0)) {
                continue;
            }
            status >>= 1;
            if (nums[i] > max) {
                min = mid;
                mid = max;
                max = nums[i];
            } else if (nums[i] > mid) {
                min = mid;
                mid = nums[i];
            } else if (nums[i] > min) {
                min = nums[i];
            }
        }
        if ((status & 7) == 0) {
            return min;
        } else {
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648, 1, 2};
        System.out.println(new _414().thirdMax(nums));
    }
}
