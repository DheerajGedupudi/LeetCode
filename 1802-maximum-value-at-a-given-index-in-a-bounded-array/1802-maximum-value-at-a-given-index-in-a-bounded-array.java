class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1;
        int high = maxSum;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (possible(n, index, maxSum, mid))
            {
                best = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return best;
    }

    private boolean possible(int n, int index, long maxSum, int number)
    {
        int leftLength = index;
        int rightLength = n-1-index;
        int toCount = number-1;
        long lSum = 0;
        long rSum = 0;
        if (leftLength>0)
        {
            //opt 1 length is more
            if (leftLength>=toCount)
            {
                //count full sum
                lSum += sumN(toCount);
                lSum += (leftLength-toCount);
            }
            //opt 2 length is less, sum will be less
            if (leftLength<toCount)
            {
                int offSet = toCount-leftLength;
                lSum += sumN(toCount) - sumN(offSet);
            }
        }
        if (rightLength>0)
        {
            //opt 1 length is more
            if (rightLength>=toCount)
            {
                //count full sum
                rSum += sumN(toCount);
                rSum += (rightLength-toCount);
            }
            //opt 2 length is less, sum will be less
            if (rightLength<toCount)
            {
                int offSet = toCount-rightLength;
                rSum += sumN(toCount) - sumN(offSet);
            }
        }
        long sum = lSum+rSum+number;
        // System.out.println("n : "+n+" , i : "+index+" , number : "+number+" , lSum : "+lSum+", rSum : "+rSum+" -> sum : "+sum);
        return sum<=maxSum;
    }

    private long sumN(long n)
    {
        return (n*(n+1))/2;
    }
}

/*

max = 10

half = 5

------
332100


666665 = 36

012345
2321--



*/