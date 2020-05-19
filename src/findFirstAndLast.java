public class findFirstAndLast {
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1,-1};
        }
        int index = 0;
        int left = 0;
        int right = nums.length -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int mide = nums[mid];
            int lefte = nums[left];
            int righte = nums[right];
            if(mide == target) {
                index = mid;
                break;
            }
            if(target > mide) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        if(nums[index] != target) {
            return new int[]{-1,-1};
        }

        left = index;
        right = index;
        while(left >= 0 && right <= nums.length-1) {
            if(left -1 >= 0 && nums[left -1] == target) {
                left-=1;
                continue;
            }
            if(right +1 <= nums.length-1 && nums[right +1] == target) {
                right+=1;
                continue;
            }
            break;
        }

        return new int[]{left, right};

    }

    public static void main(String[] args) {
        searchRange(new int[]{1, 4}, 4);
    }
}
