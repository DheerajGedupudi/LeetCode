class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1>n2)
        {
            return false;
        }
        int[] count1 = new int[26];
        for (char c : s1.toCharArray())
        {
            count1[c-'a']++;
        }
        int[] count2 = new int[26];
        for (int i=0; i<n1; i++)
        {
            count2[s2.charAt(i)-'a']++;
        }
        if (equals(count1, count2))
        {
            return true;
        }
        for (int i=n1; i<n2; i++)
        {
            int toRemove = i-n1;
            int toAdd = i;
            count2[s2.charAt(toRemove)-'a']--;
            count2[s2.charAt(toAdd)-'a']++;
            if (equals(count1, count2))
            {
                return true;
            }
        }
        return false;
    }

    private boolean equals(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        for(int i=0; i<n; i++)
        {
            if (arr1[i]!=arr2[i])
            {
                return false;
            }
        }
        return true;
    }
}