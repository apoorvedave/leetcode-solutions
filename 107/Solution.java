/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Queue;
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root==null){
            return result;
        }
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        // base
        q1.add(root);
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        result.add(l);
        
        //create alternatively lists using queues and add to result
        while(!q1.isEmpty() || !q2.isEmpty()){
            Queue<TreeNode> full = (q1.isEmpty())? q2:q1;
            Queue<TreeNode> empty = (q1.isEmpty())? q1:q2;
            List<Integer> l2 = new ArrayList<>();
            while(!full.isEmpty()){
                // transfer kids of full to empty,
                // add kids to l2
                TreeNode p = full.poll();
                if (p.left!=null) {
                    l2.add(p.left.val);
                    empty.add(p.left);
                }
                if (p.right!=null) {
                    l2.add(p.right.val);
                    empty.add(p.right);
                }
            }
            if (!l2.isEmpty()){
                result.add(l2);
            }
        }
        // reverse result list;
        int n = result.size();
        List<List<Integer>> result2=new ArrayList<>();
        for (int i = 0; i<n; i++){
            result2.add(result.get(n-1-i));
        }
        
        return result2;
    }
}
