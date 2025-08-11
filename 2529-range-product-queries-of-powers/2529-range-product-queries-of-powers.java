class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int)Math.pow(10,9)+7;
        List<Integer> powers = new ArrayList<>();
        int power = 1;
        while(power<n)
        {
            if (power*2>n)
            {
                break;
            }
            power *= 2;
        }
        while(n>0)
        {
            while (power>n)
            {
                power /= 2;
            }
            n -= power;
            powers.add(power);
        }
        // powers.add(0);
        Collections.reverse(powers);
        // int[] prefix = new int[powers.size()];
        // int product = 1;
        // for (int i=1; i<powers.size(); i++)
        // {
        //     product *= powers.get(i);
        //     product %= MOD;
        //     prefix[i] = product;
        // }
        // System.out.println(powers);
        // System.out.println(Arrays.toString(prefix));
        int m = queries.length;
        int[] result = new int[m];
        for (int i=0; i<m; i++)
        {
            long prod = 1;
            for (int j=queries[i][0]; j<=queries[i][1]; j++)
            {
                prod *= powers.get(j);
                prod %= MOD;
            }
            result[i] = (int)prod;
        }
        return result;

    }
}