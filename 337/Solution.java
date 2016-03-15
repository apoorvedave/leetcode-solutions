/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Map;
import java.util.HashMap;

public class Solution {
    private HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (map.get(root) != null) {
            return map.get(root);
        }
        if (root.left == null && root.right == null){
            map.put(root, root.val);
            return root.val;
        }
        
        int sumChildren = 0, sumGrandC=0;
        sumChildren += rob(root.left);
        sumChildren += rob(root.right);
        if (root.left != null) {
            sumGrandC += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sumGrandC += rob(root.right.left) + rob(root.right.right);
        }
        map.put(root, Math.max(sumChildren, root.val+sumGrandC));
        return map.get(root);
    }
}
