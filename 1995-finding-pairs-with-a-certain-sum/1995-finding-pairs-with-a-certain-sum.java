class FindSumPairs {

    private Map<Integer, Integer> indexMap1;
    private Map<Integer, Integer> indexMap2;
    private Map<Integer, Integer> freqMap1;
    private Map<Integer, Integer> freqMap2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.indexMap1 = new HashMap<>();
        this.indexMap2 = new HashMap<>();
        this.freqMap1 = new HashMap<>();
        this.freqMap2 = new HashMap<>();
        int n = nums1.length;
        int m = nums2.length;
        for (int i=0; i<n; i++)
        {
            indexMap1.put(i, nums1[i]);
            freqMap1.put(nums1[i], freqMap1.getOrDefault(nums1[i], 0)+1);
        }
        for (int i=0; i<m; i++)
        {
            indexMap2.put(i, nums2[i]);
            freqMap2.put(nums2[i], freqMap2.getOrDefault(nums2[i], 0)+1);
        }
    }
    
    public void add(int index, int val) {
        int num = indexMap2.get(index);
        freqMap2.put(num, freqMap2.get(num)-1);
        if (freqMap2.get(num)==0)
        {
            freqMap2.remove(num);
        }
        num += val;
        indexMap2.put(index, num);
        freqMap2.put(num, freqMap2.getOrDefault(num, 0)+1);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int x : freqMap1.keySet())
        {
            int freq1 = freqMap1.get(x);
            int req = tot-x;
            count += (freq1*(freqMap2.getOrDefault(req, 0)));
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */



 /*

//add

map <index, number>


//count

<number, freq> x 2


.
 0  1  2  3  4  5
[1, 1, 2, 2, 2, 3]

[1, 4, 5, 2, 5, 4]


 */