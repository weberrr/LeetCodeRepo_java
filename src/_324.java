import java.util.Arrays;

/**
 * 摆动排序 II
 * <p>
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * @date 2018/10/24
 */
public class _324 {

    //先排序，然后把中位数之前的一半作为小数，之后的一半作为大数，两个指针从后面往前插入
    public void wiggleSort(int[] nums) {
        int[] tempArray = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(tempArray);
        int small = nums.length / 2 + (nums.length % 2 == 0 ? -1 : 0);
        int large = nums.length - 1;
        for (int i = 0, j = 1; i < nums.length; i += 2, j += 2) {
            nums[i] = tempArray[small--];
            if(j<nums.length) {
                nums[j] = tempArray[large--];
            }
        }
    }

    public static void main(String[] args) {
        _324 t = new _324();
        int[] a = {4, 5, 6};
        t.wiggleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
