class Solution {
    public int getMaxLen(int[] nums) {

        int answer = 0;

        int posProdLen = 0;
        int negProdLen = 0;

        int n = nums.length;
        for (int i=0; i<n; i++)
        {
            if (nums[i]>0)
            {
                posProdLen++;
                if (negProdLen>0)
                {
                    negProdLen++;
                }
            }
            else if (nums[i]<0)
            {
                int swap = posProdLen;
                posProdLen = negProdLen;
                negProdLen = swap;
                if (posProdLen>0)
                {
                    posProdLen++;
                }
                negProdLen++;
            }
            else
            {
                posProdLen = 0;
                negProdLen = 0;
            }
            answer = Math.max(answer, posProdLen);
        }
        return answer;
        
    }
}