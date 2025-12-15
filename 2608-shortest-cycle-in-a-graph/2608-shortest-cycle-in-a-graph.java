class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        long min = Integer.MAX_VALUE;
        List<List<Integer>> adjList = getGraph(n, edges);
        for (int[] edge : edges)
        {
            min = Math.min(min, (long)getMinDistNoDirect(adjList, edge[0], edge[1])+1);
        }
        if (min>=Integer.MAX_VALUE)
        {
            return -1;
        }
        return (int)min;
    }

    private int getMinDistNoDirect(List<List<Integer>> adjList, int source, int target)
    {
        int n = adjList.size();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;
        int level = 0;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                int curr = q.poll();
                if (curr==target)
                {
                    return level;
                }
                for (int child : adjList.get(curr))
                {
                    if (curr==source && child==target)
                    {
                        continue;
                    }
                    if (child==source && curr==target)
                    {
                        continue;
                    }
                    if (visited[child]==false)
                    {
                        visited[child] = true;
                        q.offer(child);
                    }
                }
            }
            level++;
        }
        return Integer.MAX_VALUE;
    }

    private List<List<Integer>> getGraph(int n, int[][] edges)
    {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }
}