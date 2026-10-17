class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Node[] arr = new Node[n];
        for (int i=0; i<n; i++)
        {
            arr[i] = new Node(nums[i], i);
        }
        Arrays.sort(arr, (a,b)->(a.digitSum!=b.digitSum?a.digitSum-b.digitSum:a.value-b.value));
        int[] indexes = new int[n];
        for (int i=0; i<n; i++)
        {
            indexes[i] = arr[i].origIndex;
        }
        int swapCount = 0;
        // System.out.println(Arrays.toString(indexes));
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            indexMap.put(indexes[i], i);
        }
        for (int i=0; i<n; i++)
        {
            if (indexes[i]!=i)
            {
                // need swapping
                int expectedNum = i;
                int toSwapIndex = indexMap.get(expectedNum);

                int temp = indexes[i];
                indexes[i] = indexes[toSwapIndex];
                indexes[toSwapIndex] = temp;
                swapCount++;

                indexMap.put(indexes[i], i);
                indexMap.put(indexes[toSwapIndex], toSwapIndex);
            }
        }
        return swapCount;
    }
}

class Node
{
    int origIndex;
    int value;
    int digitSum;

    Node(int value, int index)
    {
        this.origIndex = index;
        this.value = value;
        this.digitSum = 0;
        int x = value;
        while(x>0)
        {
            this.digitSum += x%10;
            x /= 10;
        }
    }
}