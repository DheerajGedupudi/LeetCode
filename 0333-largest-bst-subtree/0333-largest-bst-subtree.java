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

    private int result;

    public int largestBSTSubtree(TreeNode root) {
        Integer[] arr = dfs(root);
        return this.result;
    }

    private Integer[] dfs(TreeNode root)
    {
        //[min, max, count, isBST]
        if (root==null)
        {
            return new Integer[]{null, null, 0, 1};
        }
        Integer[] fromLeft = dfs(root.left);
        Integer[] fromRight = dfs(root.right);
        int size = fromLeft[2]+fromRight[2]+1;
        boolean isBST = fromLeft[3]==1 && fromRight[3]==1;
        if (fromLeft[2]!=0)
        {
            if (fromLeft[0]==null)
            {
                fromLeft[0] = fromLeft[1];
            }
            if (fromLeft[1]==null)
            {
                fromLeft[1] = fromLeft[0];
            }
        }
        if (fromRight[2]!=0)
        {
            if (fromRight[0]==null)
            {
                fromRight[0] = fromRight[1];
            }
            if (fromRight[1]==null)
            {
                fromRight[1] = fromRight[0];
            }
        }
        // System.out.println(root.val+" left : "+Arrays.toString(fromLeft)+", right : "+Arrays.toString(fromRight));
        if ( (fromLeft[2]==0 || root.val>fromLeft[1]) && (fromRight[2]==0 || root.val<fromRight[0]) )
        {
            if (size>this.result && isBST)
            {
                // System.out.println("The updated answer : "+root.val);
                this.result = size;
            }
        }
        else
        {
            isBST = false;
        }
        int min = root.val;
        int max = root.val;
        fromLeft[0] = (fromLeft[0]==null)?(root.val):fromLeft[0];
        fromLeft[1] = (fromLeft[1]==null)?(root.val):fromLeft[1];
        fromRight[0] = (fromRight[0]==null)?(root.val):fromRight[0];
        fromRight[1] = (fromRight[1]==null)?(root.val):fromRight[1];
        min = Math.min(fromLeft[0], fromRight[0]);
        max = Math.max(fromLeft[1], fromRight[1]);
        return new Integer[]{min, max, size, isBST?1:0};
    }
}