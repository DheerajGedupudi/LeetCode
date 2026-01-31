class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int best = -1;
        int n = letters.length;
        int low = 0;
        int high = n-1;
        int tar = target-'a';
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int curr = letters[mid]-'a';
            if (curr>tar)
            {
                best = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        if (best==-1)
        {
            return letters[0];
        }
        return letters[best];
    }
}