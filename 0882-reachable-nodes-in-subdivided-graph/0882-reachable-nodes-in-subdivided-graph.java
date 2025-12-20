class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[] dist = dijkstra(edges, n);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int count = 1;
        for (int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int nodes = edge[2];
            int distToU = dist[u];
            if (visited[u]==false && distToU <= maxMoves)
            {
                count++;
                visited[u] = true;
            }
            int distToV = dist[v];
            if (visited[v]==false && distToV <= maxMoves)
            {
                count++;
                visited[v] = true;
            }
            int nodesFromU = Math.max(0, maxMoves-distToU);
            int nodesFromV = Math.max(0, maxMoves-distToV);
            int nodesToCount = Math.min(nodesFromU+nodesFromV, nodes);
            count += nodesToCount;
        }
        // System.out.println(Arrays.toString(dist));
        return count;
    }

    private int[] dijkstra(int[][] edges, int n)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        List<List<Edge>> adjList = getAdjList(edges, n);
        Queue<Edge> heap = new PriorityQueue<>((a,b)->(a.dist-b.dist));
        for (Edge child : adjList.get(0))
        {
            heap.add(child);
        }
        while(heap.isEmpty()==false)
        {
            Edge curr = heap.poll();
            int newDist = dist[curr.u]+curr.dist;
            if (newDist<dist[curr.v])
            {
                dist[curr.v] = newDist;
                for (Edge child : adjList.get(curr.v))
                {
                    heap.offer(child);
                }
            }
        }
        return dist;
    }

    private List<List<Edge>> getAdjList(int[][] edges, int n)
    {
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges)
        {
            adjList.get(edge[0]).add(new Edge(edge[0], edge[1], edge[2]+1));
            adjList.get(edge[1]).add(new Edge(edge[1], edge[0], edge[2]+1));
        }
        return adjList;
    }
}

class Edge
{
    int u;
    int v;
    int dist;

    Edge(int u, int v, int dist)
    {
        this.u = u;
        this.v = v;
        this.dist = dist;
    }
}