class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int n = nums1.length;
        for (int i=0; i<n; i++)
        {
            int diff = Math.abs(nums1[i]-nums2[i]);
            map.put(diff, map.getOrDefault(diff, 0)+1);
        }
        int k = k1+k2;
        // System.out.println(map);
        while(k>0)
        {
            int max = map.firstKey();
            if (max==0)
            {
                return 0;
            }
            int freq = map.get(max);
            if (k>=freq)
            {
                //add all max-1
                map.remove(max);
                map.put(max-1, map.getOrDefault(max-1, 0)+freq);
                k -= freq;
                continue;
            }
            //last iteration, freq > k
            int updatedFreq = freq - k;
            map.put(max, updatedFreq);
            map.put(max-1, map.getOrDefault(max-1, 0)+k);
            k = 0;
        }
        // System.out.println(map);
        //calc
        long sum = 0;
        for (int key : map.keySet())
        {
            int freq = map.get(key);
            long number = key;
            long squaredSum = number * number * freq;
            sum += squaredSum;
        }
        return sum;
    }
}


/*



[1,8,17,15]

289

[4, 4, 4, 3] 2

4,3,3,3

16+ 9+9+9


*/