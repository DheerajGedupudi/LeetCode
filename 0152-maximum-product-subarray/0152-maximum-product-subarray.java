class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int answer = nums[0];
        int posProd = 1;
        int negProd = 1;
        if (nums[0]>0)
        {
            posProd *= nums[0];
            negProd = 0;
        }
        if (nums[0]<0)
        {
            negProd *= nums[0];
            posProd = 0;
        }
        if (nums[0]==0)
        {
            posProd = 0;
            negProd = 0;
        }
        for (int i=1; i<n; i++)
        {
            if (nums[i]>0)
            {
                if (posProd==0)
                {
                    posProd = 1;
                }
                posProd *= nums[i];
                if (Math.abs(negProd)!=0)
                    negProd *= nums[i];
            }
            else if (nums[i]<0)
            {
                int swap = posProd;
                posProd = negProd;
                negProd = swap;
                posProd *= nums[i];
                if (Math.abs(negProd)!=0)
                    negProd *= nums[i];
                else
                    negProd = nums[i];
            }
            else
            {
                posProd = 0;
                negProd = 0;
            }
            posProd = Math.abs(posProd);
            negProd = Math.abs(negProd);
            answer = Math.max(answer, posProd);
            // System.out.println("till : "+nums[i]+", pos: "+posProd+" , neg: "+negProd);
        }
        return answer;
    }
}