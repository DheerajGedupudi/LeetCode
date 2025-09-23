class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        if (arr1.length==0)
        {
            arr1 = new String[]{version1};
        }
        if (arr2.length==0)
        {
            arr2 = new String[]{version2};
        }
        List<String> list1 = Arrays.asList(arr1);
        List<String> list2 = Arrays.asList(arr2);
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        for (String s : list1)
        {
            int x = Integer.parseInt(s);
            nums1.add(x);
        }
        for (String s : list2)
        {
            int x = Integer.parseInt(s);
            nums2.add(x);
        }
        while(nums1.size()>0 && nums1.get(nums1.size()-1)==0)
        {
            nums1.remove(nums1.size()-1);
        }
        while(nums2.size()>0 && nums2.get(nums2.size()-1)==0)
        {
            nums2.remove(nums2.size()-1);
        }
        // System.out.println(nums1+" "+nums2);
        int index = 0;
        while(index<nums1.size() || index<nums2.size())
        {
            int v1 = 0;
            int v2 = 0;
            if (index<nums1.size())
            {
                v1 = nums1.get(index);
            }
            if (index<nums2.size())
            {
                v2 = nums2.get(index);
            }
            if (v1<v2)
            {
                return -1;
            }
            else if (v1>v2)
            {
                return 1;
            }
            index++;
        }
        return 0;
    }
}