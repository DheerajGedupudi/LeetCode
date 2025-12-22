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

    private int max;

    public int longestConsecutive(TreeNode root) {
        this.max = 0;
        int[] res = dfs(root);
        return this.max;
    }

    private int[] dfs(TreeNode root)
    {
        if (root==null)
        {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int asc = 0;
        int des = 0;
        // 0 = asc, 1 = des
        if (root.left!=null)
        {
            if (root.val==root.left.val+1)
            {
                des = left[1]+1;
            }
            else if (root.val==root.left.val-1)
            {
                asc = left[0]+1;
            }
        }
        if (root.right!=null)
        {
            if (root.val==root.right.val+1)
            {
                des = Math.max(des, right[1]+1);
            }
            else if (root.val==root.right.val-1)
            {
                asc = Math.max(asc, right[0]+1);
            }
        }
        int included = asc+des+1;
        this.max = Math.max(this.max, included);
        int[] res = new int[]{asc, des};
        // System.out.println("at : "+root.val+" -> "+Arrays.toString(res));
        return res;
    }
}