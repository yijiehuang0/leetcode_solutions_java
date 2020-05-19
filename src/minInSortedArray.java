public class minInSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left < right) {
            int mid = left + (right - left)/2;
            int midval = nums[mid];
            int rightval = nums[right];
            if(midval < rightval) {
                right = mid;
            } else {
                left = mid + 1; // otherwise we search right +1
            }
            // there are only certain combinations.. for 1 2 3 4 5
            // 1 2  3  4 5
            // 5 1  2  3 4
            // 4 5  1  2 3
            // 3 4  5  1 2
            // 2 3  4  5 1      // where is the mid with respect to these values

            // a clear thing here is that if midval < right val, then search left, otherwise search mid + 1.. this is a clear pattern here

        }
        return left;
    }


    public static int search(int[] nums, int target) {
        // there is a certian pattern assocaited with this
        // start with binary search as the obvious candidate
        int left = 0;
        int right = nums.length -1;
        while(left < right) {

            int mid = left + (right - left)/2;

            int midval = nums[mid];
            int rightval = nums[right];
            int leftval = nums[left];
            if(midval == target) {
                return mid;
            }

            // find out which is sorted, and then determin based off of that
            if(midval < rightval) { // right sorted
                if(target > midval && target <= rightval) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else { // left sorted
                if(target > leftval) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        //[4,5,6,7,8,1,2,3]
        //8
        findMin(new int[]{3,4,5,1,2});
        search(new int[]{ 4,5,6,7,8,1,2,3}, 8);
    }
}
