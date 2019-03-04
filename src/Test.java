import java.lang.reflect.Type;
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
        short s1 = 1;
        System.out.println(s1);
        s1 +=1;

    }

}
