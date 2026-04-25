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

    private Map<Integer, List<TreeNode>> treeList;

    public List<TreeNode> generateTrees(int n) {
        this.treeList = new HashMap<>();
        return getWays(n);
    }

    private List<TreeNode> getWays(int n)
    {
        if (this.treeList.containsKey(n))
        {
            return this.treeList.get(n);
        }
        List<TreeNode> result = new ArrayList<>();
        if (n==0)
        {
            result.add(null);
        }
        else if (n==1)
        {
            result.add(new TreeNode(1));
        }
        else
        {
            for (int i=1; i<=n; i++)
            {
                List<TreeNode> left = getWays(i-1);
                List<TreeNode> right = getWays(n-i);
                List<TreeNode> joined = join(i, left, right);
                result.addAll(joined);
            }
        }
        this.treeList.put(n, result);
        return result;
    }

    private List<TreeNode> join(int rootVal, List<TreeNode> left, List<TreeNode> right)
    {
        List<TreeNode> result = new ArrayList<>();
        for (TreeNode leftChild : left)
        {
            for (TreeNode rightChild : right)
            {
                TreeNode leftClone = clone(leftChild, 0);
                TreeNode rightClone = clone(rightChild, rootVal);
                TreeNode root = new TreeNode(rootVal);
                root.left = leftClone;
                root.right = rightClone;
                result.add(root);
            }
        }
        return result;
    }

    private TreeNode clone(TreeNode root, int offset)
    {
        if (root==null)
        {
            return null;
        }
        Queue<TreeNode> orig = new LinkedList<>();
        Queue<TreeNode> dup = new LinkedList<>();
        TreeNode cloned = new TreeNode(root.val+offset);
        orig.offer(root);
        dup.offer(cloned);
        while(!orig.isEmpty())
        {
            TreeNode curr1 = orig.poll();
            TreeNode curr2 = dup.poll();
            if (curr1.left!=null)
            {
                orig.offer(curr1.left);
                curr2.left = new TreeNode(curr1.left.val+offset);
                dup.offer(curr2.left);
            }
            if (curr1.right!=null)
            {
                orig.offer(curr1.right);
                curr2.right = new TreeNode(curr1.right.val+offset);
                dup.offer(curr2.right);
            }
        }
        return cloned;
    }
}