class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> elec = new ArrayList<>();
        List<String> groc = new ArrayList<>();
        List<String> phar = new ArrayList<>();
        List<String> rest = new ArrayList<>();
        int n = code.length;
        for (int i=0; i<n; i++)
        {
            if (isValidCode(code[i]) && isActive[i])
            {
                String line = businessLine[i];
                if (line.equals("electronics"))
                {
                    elec.add(code[i]);
                }
                if (line.equals("grocery"))
                {
                    groc.add(code[i]);
                }
                if (line.equals("pharmacy"))
                {
                    phar.add(code[i]);
                }
                if (line.equals("restaurant"))
                {
                    rest.add(code[i]);
                }
            }
        }
        Collections.sort(elec);
        Collections.sort(groc);
        Collections.sort(phar);
        Collections.sort(rest);
        List<String> result = new ArrayList<>();
        result.addAll(elec);
        result.addAll(groc);
        result.addAll(phar);
        result.addAll(rest);
        return result;
    }

    private boolean isValidCode(String s)
    {
        if (s.length()==0)
        {
            return false;
        }
        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && !Character.isLetter(c) && c!='_')
            {
                return false;
            }
        }
        return true;
    }
}