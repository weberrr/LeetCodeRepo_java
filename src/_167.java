/**
 * (Two Sum II - Input array is sorted)两数之和 II - 输入有序数组
 *
 * @date 2018/11/15
 */
public class _167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        while (endIndex > startIndex) {
            int sum = numbers[startIndex] + numbers[endIndex];
            if (sum == target) {
                res[0] = startIndex + 1;
                res[1] = endIndex + 1;
                return res;
            } else if (sum > target) {
                endIndex -= 1;
            } else {
                startIndex += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _167 test = new _167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(test.twoSum(numbers, target)[0] + " " + test.twoSum(numbers, target)[1]);
    }

}
