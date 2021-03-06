// space efficient
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int count = 0;
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[j]) {
                count++;
            } else {
                j++;
            }
        }
        return count;
    }
}

// use PriorityQueue, takes O(N) space
// since we need to keep track of all existing rooms, a single variable to hold the earlist end time is not enough
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        Queue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        // Queue<Interval> minHeap = new PriorityQueue<>(new Comparator<Interval>() {
        //     public int compare(Interval a, Interval b) {
        //         return a.end - b.end;
        //     }
        // });
        minHeap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = intervals[i];
            Interval top = minHeap.poll();
            if (cur.start >= top.end) {
                top.end = cur.end;
            } else {
                minHeap.offer(cur);
            }
            minHeap.offer(top);
        }
        return minHeap.size();
    }
}
