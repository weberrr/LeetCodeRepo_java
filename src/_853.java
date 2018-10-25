import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 车队(Car Fleet)
 * <p>
 * N 辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * 会有多少车队到达目的地?
 *
 * @date 2018/10/25
 */
public class _853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] basePos = Arrays.copyOfRange(position, 0, position.length);
        Arrays.sort(position);
        HashMap<Integer, Integer> mapPos = new HashMap<>();
        for (int i = 0; i < basePos.length; i++) {
            mapPos.put(basePos[i], i);
        }
        double[] time = new double[position.length];
        for (int j = position.length - 1; j >= 0; j--) {
            int t = mapPos.get(position[j]);
            time[j] = ((double) (target - position[j])) / speed[t];
            if (j == position.length - 1) {
                continue;
            } else if (time[j] < time[j + 1]) {
                time[j] = time[j + 1];
            }
        }
        List<Double> arraylist = new ArrayList<Double>();
        for (int i = 0; i < time.length; i++) {
            if (!arraylist.contains(time[i])) {
                arraylist.add(time[i]);
            }
        }
        return arraylist.size();
    }

    public static void main(String[] args) {
        _853 t = new _853();
        int target = 10;
        int[] position = {2, 4};
        int[] speed = {3, 2};
        System.out.println(t.carFleet(target, position, speed));
    }

}
