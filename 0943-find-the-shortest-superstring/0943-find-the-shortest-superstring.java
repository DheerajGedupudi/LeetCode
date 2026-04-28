class Solution {

    private Integer[][] memo;
    private int[][] chosen;
    private Integer[][] overlap;
    private int INF;

    public String shortestSuperstring(String[] words) {
        int n = words.length;
        this.memo = new Integer[(1<<n)][n];
        Arrays.fill(this.memo[(1<<n)-1], 0);
        this.chosen = new int[(1<<n)][n];
        this.overlap = new Integer[n][n];
        this.INF = (int)Math.pow(10,8);
        int lastIndex = 0;
        int min = this.INF;
        for (int i=0; i<n; i++)
        {
            int totalLen = helper(words, (1<<i), i) + words[i].length();
            if (totalLen < min)
            {
                min = totalLen;
                lastIndex = i;
            }
        }
        // System.out.println(min);
        StringBuilder sb = new StringBuilder();
        sb.append(words[lastIndex]);
        int mask = (1<<lastIndex);
        int fullMask = (1<<n)-1;
        while(mask != fullMask)
        {
            int index = this.chosen[mask][lastIndex];
            int overlapLen = getMaxOverlap(words, lastIndex, index);
            sb.append(words[index].substring(overlapLen));
            mask |= (1<<index);
            lastIndex = index;
        }
        return sb.toString();
    }

    private int helper(String[] words, int currMask, int lastIndex)
    {
        if (this.memo[currMask][lastIndex]!=null)
        {
            return this.memo[currMask][lastIndex];
        }
        int n = words.length;
        if (currMask==(1<<n)-1)
        {
            return 0;
        }
        int min = this.INF;
        String lastW = words[lastIndex];
        for (int i=0; i<n; i++)
        {
            String currW = words[i];
            if ((currMask & (1<<i))==0)
            {
                int union = currMask | (1<<i);
                int additionalSpace = currW.length()-(getMaxOverlap(words, lastIndex, i));
                int cost = additionalSpace + helper(words, union, i);
                if (cost < min)
                {
                    this.chosen[currMask][lastIndex] = i;
                    min = cost;
                }
            }
        }
        this.memo[currMask][lastIndex] = min;
        return min;
    }

    private int getMaxOverlap(String[] words, int lastIndex, int currIndex)
    {
        if (this.overlap[lastIndex][currIndex]!=null)
        {
            return this.overlap[lastIndex][currIndex];
        }
        String prev = words[lastIndex];
        String curr = words[currIndex];
        int n = prev.length();
        int m = curr.length();
        int max = 0;
        int start = Math.max(0, (n-m));
        for (int i=start; i<n; i++)
        {
            int saved = getOverlapIndexes(prev, curr, i, 0);
            max = Math.max(max, saved);
        }
        // System.out.println(prev+" - "+curr+" saved : "+max);
        this.overlap[lastIndex][currIndex] = max;
        return max;
    }

    private int getOverlapIndexes(String s, String t, int i, int j)
    {
        int n = s.length();
        int m = t.length();
        int count = 0;
        while(i<n && j<m)
        {
            if (s.charAt(i)!=t.charAt(j))
            {
                return 0;
            }
            i++;
            j++;
            count++;
        }
        return count;
    }
}