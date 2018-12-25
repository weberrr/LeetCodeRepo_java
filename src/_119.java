import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 II
 *
 * @date 2018/12/25
 */
public class _119 {

    //C(0,n) C(1,n) C(2,n) ... C(n,n)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long num = 1;
        res.add(1);
        if (rowIndex == 0) return res;
        for (int i = 1; i < rowIndex; i++) {
            num *= rowIndex - i + 1;
            num /= i;
            res.add((int) num);
        }
        res.add(1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _119().getRow(0));
    }
}
