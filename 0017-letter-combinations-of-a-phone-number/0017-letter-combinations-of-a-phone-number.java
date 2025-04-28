class Solution {

    private char[][] pad;
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        this.pad = new char[][]{{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
        this.result = new ArrayList<>();
        if (digits.length()==0)
        {
            return this.result;
        }
        backtrack(digits, 0, new StringBuilder());
        return this.result;
    }

    private void backtrack(String digits, int index, StringBuilder sb)
    {
        int len = digits.length();
        if (index==len)
        {
            this.result.add(sb.toString());
            return;
        }
        int x = Character.getNumericValue(digits.charAt(index));
        for (char c : this.pad[x])
        {
            sb.append(c);
            backtrack(digits, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}