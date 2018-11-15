/**
 * 机器人能否返回原点（Judge Route Circle）
 * <p>
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 *
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
