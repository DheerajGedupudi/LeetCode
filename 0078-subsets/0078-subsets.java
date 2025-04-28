class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<>();  
        backtrack(nums, 0, new ArrayList<>());
        return this.result;  
    }

    private void backtrack(int[] nums, int index, List<Integer> path)
    {
        int n = nums.length;
        if (index==n)
        {
            this.result.add(new ArrayList<>(path));
            return;
        }
        //don't choose
        backtrack(nums, index+1, path);
        //choose
        path.add(nums[index]);
        backtrack(nums, index+1, path);
        path.remove(path.size()-1);
    }
}