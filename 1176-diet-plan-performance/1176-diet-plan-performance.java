class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int n = calories.length;
        int sum = 0;
        for (int i=0; i<k; i++)
        {
            sum += calories[i];
        }
        int counter = 0;
        if (sum<lower)
        {
            counter--;
        }
        else if (sum>upper)
        {
            counter++;
        }
        for (int i=k; i<n; i++)
        {
            sum -= calories[i-k];
            sum += calories[i];
            if (sum<lower)
            {
                counter--;
            }
            else if (sum>upper)
            {
                counter++;
            }
        }
        return counter;
    }
}