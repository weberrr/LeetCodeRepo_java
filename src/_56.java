import Utils.*;

import java.util.*;

/**
 * 56. 合并区间
 *
 * @date 2019/1/16
 */
public class _56 {

    /**
     * 关键词：优先队列
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：
     * 构建优先队列，然后如果遇到 重叠区间，记录 start 和 end 的值。直到遇到start > 记录的end
     **/

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

    /**
     * 优化
     * 关键词：辅助数组
     * 时间复杂度：o(n)
     * 空间复杂度：o(n)
     * <p>
     * 思路：分别记录start、end
     * 然后遇到start[i+1]>end[i] 则存入 interval[start[j],end[i])
     **/
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
