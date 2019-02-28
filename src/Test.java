import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wangz
 * @date 2018/11/12
 */
public class Test {
    public static int T(int i) {
        if (i == 1) return 1;
        if (i == 2) return 2;
        else return T(i - 1) + T(i - 2) + 5;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(T(i));
        }
    }
}
