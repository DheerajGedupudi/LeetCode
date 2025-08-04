class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>();
        for (int i=0; i<n; i++)
        {
            int num = nums[i];
            int target = 0-num;
            int low = i+1;
            int high = n-1;
            while(low<high)
            {
                int sum = nums[low]+nums[high];
                if (sum==target)
                {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    tripletSet.add(triplet);
                    low++;
                    high--;
                }
                else if (sum>target)
                {
                    high--;
                }
                else
                {
                    low++;
                }
            }
        }
        return new ArrayList<>(tripletSet);
    }
}