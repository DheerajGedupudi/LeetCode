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
        int visitedCount = 0;
        for (int i=0; i<n; i++)
        {
            if (indegrees[i]==0)
            {
                q.offer(i);
                visited[i] = true;
                visitedCount++;
            }
        }
        while(q.isEmpty()==false)
        {
            int curr = q.poll();
            for (int child : adjList.get(curr))
            {
                if (indegrees[child]>0)
                {
                    indegrees[child]--;
                }
                if (visited[child]==false && indegrees[child]==0)
                {
                    visited[child] = true;
                    visitedCount++;
                    q.offer(child);
                }
            }
        }
        return visitedCount==numCourses;
    }
}