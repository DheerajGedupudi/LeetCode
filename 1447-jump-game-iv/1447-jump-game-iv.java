class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            int x = arr[i];
            indexMap.putIfAbsent(x, new ArrayList<>());
            indexMap.get(x).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        visited[0] = true;
        int jumps = 0;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                int index = q.poll();
                if (index==n-1)
                {
                    return jumps;
                }
                int left = index-1;
                int right = index+1;
                if (left>=0 && left<n && visited[left]==false)
                {
                    q.offer(left);
                    visited[left] = true;
                }
                if (right>=0 && right<n && visited[right]==false)
                {
                    q.offer(right);
                    visited[right] = true;
                }
                for (int child : indexMap.getOrDefault(arr[index], new ArrayList<>()))
                {
                    if (child!=index && visited[child]==false)
                    {
                        q.offer(child);
                        visited[child] = true;
                    }
                }
                //remove visited
                indexMap.remove(arr[index]);
            }
            jumps++;
        }
        return -1;
    }
}