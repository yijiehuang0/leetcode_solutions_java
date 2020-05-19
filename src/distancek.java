import java.util.*;
public class distancek {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        Map<TreeNode, TreeNode> parents;
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            parents = new HashMap<>();
            List<Integer> ret = new ArrayList<>();
            if(root == null || target == null) {
                return ret;
            }
            parents.put(root, null);
            findtarget(target, root);
            // we could just dfs to the target and then start our queue from there

            Queue<TreeNode> q = new LinkedList<>();
            q.add(target);
            int count = 0;
            HashSet<TreeNode> seen = new HashSet<>();
            while(!q.isEmpty() && count != K){
                ArrayList<TreeNode> level = new ArrayList<>();

                while(!q.isEmpty()) {
                    TreeNode cur = q.poll();
                    level.add(cur);
                    seen.add(cur);
                }
                for(TreeNode cur : level) {
                    if(parents.containsKey(cur) && parents.get(cur) != null && !seen.contains(parents.get(cur))) {
                        q.add(parents.get(cur));
                    }
                    if(cur.left != null  && !seen.contains(cur.left)) {
                        q.add(cur.left);
                    }
                    if(cur.right != null && !seen.contains(cur.right)) {
                        q.add(cur.right);
                    }
                }
                count +=1;
            }
            while(!q.isEmpty()){
                ret.add(q.poll().val);
            }
            return ret;
        }

        public void findtarget(TreeNode root, TreeNode parent) {
            if(root == null) {
                return;
            }
            if(parent != null && !parents.containsKey(root)) {
                parents.put(root, parent);
            }
            findtarget(root.left, root);
            findtarget(root.right, root);
        }
    }
}
