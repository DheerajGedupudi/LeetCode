/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<TreeNode, TreeNode> parentMap;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.parentMap = new HashMap<>();
        TreeNode curr = root;
        //get to p
        while(curr!=p && curr!=null)
        {
            if (curr.val==p.val)
            {
                break;
            }
            else if (curr.val<p.val)
            {
                this.parentMap.put(curr.right, curr);
                curr = curr.right;
            }
            else 
            {
                this.parentMap.put(curr.left, curr);
                curr = curr.left;
            }
        }
        //2 options
        // left most of the go to the right child subtree
        if (curr.right!=null)
        {
            curr = curr.right;
            TreeNode prev = curr;
            while(curr!=null)
            {
                prev = curr;
                curr = curr.left;
            }
            return prev;
        }
        // no right child, if this left child of parent, then return parent
        TreeNode parent = this.parentMap.get(curr);
        if (parent==null)
        {
            return null;
        }
        while (curr!=null && parent!=null && curr!=parent.left)
        {
            curr = parent;
            parent = this.parentMap.get(parent);
        }
        if (curr!=null)
        {
            return parent;
        }
        return null;
        // return null, if none
    }
}