import jdk.dynalink.Operation;

import java.util.*;
public class lambdas {
    interface IntegerMath {
        int operation(int a, int b);
    }
    public static void main(String[] args) {
        String[] list = new String[] {"lau", "love"};
        int[] list1 = new int[]{ 1, 2, 3};
        IntegerMath subtraction = (a, b) -> a - b;

        Arrays.sort(list, (String p1, String p2) -> p2.compareTo(p1));
        PriorityQueue<String> q = new PriorityQueue<>(
                (String a, String b) -> b.compareTo(a));
        for(String s: list) {
            q.add(s);
            System.out.println(s);
        }
        System.out.println(q.poll());
        System.out.println(q.poll());

    }
}
