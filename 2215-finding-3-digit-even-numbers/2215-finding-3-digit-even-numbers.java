class Solution {

    Set<Integer> result;

    public int[] findEvenNumbers(int[] digits) {
        this.result = new HashSet<>();
        int n = digits.length;
        addUnitPlace(digits, new boolean[n], n, null);
        int size = this.result.size();
        int[] arr = new int[size];
        int index = 0;
        for (int num : this.result)
        {
            arr[index++] = num;
        }
        Arrays.sort(arr);
        return arr;
    }

    private void addUnitPlace(int[] digits, boolean[] visited, int n, Integer num)
    {
        //adding first
        for (int i=0; i<n; i++)
        {
            if (digits[i]%2==0 && visited[i]==false)
            {
                visited[i] = true;
                num = digits[i];
                addTenth(digits, visited, n, num);
                num = null;
                visited[i] = false;
            }
        }
    }

    void addTenth(int[] digits, boolean[] visited, int n, Integer num)
    {
        for (int i=0; i<n; i++)
        {
            if (visited[i]==false)
            {
                visited[i] = true;
                num = (digits[i]*10)+num;
                addHundredth(digits, visited, n, num);
                num %= 10;
                visited[i] = false;
            }
        }
    }

    void addHundredth(int[] digits, boolean[] visited, int n, Integer num)
    {
        for (int i=0; i<n; i++)
        {
            if (digits[i]>0 && visited[i]==false)
            {
                visited[i] = true;
                num = (digits[i]*100)+num;
                this.result.add(num);
                num %= 100;
                visited[i] = false;
            }
        }
    }
}