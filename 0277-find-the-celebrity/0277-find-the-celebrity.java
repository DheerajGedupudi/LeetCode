/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Map<Integer, Integer> followerMap = new HashMap<>();
        Map<Integer, Integer> followingMap = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (i!=j && knows(i,j))
                {
                    followingMap.put(i, followingMap.getOrDefault(i, 0)+1);
                    followerMap.put(j, followerMap.getOrDefault(j, 0)+1);
                }
            }
        }
        // System.out.println(followerMap);
        // System.out.println(followingMap);
        for (int i=0; i<n; i++)
        {
            if (followingMap.getOrDefault(i,0)==0 && followerMap.getOrDefault(i, 0)==n-1)
            {
                return i;
            }
        }
        return -1;
        
    }
}