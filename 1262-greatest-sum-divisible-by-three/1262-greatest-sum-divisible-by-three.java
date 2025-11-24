class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();
        for (int x : nums)
        {
            if (x%3==1)
            {
                ones.add(x);
            }
            else if (x%3==2)
            {
                twos.add(x);
            }
            sum += x;
        }
        Collections.sort(ones);
        Collections.sort(twos);
        if (sum%3==0)
        {
            return sum;
        }
        if (sum%3==1)
        {
            int max = -1;
            if (ones.size()==0 && twos.size()==0)
            {
                return 0;
            }
            if (ones.size()==0)
            {
                //only twos left
                if (twos.size()<2)
                {
                    return 0;
                }
                int two1 = twos.get(0);
                int two2 = twos.get(1);
                return sum-(two1+two2);
            }
            if (twos.size()==0)
            {
                return sum-ones.get(0);
            }
            //both available
            //with ones
            max = Math.max(max, sum-ones.get(0));
            //with twos
            if (twos.size()>1)
            {
                int two1 = twos.get(0);
                int two2 = twos.get(1);
                max = Math.max(max, sum-(two1+two2));
            }
            return max;
        }
        if (sum%3==2)
        {
            int max = -1;
            if (ones.size()==0 && twos.size()==0)
            {
                return 0;
            }
            if (twos.size()==0)
            {
                //only ones left
                if (ones.size()<2)
                {
                    return 0;
                }
                int two1 = ones.get(0);
                int two2 = ones.get(1);
                return sum-(two1+two2);
            }
            if (ones.size()==0)
            {
                return sum-twos.get(0);
            }
            //both available
            //with ones
            max = Math.max(max, sum-twos.get(0));
            //with twos
            if (ones.size()>1)
            {
                int two1 = ones.get(0);
                int two2 = ones.get(1);
                max = Math.max(max, sum-(two1+two2));
            }
            return max;
        }
        return -1;
        
    }
}

/*


. 3,6,5,1,8
3 3 6 5 1 8
6  
5
1
8



1,3,5,6,8

sum = 0 1 2

1
5 8
3 6



8,6,5,3,1
8 14 19 22 23






*/