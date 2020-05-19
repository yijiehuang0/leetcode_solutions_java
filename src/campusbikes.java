import java.util.*;
public class campusbikes {
    class Pair {
        int workeri;
        int bikei;
        int[] bike;
        int[] worker;
        int distance;
        Pair(int wi, int bi, int[]b, int[]w) {
            workeri = wi;
            bikei = bi;
            bike = b;
            worker = w;
            distance = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
        }

    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // so we are going to first compare the manhattan distance worker index, bike index
        PriorityQueue<Pair> q = new PriorityQueue<>((Pair a, Pair b) ->{
            if(a.distance == b.distance) {
                if(a.workeri == b.workeri) {
                    return Integer.compare(a.bikei, b.bikei);
                } else {
                    return Integer.compare(a.workeri, b.workeri);
                }
            } else {
                return Integer.compare(a.distance, b.distance);
            }
        });

        int i = 0;
        int j = 0;
        for(int[] worker : workers) {
            for(int[] bike : bikes) {
                q.add(new Pair(i, j, bike, worker));
                j++; // we are going to increase j everytiime since it is a new bike every time
            }
            j = 0;
            i++;
        }
        HashSet<Integer> bikeseen = new HashSet<>();

        int[] ret = new int[workers.length];
        while(bikeseen.size() < bikes.length) {
            Pair first = q.poll();
            if(bikeseen.contains(first.bikei)) { // each workers is assigned a bike, so if the bike has been seen before then
                continue;
            } else {
                ret[first.workeri] = first.bikei;
                bikeseen.add(first.bikei);
            }
        }

        return ret;

    }

    public static void main(String[] args) {
        campusbikes a = new campusbikes();
        a.assignBikes(new int[][]{{0,0},{2,1}} , new int[][]{{1,2},{3,3}});
    }
}
