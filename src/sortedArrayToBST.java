public class sortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        TreeNode root = f(nums, 0, nums.length);
        return root;
    }
    public static TreeNode f(int[] nums, int start, int end) {
        if(start == end || start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[start + (end - start)/2]);
        TreeNode right = f(nums, mid +1, end);
        TreeNode left = f(nums, 0, mid);
        root.right = right;
        root.left = left;
        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
