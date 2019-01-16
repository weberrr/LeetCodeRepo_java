package Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangz
 * @date 2019/1/16
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    public List<Interval> createIntervalList(String s) {
        s = s.substring(1, s.length() - 1); // 去除外层 [ ]
        String[] perIntervalStr = s.split("\\],\\[");
        List<Interval> list = new ArrayList<>();
        for (String str : perIntervalStr) {
            str = str.replace("[", "").replace("]", "");// 去除内层 [ ]
            String[] nums = str.split(",");
            list.add(new Interval(Integer.valueOf(nums[0]), Integer.valueOf(nums[1])));
        }
        return list;
    }

    public String printIntervalList(List<Interval> list) {
        StringBuilder res = new StringBuilder();
        for (Interval interval : list) {
            res.append("[").append(interval.start).append(",").append(interval.end).append("]");
        }
        System.out.println("[" + res.toString() + "]");
        return res.toString();
    }

    public Interval[] createIntervalArray(String s) {
        s = s.substring(1, s.length() - 1); // 去除外层 [ ]
        String[] perIntervalStr = s.split("\\],\\[");
        Interval[] list = new Interval[perIntervalStr.length];
        for (int i = 0; i < perIntervalStr.length; i++) {
            String str = perIntervalStr[i];
            str = str.replace("[", "").replace("]", "");// 去除内层 [ ]
            String[] nums = str.split(",");
            list[i] = new Interval(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]));
        }
        return list;
    }

    public String printIntervalArray(Interval[] list) {
        StringBuilder res = new StringBuilder();
        for (Interval interval : list) {
            res.append("[").append(interval.start).append(",").append(interval.end).append("]");
        }
        System.out.println("[" + res.toString() + "]");
        return res.toString();
    }

}
