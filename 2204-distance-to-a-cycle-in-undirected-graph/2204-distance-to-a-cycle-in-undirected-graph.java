class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        int u = -1;
        int v = -1;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges)
        {
            if (uf.connected(edge[0], edge[1]))
            {
                u = edge[0];
                v = edge[1];
                break;
            }
            uf.union(edge[0], edge[1]);
        }
        List<List<Integer>> adjList = getAdjListWithout(n, edges, u, v);
        List<Integer> path = new ArrayList<>();
        path.add(u);
        List<Integer> list = dfs(adjList, v, path, new boolean[n], u);
        // System.out.println(adjList); 
        // System.out.println(list); 
        int[] result = new int[n];
        //bfs
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int x : list)
        {
            q.offer(x);
            visited[x] = true;
        }
        int level = 0;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                int curr = q.poll();
                result[curr] = level;
                for (int child : adjList.get(curr))
                {
                    if (visited[child]==false)
                    {
                        visited[child] = true;
                        q.offer(child);
                    }
                }
            }
            level++;
        }
        return result;
    }

    private List<List<Integer>> getAdjListWithout(int n, int[][] edges, int x, int y)
    {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges)
        {
            if (edge[0]==x && edge[1]==y)
            {
                continue;
            }
            if (edge[1]==x && edge[0]==y)
            {
                continue;
            }
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    private List<Integer> dfs(List<List<Integer>> adjList, int vertex, List<Integer> path, boolean[] visited, int root)
    {
        if (vertex==root)
        {
            return new ArrayList<>(path);
        }
        path.add(vertex);
        visited[vertex] = true;
        for (int child : adjList.get(vertex))
        {
            if (visited[child]==false)
            {
                List<Integer> cycle = dfs(adjList, child, path, visited, root);
                if (cycle!=null)
                {
                    return cycle;
                }
            }
        }
        visited[vertex] = false;
        path.remove(path.size()-1);
        return null;
    }
}

class UnionFind
{
    private int[] parent;
    private int[] size;

    UnionFind(int n)
    {
        this.parent = new int[n];
        for (int i=0; i<n; i++)
        {
            this.parent[i] = i;
        }
        this.size = new int[n];
        Arrays.fill(this.size, 1);
    }

    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX==rootY)
        {
            return;
        }
        else
        {
            if (this.size[rootX]>this.size[rootY])
            {
                this.parent[rootY] = rootX;
                find(x);
            }
            else
            {
                this.parent[rootX] = rootY;
                find(y);
            }
        }
    }

    int find(int x)
    {
        int parentX = this.parent[x];
        if (parentX==x)
        {
            return x;
        }
        else
        {
            this.parent[x] = find(parentX);
            return this.parent[x];
        }
    }

    boolean connected(int x, int y)
    {
        return find(x)==find(y);
    }
}