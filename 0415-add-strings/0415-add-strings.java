class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1.reverse();
        sb2.reverse();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(index<sb1.length() && index<sb2.length())
        {
            int x = Character.getNumericValue(sb1.charAt(index));
            int y = Character.getNumericValue(sb2.charAt(index));
            int sum = x+y+carry;
            carry = sum/10;
            sum %= 10;
            sb.append(sum);
            index++;
        }
        while(index<sb1.length())
        {
            int x = Character.getNumericValue(sb1.charAt(index));
            int sum = x+carry;
            carry = sum/10;
            sum %= 10;
            sb.append(sum);
            index++;
        }
        while(index<sb2.length())
        {
            int x = Character.getNumericValue(sb2.charAt(index));
            int sum = x+carry;
            carry = sum/10;
            sum %= 10;
            sb.append(sum);
            index++;
        }
        if (carry>0)
        {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}