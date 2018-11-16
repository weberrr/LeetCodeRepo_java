import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Minimum Index Sum of Two Lists（两个列表的最小索引总和）
 *
 * @date 2018/11/16
 */
public class _599 {

    //思路：用哈希表存储一个list，在哈希表中查找另一个list中的元素是否存在，并记录最小下标
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int minIndex = 2000;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tempIndex = map.get(list2[i]) + i;
                if (tempIndex < minIndex) {
                    list.clear();
                    minIndex = tempIndex;
                    list.add(list2[i]);
                } else if (tempIndex == minIndex) {
                    list.add(list2[i]);
                }
            }
        }
        return (String[]) list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        _599 test = new _599();
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] res = test.findRestaurant(list1, list2);
        System.out.println(Arrays.asList(res));
    }
}
