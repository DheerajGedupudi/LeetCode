class Solution {
    public int minimumCost(int n, int[][] connections) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0; i<=n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : connections)
        {
            adjList.get(edge[0]).add(new Node(edge[0], edge[1], edge[2]));
            adjList.get(edge[1]).add(new Node(edge[1], edge[0], edge[2]));
        } 
        // System.out.println(adjList);
        Queue<Node> heap = new PriorityQueue<>((a,b)->(a.dist-b.dist));
        boolean[] visited = new boolean[n+1];
        int cost = 0;
        for (Node node : adjList.get(1))
        {
            heap.offer(node);
        }
        while(heap.isEmpty()==false)
        {
            Node curr = heap.poll();
            while(heap.isEmpty()==false && (visited[curr.u]&&visited[curr.v])==true)
            {
                curr = heap.poll();
            }
            if (visited[curr.u]&&visited[curr.v])
            {
                //all visited, atleast connected ones
                break;
            }
            // System.out.println("added : "+curr.u+" -> "+curr.v);
            if (visited[curr.u]==false)
            {
                for (Node node : adjList.get(curr.u))
                {
                    heap.offer(node);
                }
            }
            if (visited[curr.v]==false)
            {
                for (Node node : adjList.get(curr.v))
                {
                    heap.offer(node);
                }
            }
            visited[curr.u] = true;
            visited[curr.v] = true;
            cost += curr.dist;
        }
        for (int i=1; i<=n; i++)
        {
            if (visited[i]==false)
            {
                return -1;
            }
        }
        return cost;
    }
}

class Node
{
    int u;
    int v;
    int dist;

    Node(int u, int v, int dist)
    {
        this.u = u;
        this.v = v;
        this.dist = dist;
    }

    @Override
    public String toString()
    {
        return "[ u: "+this.u+", v: "+this.v+", dist:"+this.dist+" ]\n";
    }
}