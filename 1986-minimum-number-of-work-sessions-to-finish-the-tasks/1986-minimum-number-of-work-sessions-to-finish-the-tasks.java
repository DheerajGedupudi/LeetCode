class Solution {

    private Integer[][] memo;

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        this.memo = new Integer[sessionTime+1][(1<<n)];
        return dfs(tasks, n, sessionTime, 0, 0);
    }

    private int dfs(int[] tasks, int n, int sessionTime, int session, int mask)
    {
        if (mask == (1<<n)-1)
        {
            return 1;
        }
        if (this.memo[session][mask]!=null)
        {
            return this.memo[session][mask];
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++)
        {
            if ((mask&(1<<i))==0)
            {
                //choose
                int mask2 = mask | (1<<i);
                int withTask = session+tasks[i];
                if (withTask<=sessionTime)
                {
                    min = Math.min(min, dfs(tasks, n, sessionTime, withTask, mask2)); 
                }
                else
                {
                    min = Math.min(min, dfs(tasks, n, sessionTime, tasks[i], mask2)+1);
                }
            }
        }
        this.memo[session][mask] = min;
        return min;
    }
}