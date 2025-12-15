class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int)Math.pow(10,9);
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (possible(dist, hour, mid))
            {
                best = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return best;
    }

    private boolean possible(int[] dist, double hour, int speed)
    {
        // System.out.println("--------------------- speed : "+speed);
        double countHours = 0;
        int n = dist.length;
        for (int i=0; i<n; i++)
        {
            countHours = (int)Math.ceil(countHours);
            double d = dist[i];
            double time = d/speed;
            countHours += time;
            // System.out.println("at : "+d+" -> count : "+countHours+" time taken : "+time);
        }
        return countHours<=hour;
    }
}


/*


dist = d

speed = s

time taken = d/s




*/