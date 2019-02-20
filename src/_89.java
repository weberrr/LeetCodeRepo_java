import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 *
 * @date 2019/2/20
 */
public class _89 {

    // 回溯算法
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(n, res);
        return res;
    }

    private void dfs(int n, List<Integer> list) {
        if (n == 0) {
            return;
        }
        int len = list.size();
        for (int i = len - 1; i >= 0; i--) {
            list.add(list.get(i) + len);
        }
        dfs(n - 1, list);
    }

    //优化 ： 位运算
    public List<Integer> grayCode2(int n) {
        /**
         关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
         如 n = 3:
         G(0) = 000,
         G(1) = 1 ^ 0 = 001 ^ 000 = 001
         G(2) = 2 ^ 1 = 010 ^ 001 = 011
         G(3) = 3 ^ 1 = 011 ^ 001 = 010
         G(4) = 4 ^ 2 = 100 ^ 010 = 110
         G(5) = 5 ^ 2 = 101 ^ 010 = 111
         G(6) = 6 ^ 3 = 110 ^ 011 = 101
         G(7) = 7 ^ 3 = 111 ^ 011 = 100
         **/
        List<Integer> result = new ArrayList<>();
        int count = 1 << n;
        for (int i = 0; i < count; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _89().grayCode(0));
    }
}
