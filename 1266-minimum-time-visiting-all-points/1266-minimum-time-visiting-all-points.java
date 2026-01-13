class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int counter = 0;
        int n = points.length;
        for (int i=0; i<n-1; i++)
        {
            int diffx = Math.abs(points[i][0]-points[i+1][0]);
            int diffy = Math.abs(points[i][1]-points[i+1][1]);
            counter += Math.max(diffx, diffy);
        }
        return counter;
    }
}