import java.util.*;
import Utils.*;

/**
 * 435. 无重叠区间
 */
public class _435 {

    //构建优先队列 使用两次循环
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        for (Interval interval : intervals) {
            priorityQueue.offer(interval);
        }
        int res = 0;
        int end = Integer.MIN_VALUE;
        while (!priorityQueue.isEmpty()) {
            Interval cur = priorityQueue.poll();
            if (cur.start >= end) {
                end = cur.end;
            } else {
                res += 1;
            }
        }
        return res;
    }

    //使用Array.sort 一次循环
    public int eraseOverlapIntervals2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        };
        Arrays.sort(intervals, comparator);
        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].start >= end) end = intervals[i].end;
            else res += 1;
        }
        return res;
    }


    public static void main(String[] args) {
        Interval temp = new Interval();
        Interval[] list =  temp.createIntervalArray("[[1,2],[2,3],[3,4],[100,-2],[5,7]]");
        Interval[] list1 = new Interval[]{new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(-100, 4), new Interval(5, 7)};
        System.out.println(new _435().eraseOverlapIntervals(list));
    }
}
