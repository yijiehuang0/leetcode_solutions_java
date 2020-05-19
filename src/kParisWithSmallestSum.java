import java.util.*;
public class kParisWithSmallestSum {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ret;
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a1, a2) -> ((a2.get(0) + a2.get(1)) - (a1.get(0) + a1.get(1))));
        // we can make this nlogk in this case if we only store k things actually within teh thigns
        // we have a miniheap in this case,
        // we turn it into a maxheap and then if the size is greater than k then we are going to pop off one and thus it is faster with a nlogk runtime instead
        for(int i: nums1) {
            for(int j: nums2) {
                List<Integer> toAdd = new ArrayList<>();
                toAdd.add(i);
                toAdd.add(j);
                pq.add(toAdd);
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }

        for(int i = 0; i < pq.size(); i++) {
            ret.addFirst(pq.poll());
        }
        return ret;
    }

    public static void main(String[] args) {
        kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }
}
