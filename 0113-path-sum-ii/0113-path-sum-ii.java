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

    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return this.result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path)
    {
        if (root==null)
        {
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        if (root.left==null && root.right==null)
        {
            if (targetSum==0)
            {
                this.result.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);
        targetSum += root.val;
        path.remove(path.size()-1);
    }
}