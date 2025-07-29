/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private LinkedList<Integer> result;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.result = new LinkedList<>();    
        dfs(root, target, k);
        return this.result;
    }

    private void dfs(TreeNode root, double target, int k)
    {
        if (root==null)
        {
            return;
        }
        dfs(root.left, target, k);
        this.result.addLast(root.val);
        if (this.result.size()>k)
        {
            double diff1 = Math.abs(target - this.result.peekFirst());
            double diff2 = Math.abs(target - this.result.peekLast());
            if (diff1<diff2)
            {
                this.result.removeLast();
            }
            else
            {
                this.result.removeFirst();
            }
        }
        dfs(root.right, target, k);
    }
}