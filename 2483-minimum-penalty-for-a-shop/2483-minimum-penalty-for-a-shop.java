class Solution {
    public int bestClosingTime(String customers) {
        int yCount = 0;
        int nCount = 0;
        for (char c : customers.toCharArray())
        {
            if (c=='Y')
            {
                yCount++;
            }
            else
            {
                nCount++;
            }
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;
        int ysLeft = 0;
        int nsLeft = 0;
        int n = customers.length();
        for (int i=0; i<n; i++)
        {
            int ysRight = yCount-ysLeft;
            int nsRight = nCount-nsLeft;
            int penalty = nsLeft+ysRight;
            if (penalty<min)
            {
                min = penalty;
                ans = i;
            }
            if (customers.charAt(i)=='Y')
            {
                ysLeft++;
            }
            else
            {
                nsLeft++;
            }
        }   
        int ysRight = yCount-ysLeft;
        int nsRight = nCount-nsLeft;
        int penalty = nsLeft+ysRight;
        if (penalty<min)
        {
            min = penalty;
            ans = n;
        }
        return ans;
    }
}
/*
 
Y means customer comes in to the shop

N means shop is closed.





*/