class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<numCourses; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites)
        {
            adjList.get(prereq[1]).add(prereq[0]);
        }
        int[] indegrees = new int[numCourses];
        for (int i=0; i<numCourses; i++)
        {
            for (int child : adjList.get(i))
            {
                indegrees[child]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        int[] answer = new int[numCourses];
        int index = 0;
        int visitedCount = 0;
        for (int i=0; i<numCourses; i++)
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
            answer[index++] = curr;
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
        if (visitedCount!=numCourses)
        {
            return new int[0];
        }
        return answer;
    }
}