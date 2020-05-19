import java.util.*;
public class minMaxSubarray {
        public static int segment(int x, List<Integer> arr) {
            List<Integer> smallest = new ArrayList<>();
            Deque<Integer> q = new LinkedList<>();
            for(int i = 0; i < x ; i++) {
                while(!q.isEmpty() && arr.get(i) <= arr.get(q.peekLast())) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            // this is a version of sliding window that just does thing!!!!! why is it that we need a double ended queue tho?
            // we can add things to the end and the beginning and thus this allows for us to do this well

            for(int i = x; i < arr.size(); i++) {
                smallest.add(q.peek());
                while(!q.isEmpty() && q.peek() <= i-x) {
                    q.removeFirst();
                }
                // always has the most recent and thus works as well

                while(!q.isEmpty() && arr.get(i) <= arr.get(q.peekLast())) {
                    q.removeLast();
                }
                q.addLast(i);
            }
            if(smallest.size() == 0) {
                return arr.get(q.removeFirst());
            }

            int maxRet = 0;
            for(int num : smallest) {
                if(arr.get(num) > maxRet) {
                    maxRet = arr.get(num);
                }
            }
            return maxRet;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        segment(3, list);
    }


}
