import Utils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. 插入区间
 *
 * @date 2019/1/16
 */
public class _57 {


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int start = newInterval.start, end = newInterval.end;
        boolean flag = false;
        for (Interval interval : intervals) {
            if (interval.end < start) {
                res.add(interval);
            } else if (interval.start <= end) {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            } else if (interval.start > end) {
                if(!flag) {
                    res.add(new Interval(start, end));
                    flag = true;
                }
                res.add(interval);
            }
        }
        if(!flag) {
            res.add(new Interval(start, end));
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new Interval().createIntervalList("[[1,3],[6,9]]");
        List<Interval> list = new _57().insert(intervals, new Interval(2, 5));
        new Interval().printIntervalList(list);
    }
}
