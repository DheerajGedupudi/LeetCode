class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] triplet = new int[]{0,0,0};
        int n = triplets.length;
        for (int i=0; i<n; i++)
        {
            int[] triplet2 = triplets[i];
            //usable?
            if (triplet2[0]>target[0] || triplet2[1]>target[1] || triplet2[2]>target[2])
            {
                continue;
            }
            triplet[0] = Math.max(triplet[0], triplet2[0]);
            triplet[1] = Math.max(triplet[1], triplet2[1]);
            triplet[2] = Math.max(triplet[2], triplet2[2]);
        }
        return triplet[0]==target[0] && triplet[1]==target[1] && triplet[2]==target[2];
    }
}