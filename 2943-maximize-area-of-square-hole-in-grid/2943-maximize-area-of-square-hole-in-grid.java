class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(vBars);
        Arrays.sort(hBars);
        int longestV = 0;
        int last = -1;
        int seq = 1;
        for (int v : vBars)
        {
            if (last+1==v)
            {
                seq++;
            }
            else
            {
                seq = 1;
            }
            longestV = Math.max(longestV, seq);
            last = v;
        }
        int longestH = 0;
        last = -1;
        seq = 1;
        for (int h : hBars)
        {
            if (last+1==h)
            {
                seq++;
            }
            else
            {
                seq = 1;
            }
            longestH = Math.max(longestH, seq);
            last = h;
        }
        int side = Math.min(longestV, longestH)+1;
        return side*side;
    }
}