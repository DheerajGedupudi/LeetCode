class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int x : nums)
        {
            distinct.add(x);
        }
        int count = 0;
        int n = nums.length;
        int p1 = 0;
        int p2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(p2<n)
        {
            int toAdd = nums[p2];
            map.put(toAdd, map.getOrDefault(toAdd, 0)+1);
            //at this point we reached a good subarray.
            while(map.size()==distinct.size())
            {
                count += n-p2;
                int toRemove = nums[p1];
                map.put(toRemove, map.get(toRemove)-1);
                if (map.get(toRemove)==0)
                {
                    map.remove(toRemove);
                }
                p1++;
            }
            //at this point we have no good subarray
            p2++;
        }
        return count;
    }
}