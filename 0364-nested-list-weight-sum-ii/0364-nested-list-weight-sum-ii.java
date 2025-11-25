/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> depths = new ArrayList<>();
        helper(nestedList, 0, nums, depths, 1);
        // System.out.println(nums);
        // System.out.println(depths);
        int maxDepth = 0;
        for (int x : depths)
        {
            maxDepth = Math.max(maxDepth, x);
        }
        int sum = 0;
        int size = nums.size();
        for (int i=0; i<size; i++)
        {
            int val = nums.get(i);
            int weight = maxDepth-depths.get(i)+1;
            sum += (val*weight);
        }
        return sum;
    }

    private void helper(List<NestedInteger> nestedList, int index, List<Integer> nums, List<Integer> depths, int depth)
    {
        int size = nestedList.size();
        if (index==size)
        {
            return;
        }
        if (nestedList.get(index).isInteger())
        {
            nums.add(nestedList.get(index).getInteger());
            depths.add(depth);
        }
        else
        {
            helper(nestedList.get(index).getList(), 0, nums, depths, depth+1); 
        }
        helper(nestedList, index+1, nums, depths, depth);
        
    }
}