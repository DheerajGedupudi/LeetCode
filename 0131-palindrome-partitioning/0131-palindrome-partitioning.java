class Solution {

    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        canPart(s, 0, new ArrayList<>());
        return this.result;
    }

    private void canPart(String s, int index, List<String> path)
    {
        int len = s.length();
        if (index==len)
        {
            this.result.add(new ArrayList<>(path));
            return;
        }
        // System.out.println("now : "+path+" checking : "+s.substring(index));
        if (isPal(s, index, len-1))
        {
            path.add(s.substring(index));
            canPart(s, len, path);
            path.remove(path.size()-1);
        }
        for(int i=index+1; i<len; i++)
        {
            String firstPart = s.substring(index,i);
            if (isPal(s, index, i-1))
            {
                path.add(firstPart);
                canPart(s, i, path);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPal(String s, int low, int high)
    {
        while(low<=high)
        {
            if (s.charAt(low)!=s.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}