class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int n = nums.length;
        int number = 5;
        for (int x : nums)
        {
            number <<= 1;
            if (x==1)
            {
                number |= 1;
            }
            number %= 5;
            if (number%5==0)
            {
                result.add(true);
            }
            else
            {
                result.add(false);
            }
        }
        return result;
    }
}

/*

MOD = 50


11

3

111 = 7


101

8421
1101


110


6



*/