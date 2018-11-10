/**
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * @date 2018/10/24
 */
public class _326 {
    public boolean isPowerOfThree(int n) {
      return (Math.log10(n)/Math.log10(3))%1==0?true:false;
    }

    public static void main(String[] args) {
        _326 t = new _326();
        System.out.println(t.isPowerOfThree(27));
    }
}
