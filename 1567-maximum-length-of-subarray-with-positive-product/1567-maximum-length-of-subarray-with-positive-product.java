class Solution {

    private int answer;

    public int getMaxLen(int[] nums) {
        this.answer = 0;
        int[] result = maxLenTillHere(nums, nums.length-1);
        return this.answer;
    }

    private int[] maxLenTillHere(int[] nums, int index)
    {
        if (index<0)
        {
            return new int[2];
        }
        int[] prev = maxLenTillHere(nums, index-1);
        int posProdLen = prev[0];
        int negProdLen = prev[1];
        int[] result = new int[2];
        if (nums[index]>0)
        {
            //positive, 
            result[0] = posProdLen+1;
            if (negProdLen>0)
                result[1] = negProdLen+1;
        }
        if (nums[index]<0)
        {
            //negative
            if (negProdLen>0)
                result[0] = negProdLen+1;
            result[1] = posProdLen+1;
        }
        this.answer = Math.max(this.answer, result[0]);
        // System.out.println("till : "+nums[index]+" => "+Arrays.toString(result));
        return result;
    }
}