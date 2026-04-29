class Solution {

    private Boolean[] memo;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        this.memo = new Boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            if (edge[0] == destination)
            {
                return false;
            }
        }
        boolean[] visited = new boolean[n];
        visited[source] = true;
        return helper(adjList, source, destination, visited);
    }

    private boolean helper(List<List<Integer>> adjList, int source, int destination, boolean[] visited)
    {
        if (this.memo[source]!=null)
        {
            return this.memo[source];
        }
        if (source == destination)
        {
            this.memo[source] = true;
            return true;
        }
        if (adjList.get(source).size()==0)
        {
            this.memo[source] = false;
            return false;
        }
        for (int child : adjList.get(source))
        {
            if (visited[child]==false)
            {
                visited[child] = true;
                if (helper(adjList, child, destination, visited)==false)
                {
                    // from child too, not possible
                    this.memo[source] = false;
                    return false;
                }
                visited[child] = false;
            }
            else
            {
                // cycle found
                this.memo[source] = false;
                return false;
            }
        }
        // from this vertex, we can reach destination
        this.memo[source] = true;
        return true;
    }
}