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

    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.result = null;
        boolean[] foundPandQ = lca(root, p, q);
        return this.result;
    }

    private boolean[] lca(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root==null)
        {
            return new boolean[]{false, false};
        }
        int pVal = p.val;
        int qVal = q.val;
        int currVal = root.val;
        boolean[] foundLeft = new boolean[]{false, false};
        if (pVal<currVal || qVal<currVal)
        {
            foundLeft = lca(root.left, p, q);
        }
        boolean[] foundRight = new boolean[]{false, false};
        if (pVal>currVal || qVal>currVal)
        {
            foundRight = lca(root.right, p, q);
        }
        boolean foundP = foundLeft[0]||foundRight[0]||root==p;
        boolean foundQ = foundLeft[1]||foundRight[1]||root==q;
        if (foundP&&foundQ)
        {
            if (this.result==null)
            {
                this.result = root;
            }
            else
            {
                return new boolean[]{true, true};
            }
        }
        return new boolean[]{foundP, foundQ};
    }
}