class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] arr = new int[n];
        int counter = 0;
        int maxCounter = 0;
        for (int i=0; i<n; i++)
        {
            if (seq.charAt(i)=='(')
            {
                counter++;
                arr[i] = counter;
            }
            else
            {
                arr[i] = counter;
                counter--;
            }
            maxCounter = Math.max(maxCounter, counter);
        }
        int halfCounter = maxCounter/2;
        for (int i=0; i<n; i++)
        {
            if (arr[i]>halfCounter)
            {
                arr[i] = 1;
            }
            else
            {
                arr[i] = 0;
            }
        }
        return arr;
    }
}