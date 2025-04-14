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

    private int count;

    public int pathSum(TreeNode root, int targetSum) {
        this.count = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        dfs(root, targetSum, 0L, map);
        return this.count;
    }

    private void dfs(TreeNode root, long targetSum, long sum, Map<Long, Integer> map)
    {
        if (root==null)
        {
            return;
        }
        sum += root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        if (map.containsKey(sum-targetSum))
        {
            int freq = map.get(sum-targetSum);
            if (targetSum==0)
            {
                //to negate the opertaion we did before the dfs.
                freq--;
            }
            count += freq;
        }
        dfs(root.left, targetSum, sum, map);
        dfs(root.right, targetSum, sum, map);
        map.put(sum, map.get(sum)-1);
        if (map.get(sum)==0)
        {
            map.remove(sum);
        }
        sum -= root.val;
    }
}