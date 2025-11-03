class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int x : nums)
        {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int offSet = k;
        int range = max+(2*k)+1;
        int ans = 0;
        int[] count = new int[range];
        for (int x : nums)
        {
            count[x+offSet]++;
        }
        // System.out.println(Arrays.toString(count));
        int[] prefix = new int[range+1];
        int sum = 0;
        for (int i=0; i<range; i++)
        {
            sum += count[i];
            prefix[i+1] = sum;
        }
        // System.out.println(Arrays.toString(prefix));
        for (int i=min; i<=max; i++)
        {
            //get How many can become this num
            int left = Math.max(i-k, 0);
            int right = Math.min(i+k, range);
            // System.out.println("for : "+i+" space : "+(left)+"->"+(right));
            int counter = prefix[right+offSet+1]-prefix[left+offSet];
            int sameCounter = 0;
            int toMakeSame = 0;
            if (i+offSet<range)
            {
                sameCounter = count[i+offSet];
                counter -= sameCounter;
                toMakeSame = sameCounter;
            }
            toMakeSame += Math.min(numOperations, counter);
            // System.out.println("to make same : "+toMakeSame);
            ans = Math.max(ans, toMakeSame);
        }
        return ans;
    }
}


/*


[1,4,5]
k = 1
m = 2
for each i take i-k -> i+k

0 -> 2

target 0 -> 6



5 11 20
1  1 2





*/