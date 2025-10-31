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

    private List<Integer> result;
    private Set<TreeNode> visited;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        this.result = new ArrayList<>();
        this.visited = new HashSet<>();
        //get left boundary
        //get all leaves left to right
        //get right boundary in reverse    
        if (root==null)
        {
            return this.result;
        }
        this.result.add(root.val);
        if (root.left==null && root.right==null)
        {
            return this.result;
        }
        if (root.left!=null)
        {
            getLeft(root.left);
        }
        getLeaves(root);
        if (root.right!=null)
        {
            getRight(root.right);
        }
        return this.result;
    }

    private void getLeft(TreeNode root)
    {
        //make sure it is not leaf
        if (root.left==null && root.right==null)
        {}
        else if (this.visited.contains(root)==false)
        {
            this.result.add(root.val);
            this.visited.add(root);
        }
        if (root.left!=null)
        {
            getLeft(root.left);
        }
        else if (root.right!=null)
        {
            getLeft(root.right);
        }
    }

    private void getLeaves(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        getLeaves(root.left);
        if (root.left==null && root.right==null && this.visited.contains(root)==false)
        {
            this.result.add(root.val);
            this.visited.add(root);
        }
        getLeaves(root.right);
    }

    private void getRight(TreeNode root)
    {
        if (root.right!=null)
        {
            getRight(root.right);
        }
        else if(root.left!=null)
        {
            getRight(root.left);
        }
        if (root.left==null && root.right==null)
        {}
        else if (this.visited.contains(root)==false)
        {
            this.result.add(root.val);
            this.visited.add(root);
        }
    }
}