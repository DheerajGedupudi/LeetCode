class Solution {

    private int[] memo;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] indegrees = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : relations)
        {
            indegrees[edge[0]-1]++;
            adjList.get(edge[1]-1).add(edge[0]-1);
        }
        this.memo = new int[(1<<n)];
        Arrays.fill(this.memo, -1);
        // System.out.println(adjList);
        return helper(adjList, 0, indegrees, k);
    }

    private int helper(List<List<Integer>> adjList, int currMask, int[] degrees, int k)
    {
        if (this.memo[currMask]!=-1)
        {
            return this.memo[currMask];
        }
        int n = degrees.length;
        if (currMask== (1<<n)-1)
        {
            return 0;
        }
        int availableMask = 0;
        for (int i=0; i<n; i++)
        {
            if (degrees[i]==0 && (currMask&(1<<i)) ==0)
            {
                availableMask |= (1<<i);
            }
        }
        int min = 10_000_000;
        int max_count = 0; // max courses possible in this semester
        for (int s = availableMask; s>0; s = (s-1) & availableMask)
        {
            int count = Integer.bitCount(s);
            if (count>k)
            {
                continue;
            }
            max_count = Math.max(max_count, count);
            if (count < max_count)
            {
                continue; // taking less courses than max possible is not worth it
            }
            for (int pos=0; pos<n; pos++)
            {
                if ((s & (1<<pos))!=0)
                {
                    currMask |= (1<<pos);
                    List<Integer> connected = adjList.get(pos);
                    for (int j : connected)
                    {
                        degrees[j]--;
                    }
                }
            }
            int result = helper(adjList, currMask, degrees, k);
            for (int pos=0; pos<n; pos++)
            {
                if ((s & (1<<pos))!=0)
                {
                    currMask &= ~(1<<pos);
                    List<Integer> connected = adjList.get(pos);
                    for (int j : connected)
                    {
                        degrees[j]++;
                    }
                }
            }
            min = Math.min(min, result+1);
        }
        this.memo[currMask] = min;
        return min;
    }
}