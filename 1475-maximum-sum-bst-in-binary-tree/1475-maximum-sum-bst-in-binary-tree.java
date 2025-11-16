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
    public int maxSumBST(TreeNode root) {
        int[] arr = dfs(root);
        return arr[5];
    }

    // int[] => [sum, valid, count, min, max, result]

    private int[] dfs(TreeNode root)
    {
        if (root==null)
        {
            return new int[]{0,1,0,0,0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int valid = 0;
        if (left[1]==1 && right[1]==1)
        {
            //both valid
            int leftMax = left[4];
            int rightMin = right[3];
            if (leftMax<root.val && root.val<rightMin)
            {
                valid = 1;
            }
        }
        int sum = left[0]+right[0]+root.val;
        int count = left[2]+right[2]+1;
        int min = left[3];
        int max = right[4];
        int result = Math.max(left[5], right[5]);
        //leaf
        if (left[2]==0 && right[2]==0)
        {
            valid = 1;
            min = root.val;
            max = root.val;
        }
        //left null, right valid
        if (left[2]==0 && right[1]==1 && root.val < right[3])
        {
            valid = 1;
            min = root.val;
        }
        //left valid, left null
        if (left[1]==1 && left[4]<root.val && right[2]==0)
        {
            valid = 1;
            max = root.val;
        }

        if (valid==1)
        {
            result = Math.max(result, sum);
        }
        // System.out.println("At : "+root.val+",  sum :"+sum+", validity : "+valid+" => "+Arrays.toString(new int[]{sum, valid, count, min, max, result}));
        return new int[]{sum, valid, count, min, max, result};
    }
}