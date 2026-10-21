class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int[] arr = new int[n];
        int min = 120;
        int max = -1;
        for (int i=0; i<n; i++)
        {
            arr[i] = s.charAt(i)-'a';
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        boolean alreadySorted = sortedCheck(arr);
        if (alreadySorted)
        {
            return 0;
        }
        if (n==2 && alreadySorted==false)
        {
            return -1;
        }
        //check first and last
        boolean firstSorted = arr[0]==min;
        boolean lastSorted = arr[n-1]==max;
        if (firstSorted||lastSorted)
        {
            return 1;
        }
        // 2 , sort first->last or last->first
        int[] arr2 = Arrays.copyOf(arr, n); // check 2nd option
        Arrays.sort(arr, 0, n-1);
        Arrays.sort(arr, 1, n);
        if (sortedCheck(arr))
        {
            return 2;
        }
        Arrays.sort(arr2, 1, n);
        Arrays.sort(arr2, 0, n-1);
        if (sortedCheck(arr2))
        {
            return 2;
        }
        return 3;
    }

    private boolean sortedCheck(int[] arr)
    {
        int last = -1;
        for (int x : arr)
        {
            if (x<last)
            {
                return false;
            }
            last = x;
        }
        return true;
    }
}