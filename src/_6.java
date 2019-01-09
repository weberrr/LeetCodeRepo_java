import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 *
 * @date 2019/1/1
 */
public class _6 {

    /**
     * 关键词：方向指针
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 对新生成的 Z字形 图形 建立一个 list ， list<StringBuilder>中 每个sb 存储每行的字符
     * 设定一个方向指针，在行指针 index 等于第0行或最后一行时切换方向
     * 最后合并list即可
     *
     **/

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        boolean goDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == rows.size() - 1 || curRow == 0) goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb: rows) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _6().convert("LEETCODEISHIRING",3));
    }
}
