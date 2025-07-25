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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return build(new TreeNode(-1), preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode build(TreeNode root, int[] preorder, int[] inorder, int pre1, int pre2, int in1, int in2)
    {
        if (pre1>pre2 || in1>in2)
        {
            return null;
        }
        int rootVal = preorder[pre1];
        int i = in1;
        for (i=in1; i<=in2; i++)
        {
            if (inorder[i]==rootVal)
            {
                break;
            }
        }
        int leftLen = i-in1;
        int rightLen = in2-i;
        // System.out.println(rootVal+"  => "+leftLen+" "+rightLen);
        root = new TreeNode(rootVal);
        root.left = build(root.left, preorder, inorder, pre1+1, pre1+1+leftLen, in1, i-1);
        root.right = build(root.right, preorder, inorder, pre1+leftLen+1, pre1+leftLen+1+rightLen, i+1, in2);
        return root;

    }
}