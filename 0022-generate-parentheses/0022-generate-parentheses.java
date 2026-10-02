class Solution {

    private List<String> result;

    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();    
        helper(n, new StringBuilder(), 0, 0);
        return this.result;
    }

    private void helper(int n, StringBuilder sb, int total, int open)
    {
        if (sb.length()==n*2)
        {
            if (total==n)
            {
                this.result.add(sb.toString());
            }
            return;
        }
        //1
        if (open<n)
        {
            sb.append("(");
            helper(n, sb, total+1, open+1);
            sb.deleteCharAt(sb.length()-1);
        }
        //2
        if (open>0)
        {
            sb.append(")");
            helper(n, sb, total, open-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}