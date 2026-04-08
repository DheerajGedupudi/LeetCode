class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        int n = heights.length;
        for (int i=0; i<volume; i++)
        {
            int fallIndex = getFallIndex(k, heights);
            heights[fallIndex]++;
        }
        return heights;
    }

    private int getFallIndex(int k, int[] heights)
    {
        int n = heights.length;
        int hCap = heights[k];
        int best = k;
        // left
        for (int x1=k; x1>=0; x1--)
        {
            if (heights[x1]>heights[best])
            {
                // found space to fill before continuing left
                break;
            }
            if (heights[x1]<heights[best])
            {
                best = x1;
            }
        }
        if (best!=k)
        {
            return best;
        }
        // right
        for (int x1=k; x1<n; x1++)
        {
            if (heights[x1]>heights[best])
            {
                // found space to fill before continuing right
                break;
            }
            if (heights[x1]<heights[best])
            {
                best = x1;
            }
        }
        return best;
    }
}