import java.util.*;
public class InAndPreOrderRemake {
//    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//
//
//    }

//    public static TreeNode shell(List<Integer> preorder, List<Integer> inorder) {
//        if(inorder.size() == 0) {
//            return null;
//        }
//        if(inorder.size() == 1) {
//            int val = preorder.get(0);
//            preorder= Arrays.copyOfRange(preorder, 1, preorder.size());      // so how can we slice this arraylist now
//
//            return new TreeNode(val);
//        }
//        int first = preorder.get(0);
//
//        TreeNode root = new TreeNode(preorder[0]);
//        int len = preorder.length;
//        int[] another = Arrays.copyOfRange(preorder, 1, len);
//
//        List<Integer> leftIn  = findLeft(inorder, first);
//        List<Integer> rightIn = findRight(inorder, first);
//        int[] left = convert(leftIn);
//        int[] right = convert(rightIn);
//
//
//        root.left = buildTree(another, left);
//        root.right = buildTree(another, right);
//
//        return root;
//    }




    public static List<Integer> findLeft(int[] inorder, int value) {
        List<Integer> ret = new ArrayList<>();

        for(int i: inorder) {
            if(i == value) {
                break;
            }
            ret.add(i);
        }
        return ret;
    }
    public static  List<Integer> findRight(int[] inorder, int value) {
        List<Integer> ret = new ArrayList<>();
        boolean found = false;
        for(int i: inorder) {
            if(i == value) {
                found = true;
                continue;
            }
            if(found) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static int[] convert(List<Integer> a) {
        int[] ret = new int[a.size()];
        int count = 0;
        for(int i: a) {
            ret[count++] = i;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] pre = new int[] {3,9,20,15,7};
//        int[] in = new int[] {9,3,15,20,7};
//        buildTree(pre, in);
    }
}
