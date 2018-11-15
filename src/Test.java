import java.util.HashMap;

/**
 * @author wangz
 * @date 2018/11/12
 */
public class Test{
    public static void main(String[] args){
        HashMap<String,String> t = new HashMap<>();
        t.put("1","11");
        t.put("1","22");
        System.out.println(t.get("1"));
    }
}
