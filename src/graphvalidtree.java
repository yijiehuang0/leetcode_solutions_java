import java.util.*;
public class graphvalidtree {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n -1) {
            return false;
        }
        if(edges.length == 1 || edges.length == 0) {
            return true;
        }
        Set<Integer> seen = new HashSet<>();
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(null);
        }

        // so we are moving from and to certain edges
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if(graph.get(from) == null) {
                graph.set(from, new HashSet<Integer>());
            }
            if(graph.get(to) == null) {
                graph.set(to, new HashSet<Integer>());
            }
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Stack<Integer> dfs = new Stack<>();
        dfs.push(0);
        // now how do we determine where to start, if its s connected then it doesn't matter where we start since it is an undirected graph

        while(!dfs.isEmpty()) {
            int current = dfs.pop();
            if(graph.get(current) != null) {
                for(int i: graph.get(current)) {
                    if(!seen.contains(i)) {
                        dfs.push(i);
                        seen.add(i);
                    }

                }
            }

        }



        return seen.size() == n ? true : false;

        // i think that i am just struggling with the idea of how to do dfs on this set, the idea is to iterate a dfs and then check that the set size is going to be n-1, and then we can return either true or false


        // an easy way to check for this is to have a disjoint set and then we can check if everything is connected
    }
}
