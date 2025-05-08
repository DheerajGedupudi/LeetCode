class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0; i<=n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] time : times)
        {
            adjList.get(time[0]).add(new Node(time[0], time[1], time[2]));
        }
        Queue<Node> q = new LinkedList<>();
        for (Node child : adjList.get(k))
        {
            q.offer(child);
        }
        while(q.isEmpty()==false)
        {
            Node curr = q.poll();
            int newDist = dist[curr.origin]+curr.distance;
            if (dist[curr.destination]>newDist)
            {
                dist[curr.destination] = newDist;
                for (Node child : adjList.get(curr.destination))
                {
                    q.offer(child);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=n; i++)
        {
            max = Math.max(max, dist[i]);
        }
        if (max==Integer.MAX_VALUE)
        {
            return -1;
        }
        return max;
    }
}

class Node
{
    int origin;
    int destination;
    int distance;

    Node (int origin, int dest, int dist)
    {
        this.origin = origin;
        this.destination = dest;
        this.distance = dist;
    }
}