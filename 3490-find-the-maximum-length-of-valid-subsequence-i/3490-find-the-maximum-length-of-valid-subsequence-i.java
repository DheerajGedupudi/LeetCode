class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        if (n==2)
        {
            return 2;
        }
        int oddCount = 0;
        int evenCount = 0;
        int oddCountOpp = 0;
        int evenCountOpp = 0;
        for (int x : nums)
        {
            if (x%2==0)
            {
                evenCountOpp = oddCountOpp+1;
                evenCount++;
            }
            else
            {
                oddCountOpp = evenCountOpp+1;
                oddCount++;
            }
        }
        //000000
        //111111
        int max1 = Math.max(oddCount, evenCount);
        //0101010101
        int max2 = Math.max(oddCountOpp, evenCountOpp);
        return Math.max(max1, max2);
    }
}

/*

[1,2,3,4]

1,2 = 1
2,3 = 1
3,4 = 1


oeoeoeoeo
ooooooooo
eeeeeeeee


*/