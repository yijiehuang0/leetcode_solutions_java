import java.util.*;
public class mergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length < 1) return intervals;                      // if the intervals length is less than one then return
        int len = intervals.length;
        int count = 0;
        for(int i = 0; i < len; i++) {         // this goes through all the intervals
            for(int j = i + 1; j < len; j++) {                  // this goes through all the intervals less than i;
                int digitA0 = intervals[i][0], digitA1 = intervals[i][1];     // the first and the last digits
                int digitB0 = intervals[j][0], digitB1 = intervals[j][1];
                if(digitA0 > digitB1 || digitA1 < digitB0) continue;    // a starts after b end, or a ends before b starts
                intervals[j][0] = Math.min(digitA0, digitB0);           // otherwise there is some overlap.
                intervals[j][1] = Math.max(digitA1, digitB1);
                intervals[i][0] = Integer.MAX_VALUE;
                count++;
                break;
            }
        }

        // the idea here is to keep changing the values of everything ahead of it,
        int[][] ans = new int[len - count][2];
        int j = 0;
        for(int i = 0; i < len; i++) {
            if(intervals[i][0] != Integer.MAX_VALUE) {
                ans[j] = intervals[i];
                j++;
            }
        }
        return ans;
    }


    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));      // to sort arrays we use array.sort and to sort collections we use Collections.sort with a lambda function in between
        List<int[]> ret = new ArrayList<>(); // list of intervals to return
        int prevStart = intervals[0][0]; // first start
        int prevEnd = intervals[0][1];   // first end
        Queue<Integer> time = new LinkedList<>();
        time.add(prevEnd);
        for(int i = 1; i< intervals.length; i++) {
            int[] curr = intervals[i];    // current interval
            int currStart = curr[0];       // the current start
            int currEnd = curr[1];         // current end
            prevEnd = time.poll();      // gets the last ending time
            if(prevEnd < currStart) {  // CASE: ends
                int[] times = new int[]{prevStart, prevEnd};
                ret.add(times);
                time.add(currEnd);
                prevStart = currStart;
                prevEnd = currEnd;
            } else {
                time.add(Math.max(currEnd, prevEnd));
            }
        }
        if(!time.isEmpty()) {
            ret.add(new int[]{prevStart, time.poll()});
        }

        return ret.toArray(new int[ret.size()][]);
    }

    /*
    ArrayList.toArray(new int[ArrayList.size()]) // this is a method of how to to turn an ArrayList into an Array
    Just so you know, we do Array.sort(array, lambda function) when we are dealing with
     */


}
