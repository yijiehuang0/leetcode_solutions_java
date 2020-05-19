import java.util.*;
public class reconstructIternary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> ret = new ArrayList<>();
        if(tickets.size() == 0) {
            return ret;
        }
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> edge : tickets) {
            if(!map.containsKey(edge.get(0))) {
                map.put(edge.get(0), new PriorityQueue<String>((String p1, String p2) -> p2.compareTo(p1)));
            }
            map.get(edge.get(0)).add(edge.get(1));
        }
        Stack<String> stack = new Stack<>();
        stack.add("JFK");
        int seen = 0;
        int end = map.size();
        while(!stack.isEmpty() || seen != map.size()) {
            String loc = stack.pop();
            ret.add(loc);
            seen++;
            PriorityQueue<String> pq = map.get(loc);
            while(pq.size() != 0) {
                String next = pq.poll();
                stack.add(next);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<String>> params = new ArrayList<>();
        String[] parm1 = new String[]{"JFK", "SFO"};
        String[] parm2 = new String[]{"JFK", "ATL"};
        String[] parm3 = new String[]{"SFO", "ATL"};
        String[] parm4 = new String[]{"ATL", "JFK"};
        String[] parm5 = new String[]{"ATL", "SFO"};
        params.add(Arrays.asList(parm1));
        params.add(Arrays.asList(parm2));
        params.add(Arrays.asList(parm3));
        params.add(Arrays.asList(parm4));
        params.add(Arrays.asList(parm5));
        findItinerary(params);
    }
}
