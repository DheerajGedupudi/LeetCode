class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String s : strs)
        {
            // ArrayList<Integer> ascii = new ArrayList<>();
            // for (int i=0; i<26; i++)
            // {
            //     ascii.add(0);
            // }
            // for (char c : s.toCharArray())
            // {
            //     int freq = ascii.get(c-'a');
            //     ascii.set((c-'a'),freq+1);
            // }
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            ArrayList<String> list = map.getOrDefault(sorted, new ArrayList<String>());
            list.add(s);
            map.put(sorted, list);
        }
        // System.out.println(map);
        for (Map.Entry<String, ArrayList<String>> m : map.entrySet())
        {
            ans.add(m.getValue());
        }
        return ans;
    }
}