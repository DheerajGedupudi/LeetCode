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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root==null)
        {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qIndexes = new LinkedList<>();
        q.offer(root);
        qIndexes.offer(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        while(q.isEmpty()==false)
        {
            TreeNode curr = q.poll();
            int index = qIndexes.poll();
            minIndex = Math.min(minIndex, index);
            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(curr.val);
            if (curr.left!=null)
            {
                q.offer(curr.left);
                qIndexes.offer(index-1);
            }
            if (curr.right!=null)
            {
                q.offer(curr.right);
                qIndexes.offer(index+1);
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
}