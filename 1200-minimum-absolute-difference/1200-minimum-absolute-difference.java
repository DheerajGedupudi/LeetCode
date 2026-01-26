class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int last = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        for (int x : arr)
        {
            if (last!=Integer.MIN_VALUE)
            {
                int diff = x-last;
                minDiff = Math.min(minDiff, diff);
            }
            last = x;
        }
        List<List<Integer>> result = new ArrayList<>();
        last = Integer.MIN_VALUE;
        for (int x : arr)
        {
            if (last!=Integer.MIN_VALUE)
            {
                int diff = x-last;
                if (diff==minDiff)
                {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(last);
                    pair.add(x);
                    result.add(pair);
                }
            }
            last = x;
        }
        return result;
    }
}