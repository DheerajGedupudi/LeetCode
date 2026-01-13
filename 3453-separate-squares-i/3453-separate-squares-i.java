class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0;
        double high = Math.pow(10, 9)+10;
        double precision = Math.pow(10, -5);
        double answer = 0;
        double area = 0;
        for (int[] sq : squares)
        {
            double xi = sq[0];
            double yi = sq[1];
            double li = sq[2];
            double top = yi+li;
            double bot = yi;
            area += ((top-bot)*li);
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
            double xi = sq[0];
            double yi = sq[1];
            double li = sq[2];
            double top = yi+li;
            double bot = yi;
            double up = top-Math.max(y, bot);
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