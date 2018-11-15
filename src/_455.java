import java.util.Arrays;

/**
 * Assign Cookies (分发饼干)
 * @date 2018/11/15
 */
public class _455 {

    // 贪心
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                ans += 1;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _455 test = new _455();
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(test.findContentChildren(g, s));
    }
}
