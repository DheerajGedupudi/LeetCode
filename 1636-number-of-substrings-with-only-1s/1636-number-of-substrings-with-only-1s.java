class Solution {
    public int numSub(String s) {
        int n = s.length();
        long count = 0;
        long result = 0;
        long MOD = (long)Math.pow(10, 9)+7;
        for (char c : s.toCharArray())
        {
            if (c=='1')
            {
                count++;
            }
            else
            {
                result += (count*(count+1)/2);
                count = 0;
            }
            result %= MOD;
        }
        
        result += (count*(count+1)/2);
        result %= MOD;
        return (int)result;
    }
}


/*


n = 4

----


*/