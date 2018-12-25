import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @date 2018/12/25
 */
public class _118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> last = new ArrayList<>(res.get(i - 1));
            List<Integer> list = new ArrayList<>();
            last.add(last.size(), 0);
            last.add(0, 0);
            for (int j = 0; j < last.size() - 1; j++) {
                list.add(last.get(j) + last.get(j + 1));
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _118().generate(0));
    }
}
