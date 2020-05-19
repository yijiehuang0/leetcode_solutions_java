import java.util.*;
public class threesume {
    public static List<List<Integer>> threeSum(int[] nums) {
//        HashMap<Integer, ArrayList<Integer>> a = new HashMap<>();
//        int len = nums.length;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                ArrayList<Integer> current = new ArrayList<>();
//                current.add(i);
//                current.add(j);
//                int target = 0 - (nums[i] + nums[j]);
//                a.put(target, current);
//                // the idea is that we put the number that we used as well into the
//            }
//        }
//
//        List<List<Integer>> returns = new ArrayList<>();
//
//        for (int i = 0; i < len; i++) {
//            int number = nums[i];
//            if (a.keySet().contains(number) && !a.get(number).contains(i)) {
//                ArrayList<Integer> cur = new ArrayList<>();
//                ;
//                for (int num : a.get(number)) {
//                    cur.add(nums[num]);
//
//                }
//                cur.add(number);
//
//                returns.add(cur);
//            }
//        }


//        return returns;

         // if i had considered how a hasmap would behave in this scenario I would have not used a hashmap, as it was good for knowing if something were possible, but not good for finding solutions with multiples. We would then use a multimap instead
                int len = nums.length;
                Arrays.sort(nums);
                List<List<Integer>> solution = new ArrayList<>();
                for(int i = 0; i< len - 2; i++) {
                    // so what are we attempting to do now? we want to find a target
                    // what would the high in this case be.
                    if(i == 0 || (i>0 && nums[i] != nums[i-1])) { // this ensures that we don't produce a repeat target
                        int target = 0 - nums[i];
                        // now we can see if we can find a solution to this target.
                        int low = i + 1;
                        int high = len - 1;

                        while(low < high) { // low must be less than the high since the numbers can't be the same numbers, and thus so
                            int numLow = nums[low];
                            int numHigh = nums[high];
                            if(numLow + numHigh == target) { // if the solution is equal to the target then we want to ensure that we don't hit the same things again so we skip foreward and also decrease to see if someting else is there that also equals the target.
                                solution.add(Arrays.asList(nums[i], nums[low], nums[high]));
                                while(low < high && nums[low] == nums[low + 1]) {
                                    low++;
                                }
                                while(low < high && nums[high] == nums[high-1]) {
                                    high--;
                                }
                                low++;
                                high--;

                            } else if(nums[low] + nums[high] < target) { // we either need to increase or decrease depdning on the sum thus far
                                low++;
                            } else {
                                high--;
                            }
                        }
                    }

                }
                return solution;
            }



// come up with a target first and then to find a solution that produces this target. That would work,s o instead of trying to find a target that produces the set, we attempt to find a solution to a target.

    public static void main(String[]args) {
        int[] list = new int[] {-1, 0, 1, 2, -1, -4};
        threeSum(list);
    }

}
