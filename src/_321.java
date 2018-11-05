import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 拼接最大数
 * <p>
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，
 * 要求从同一个数组中取出的数字保持其在原数组中的相对顺序
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * @date 2018/11/5
 */
public class _321 {

    //两个子问题，求最大长度的数，合并
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] maxMerge = new int[k];
        for (int i = 0; i <= k; i++) {
            if (nums1.length >= i && nums2.length >= k - i) {
                int[] sub1 = getMaxSub(nums1, i);
                int[] sub2 = getMaxSub(nums2, k - i);
                int[] merge = mergeMaxSub(sub1, sub2);
                maxMerge = maxArray(maxMerge, merge);
            }
        }
        return maxMerge;
    }

    private int[] maxArray(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > array2[i]) {
                return array1;
            } else if (array1[i] < array2[i]) {
                return array2;
            } else {
                continue;
            }
        }
        return array1;
    }

    public int[] getMaxSub(int[] array, int size) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (stack.empty()) {
                stack.push(array[i]);
            } else {
                if (size - stack.size() == array.length - i) {
                    stack.push(array[i]);
                } else {
                    int top = stack.peek();
                    boolean pushIn = false;
                    while ((array[i] > top) && (size - stack.size() < array.length - i)) {
                        stack.pop();
                        if (stack.empty()) {
                            stack.push(array[i]);
                            pushIn = true;
                            break;
                        } else {
                            top = stack.peek();
                        }
                    }
                    if (!pushIn) {
                        stack.push(array[i]);
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return Arrays.copyOfRange(res,0,size);
    }

    public int[] mergeMaxSub(int[] sub1, int[] sub2) {
        int[] temp = new int[sub1.length + sub2.length];
        for (int i = 0, p = 0, q = 0; i < temp.length; i++) {
            if (p < sub1.length && q < sub2.length) {
                if (sub1[p] > sub2[q]) {
                    temp[i] = sub1[p++];
                } else if (sub1[p] < sub2[q]) {
                    temp[i] = sub2[q++];
                } else {
                    int tempP = p;
                    int tempQ = q;
                    while (true) {
                        if (tempP < sub1.length && tempQ < sub2.length) {
                            if (sub1[tempP] == sub2[tempQ]) {
                                tempP++;
                                tempQ++;
                            } else if (sub1[tempP] > sub2[tempQ]) {
                                temp[i] = sub1[p++];
                                break;
                            } else {
                                temp[i] = sub2[q++];
                                ;
                                break;
                            }
                        } else if (tempP >= sub1.length) {
                            temp[i] = sub2[q++];
                            break;
                        } else {
                            temp[i] = sub1[p++];
                            break;
                        }
                    }
                }
            } else if (q >= sub2.length) {
                temp[i] = sub1[p++];
            } else if (p >= sub1.length) {
                temp[i] = sub2[q++];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        _321 test = new _321();
        int[] nums1 = {6,7,5};
        int[] nums2 = {4,8,1};
        int k = 3;
        int[] resArray = test.maxNumber(nums1, nums2, k);
        for (int i = 0; i < resArray.length; i++) {
            System.out.println(resArray[i]);
        }
    }

}
