class Solution {

    private int[] memo;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] indegreesMask = new int[n];
        for (int[] edge : relations)
        {
            int prereq = edge[0]-1;
            int forCourse = edge[1]-1;
            indegreesMask[forCourse] |= (1<<prereq);
        }
        this.memo = new int[(1<<n)];
        Arrays.fill(this.memo, -1);
        // System.out.println(adjList);
        return helper(0, indegreesMask, k);
    }

    private int helper(int currMask, int[] prereqMask, int k)
    {
        if (this.memo[currMask]!=-1)
        {
            return this.memo[currMask];
        }
        int n = prereqMask.length;
        if (currMask== (1<<n)-1)
        {
            return 0;
        }
        int availableMask = 0;
        for (int i=0; i<n; i++)
        {
            if (((prereqMask[i] & currMask) == prereqMask[i]) && (currMask & (1<<i))==0)
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
            min = Math.min(min, helper(currMask|s, prereqMask, k)+1);
        }
        this.memo[currMask] = min;
        return min;
    }
}