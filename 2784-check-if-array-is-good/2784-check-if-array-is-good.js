/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isGood = function(nums) {
    let count = {};
    let size = nums.length;
    let foundTwoCount = false;
    for (let i in nums)
    {
        if (count[nums[i]] == null)
        {
            count[nums[i]] = 1;
        }
        else
        {
            count[nums[i]]++;
            if (count[nums[i]]==2)
            {
                if (nums[i]!==size-1)
                {
                    return false;
                }
                foundTwoCount = true;
            }
        }
    }
    for (let i=1; i<size; i++)
    {
        if (count[i]!==1 && count[i]!==2)
        {
            return false;
        }
    }
    return foundTwoCount;
};