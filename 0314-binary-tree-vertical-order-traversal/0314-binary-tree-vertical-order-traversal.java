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

    private Map<TreeNode, Integer> nodeToIndex;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root==null)
        {
            return new ArrayList<>();
        }
        this.nodeToIndex = new HashMap<>();
        dfs(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        while(q.isEmpty()==false)
        {
            TreeNode curr = q.poll();
            int index = this.nodeToIndex.get(curr);
            minIndex = Math.min(minIndex, index);
            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(curr.val);
            if (curr.left!=null)
            {
                q.offer(curr.left);
            }
            if (curr.right!=null)
            {
                q.offer(curr.right);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        int index = minIndex;
        while(map.containsKey(index))
        {
            result.add(map.get(index++));
        }
        return result;
    }

    private void dfs(TreeNode root, int index)
    {
        if (root==null)
        {
            return;
        }
        this.nodeToIndex.put(root, index);
        dfs(root.left, index-1);
        dfs(root.right, index+1);
    }
}