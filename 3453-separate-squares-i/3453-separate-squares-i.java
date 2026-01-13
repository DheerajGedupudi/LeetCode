class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0;
        double high = Math.pow(10, 9)+10;
        double tolerance = Math.pow(10, -5);
        double answer = 0;
        while(high-low>=tolerance)
        {
            double mid = low + (high-low)/2;
            double areaRatio = get(squares, mid);
            if (areaRatio>1)
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
        double areaDown = 0;
        for (int[] sq : squares)
        {
            double xi = sq[0];
            double yi = sq[1];
            double li = sq[2];
            double top = yi+li;
            double bot = yi;
            double up = top-Math.max(y, bot);
            double down = Math.min(top, y)-bot;
            if (up>0)
            {
                areaUp += (up*li);
            }
            if (down>0)
            {
                areaDown += (down*li);
            }
        }
        return areaUp/areaDown;

    }
}


/*

dlfk


*/