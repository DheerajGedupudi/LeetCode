class Solution {

    private Set<String> memo;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        this.memo = new HashSet<>();
        return dfs(bottom, allowed, 0, new StringBuilder());
    }

    private boolean dfs(String bottom, List<String> allowed, int index, StringBuilder sb)
    {
        if (bottom.length()==1)
        {
            return true;
        }
        if (index==bottom.length()-1)
        {
            bottom = sb.toString();
            if (this.memo.contains(bottom))
            {
                return false;
            }
            // System.out.println(" bottoms : "+this.memo);
            if (dfs(bottom, allowed, 0, new StringBuilder()))
            {
                return true;
            }
            else
            {
                this.memo.add(bottom);
            }
        }   
        if (index>=bottom.length()-1)
        {
            return false;
        }
        char left = bottom.charAt(index);
        char right = bottom.charAt(index+1);
        for (String word : allowed)
        {
            if (word.charAt(0)==left && word.charAt(1)==right)
            {
                sb.append(word.charAt(2));
                if (dfs(bottom, allowed, index+1, sb))
                {
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}