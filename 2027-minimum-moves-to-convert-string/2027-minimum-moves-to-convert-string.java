class Solution {
    public int minimumMoves(String s) {
        int last = -4;
        int count = 0;
        int n = s.length();
        for (int i=0; i<n; i++)
        {
            if (s.charAt(i)=='X')
            {
                if (last<=i-3)
                {
                    count++;
                    last = i;
                }
            }
        }
        return count;
    }
}