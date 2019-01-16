import Utils.*;

import java.util.*;

/**
 * 56. 合并区间
 *
 * @date 2019/1/16
 */
public class _56 {

    //优先队列
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return res;
        PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.size(), new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
            }
        });
        for (Interval i : intervals) {
            queue.offer(i);
        }
        Interval first = queue.poll();
        int start = first.start;
        int end = first.end;
        while (!queue.isEmpty()) {
            Interval interval = queue.poll();
            if (interval.start > end) {
                res.add(new Interval(start, end));
                start = interval.start;
            }
            end = Math.max(end, interval.end);
        }
        res.add(new Interval(start, end));
        return res;
    }

    //优化 : 将start和end分两个数组并排序  每次比较start[i+1] > end[i] 如果满足 则加入 start[j],end[i] 并把j = i+1
    public List<Interval> merge2(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || start[i + 1] > end[i]) {
                res.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Interval> list = new Interval().createIntervalList("[[1,4],[2,3]]");
        List<Interval> res = new _56().merge(list);
        new Interval().printIntervalList(res);
    }
}
