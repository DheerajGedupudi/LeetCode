class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<numCourses; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites)
        {
            adjList.get(prereq[1]).add(prereq[0]);
        }
        // System.out.println(adjList);
        List<Integer> order = topSort(adjList);
        // System.out.println(order);
        return order.size()==numCourses;
    }

    private List<Integer> topSort(List<List<Integer>> adjList)
    {
        List<Integer> list = new ArrayList<>();
        int n = adjList.size();
        int[] indegrees = new int[n];
        for (int i=0; i<n; i++)
        {
            for (int child : adjList.get(i))
            {
                indegrees[child]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++)
        {
            if (indegrees[i]==0)
            {
                q.offer(i);
                visited[i] = true;
            }
        }
        while(q.isEmpty()==false)
        {
            int curr = q.poll();
            list.add(curr);
            for (int child : adjList.get(curr))
            {
                if (indegrees[child]>0)
                {
                    indegrees[child]--;
                }
                if (visited[child]==false && indegrees[child]==0)
                {
                    visited[child] = true;
                    q.offer(child);
                }
            }
        }
        return list;
    }
}