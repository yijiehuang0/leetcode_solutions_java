import java.util.*;

public class peopleInBoats {
    public static int numRescueBoats(int[] people, int limit) {
        /*
            input int[], limit
            we must ifnd the minimum number of people who will fit this, we can always add the largest person with the smallest person
            and if that is greater then we can keep doing it until we see how many people can be added
            // we can at max include two people in this boat and thus we can do a two pointer search and this shoudl work appropriately.

        */
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        int count = 0;
        while(start < end) {
            int current = 0;
            if(start <= end && people[start] + current <= limit) {
                current = people[start] + current;
                start+=1;
                count++;
            }
            if(start <= end && people[end] + current <= limit) {
                current = people[end] + current;
                end--;
                count++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        numRescueBoats(new int[]{1, 2}, 5);
    }
}
