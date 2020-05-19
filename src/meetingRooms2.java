import java.util.*;
public class meetingRooms2 {

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals.length < 1) return 0;

        // Sort the array based on interval's start time
        Arrays.sort(intervals, (a,b) -> {   // O(N log N) -- time
            return a[0] - b[0];
        });

        // put 'end time' of interval
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // put end times, O(N) -- space the default implementation is a min heap
        int count = 0;

        for (int[] interval : intervals) {
            if (pq.isEmpty() || interval[0] < pq.peek()) {
                pq.add(interval[1]); // this means that anohter meeting starts
                count++;
            } else {
                pq.poll(); // removal of a meeting
                pq.add(interval[1]); // means the introduction of a new meeting thus
            }
        }
        return count;
        // in this case we would wnat to sort by each element of
//        int[] starts = new int[intervals.length];
//        int[] ends = new int[intervals.length];
//        for(int i=0; i<intervals.length; i++) {
//            starts[i] = intervals[i][0];
//            ends[i] = intervals[i][1];
//        }
//        Arrays.sort(starts);
//        Arrays.sort(ends);
//        int rooms = 0;
//        int endsItr = 0;
//        for(int i=0; i<starts.length; i++) {
//            if(starts[i]<ends[endsItr])
//                rooms++;
//            else
//                endsItr++;
//        }
//        return rooms;
    }

    public static int maxIntervals(int[][] intervals, int start) {
        int i = intervals[start][0];
        int j = intervals[start][1];
        int rooms = 1;
        for (int x = start + 1; x <= intervals.length - 1; x++) {
            int tempi = intervals[x][0];
            int tempj = intervals[x][1];
            if (tempi >= i && tempi <= j && tempj > i && tempj <= j) {
                j = i;
                i = tempi;
                rooms++;
            } else {
                break;
            }
        }

        return rooms;

    }

    public static void main(String[] args) {
        int[][] a = new int[4][2];
        a[0] = new int[] {5, 8};
        a[1] = new int[] {6, 8};
        a[2] = new int[] {9, 12};
        a[3] = new int[] {9, 10};



        minMeetingRooms(a);
    }

}
