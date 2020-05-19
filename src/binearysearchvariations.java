public class binearysearchvariations {
    public static int binarysearch(int[] list, int target) {
        int left = 0;
        int right = list.length -1;
        while(left <= right) { // this ensures at the left and the right can be at the same location and performs one last check to be sure this is pretty helpful otherwise
            int mid = left + (right - left)/2;
            if(list[mid] == target) {
                return mid;
            } else if(list[mid] > target) {
                 right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // we want to search for things that are less than or equal to this value
    public static void main(String[] args) {
        binarysearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9 , 20}, 1);
    }
}
