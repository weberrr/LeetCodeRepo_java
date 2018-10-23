/**
 * Judge Route Circle
 *
 * @author wangz
 * @date 2018/10/23
 */
public class _657 {
    public boolean judgeCircle(String moves) {
        int baseX = 0;
        int baseY = 0;
        char[] charArray = moves.toCharArray();
        for (char c : charArray
                ) {
            if (c == 'R') {
                baseX += 1;
            } else if (c == 'L') {
                baseX -= 1;
            } else if (c == 'U') {
                baseY += 1;
            } else if (c == 'D') {
                baseY -= 1;
            }

        }
        if (baseX == 0 && baseY == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        _657 t = new _657();
        String s = "LL";
        System.out.println(t.judgeCircle(s));
    }
}
