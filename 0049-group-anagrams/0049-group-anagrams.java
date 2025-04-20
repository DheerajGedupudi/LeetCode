class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Integer[]> freqList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;
        for (int i=0; i<n; i++)
        {
            Integer[] freq = new Integer[26];
            Arrays.fill(freq, 0);
            for (char c : strs[i].toCharArray())
            {
                freq[c-'a']++;
            }
            int foundIndex = -1;
            for (int j=0; j<freqList.size(); j++)
            {
                if (equals(freq, freqList.get(j)))
                {
                    foundIndex = j;
                }
            }
            if (foundIndex==-1)
            {
                freqList.add(freq);
                result.add(new ArrayList<>());
                foundIndex = freqList.size()-1;
            }
            result.get(foundIndex).add(strs[i]);
        }
        return result;
    }

    private boolean equals(Integer[] a, Integer[] b)
    {
        for (int i=0; i<26; i++)
        {
            if (a[i]!=b[i])
            {
                return false;
            }
        }
        return true;
    }
}

/*


int[]  count
List<int[]>

*/