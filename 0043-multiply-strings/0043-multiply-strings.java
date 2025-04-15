class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1<len2)
        {
            return multiply(num2, num1);
        }
        if (num2.equals("0"))
        {
            return "0";
        }
        String result = "";
        int places = 0;
        for (int i=len2-1; i>=0; i--)
        {
            int x = Character.getNumericValue(num2.charAt(i));
            String prod = multiply(num1, x, places);
            // System.out.println(result+" now prod : "+prod);
            result = add(prod, result);
            places++;
        }
        return result;
    }

    private String add(String num1, String num2)
    {
        List<Integer> list1 = num1.chars().mapToObj(c -> Character.getNumericValue((char)c)).toList().reversed();
        List<Integer> list2 = num2.chars().mapToObj(c -> Character.getNumericValue((char)c)).toList().reversed();
        List<Integer> carryList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        carryList.add(0);
        int n = list1.size();
        int m = list2.size();
        int index = 0;
        while(index<n && index<m)
        {
            int sum = list1.get(index)+list2.get(index)+carryList.get(index);
            result.add(sum%10);
            carryList.add(sum/10);
            index++;
        }
        while(index<n)
        {
            int sum = list1.get(index)+carryList.get(index);
            result.add(sum%10);
            carryList.add(sum/10);
            index++;
        }
        while(index<n)
        {
            int sum = list2.get(index)+carryList.get(index);
            result.add(sum%10);
            carryList.add(sum/10);
            index++;
        }
        if (carryList.get(index)>0)
        {
            result.add(carryList.get(index));
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : result)
        {
            sb.append(digit);
        }
        return sb.reverse().toString();
    }

    private String multiply(String num, int x, int zeros)
    {
        List<Integer> list = num.chars().mapToObj(c -> Character.getNumericValue((char)c)).toList().reversed();
        List<Integer> carryList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        carryList.add(0);
        int n = list.size();
        for (int i=0; i<n; i++)
        {
            int prod = (list.get(i)*x)+carryList.get(i);
            result.add(prod%10);
            carryList.add(prod/10);
        }
        if (carryList.get(n)>0)
        {
            result.add(carryList.get(n));
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : result)
        {
            sb.append(digit);
        }
        sb.reverse();
        for (int i=0; i<zeros; i++)
        {
            sb.append(0);
        }
        return sb.toString();
    }
}

/*

123
  8

 2
  4


c = 0
 
 9

*/