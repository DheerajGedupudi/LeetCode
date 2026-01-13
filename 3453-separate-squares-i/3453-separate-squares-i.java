class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0;
        double high = Math.pow(10, 9)+10;
        double precision = Math.pow(10, -5);
        double answer = 0;
        double area = 0;
        for (int[] sq : squares)
        {
            int xi = sq[0];
            int yi = sq[1];
            int li = sq[2];
            double top = yi+li;
            area += ((top-yi)*li);
        }
        while(high-low>=precision)
        {
            double mid = low + (high-low)/2;
            double areaUp = get(squares, mid);
            if (areaUp>area/2)
            {
                low = mid;
            }
            else
            {
                high = mid;
            }
            answer = mid;
        }
        return answer;
    }

    private double get(int[][] squares, double y)
    {
        double areaUp = 0;
        for (int[] sq : squares)
        {
            int xi = sq[0];
            int yi = sq[1];
            int li = sq[2];
            double top = yi+li;
            double up = top-Math.max(y, yi);
            if (up>0)
            {
                areaUp += (up*li);
            }
        }
        return areaUp;

    }
}


/*

dlfk


*/