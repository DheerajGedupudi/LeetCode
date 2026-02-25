class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][(1<<n)];
        for (int i=0; i<n; i++)
        {
            q.offer(new int[]{i, (1<<i)}); //vertex, mask
            visited[i][(1<<i)] = true;
        }
        int level = 0;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                int[] curr = q.poll();
                int vertex = curr[0];
                int mask = curr[1];
                if (mask == (1<<n)-1)
                {
                    return level;
                }
                int[] children = graph[vertex];
                for (int child : children)
                {
                    int mask2 = mask | (1<<child);
                    int[] unit = new int[]{child, mask2};
                    if (visited[child][mask2]==false)
                    {
                        q.offer(unit);
                        visited[child][mask2] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}