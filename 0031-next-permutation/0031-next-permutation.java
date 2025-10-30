class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int i=n-1; i>=0; i--)
        {
            if (freqMap.size()>0 && freqMap.lastKey()>nums[i])
            {
                index = i;
                freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
                break;
            }
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }
        if (index==-1)
        {
            //no next perm
            Arrays.sort(nums);
            return;
        }
        int higher = freqMap.higherKey(nums[index]);
        nums[index] = higher;
        freqMap.put(higher, freqMap.get(higher)-1);
        if (freqMap.get(higher)==0)
        {
            freqMap.remove(higher);
        }
        int last = Integer.MIN_VALUE;
        // System.out.println(Arrays.toString(nums));
        // System.out.println(freqMap);
        for (int i=index+1; i<n; i++)
        {
            nums[i] = freqMap.ceilingKey(last);
            last = nums[i];
            freqMap.put(last, freqMap.get(last)-1);
            if (freqMap.get(last)==0)
            {
                freqMap.remove(last);
            }

        }
    }
}


/*

[x,y,z]
.- - - 


[1,5,2,4,3]

[1,5,3,2,4]





*/