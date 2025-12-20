class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        List<Set<Integer>> adjList = getAdjList(n, corridors);
        int cycles = 0;
        for (int u=0; u<=n; u++)
        {
            List<Integer> children = new ArrayList<>(adjList.get(u));
            for (int i=0; i<children.size(); i++)
            {
                int v = children.get(i);
                //explore all cycles using u-v
                //lets get all k like u-v-k-u
                for (int k : adjList.get(v))
                {
                    if (adjList.get(u).contains(k))
                    {
                        cycles++;
                    }
                }
                dropEdge(adjList, u, v);
            }
            // System.out.println(adjList);
        } 
        return cycles;
    }

    private void dropEdge(List<Set<Integer>> adjList, int u, int v)
    {
        adjList.get(u).remove(v);
        adjList.get(v).remove(u);
    }

    private void drop(List<Set<Integer>> adjList, int v)
    {
        List<Integer> children = new ArrayList<>(adjList.get(v));
        for (int child : children)
        {
            adjList.get(child).remove(v);
        }
        adjList.get(v).clear();
    }

    private List<Set<Integer>> getAdjList(int n, int[][] edges)
    {
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<=n; i++)
        {
            adjList.add(new HashSet<>());
        }
        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    } 
}