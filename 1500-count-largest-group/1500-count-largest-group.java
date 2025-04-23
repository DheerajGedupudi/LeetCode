class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        Map<Integer, Integer> sizeMap = new HashMap<>();
        int maxSize = 0;
        int answer = 0;
        for (int i=1; i<=n; i++)
        {
            int sum = sumDigits(i);
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        for (int sum : sumMap.keySet())
        {
            int size = sumMap.get(sum).size();
            sizeMap.put(size, sizeMap.getOrDefault(size, 0)+1);
        }
        for (int size : sizeMap.keySet())
        {
            if (size>maxSize)
            {
                maxSize = size;
                answer = sizeMap.get(size);
            }
        }
        // System.out.println(sumMap);
        // System.out.println(sizeMap);
        return answer;

    }

    private int sumDigits(int n)
    {
        int sum = 0;
        while(n>0)
        {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}