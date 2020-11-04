class Solution:
    def maxSubArray(self, nums: List[int]) -> int:

        current_sum=float('-inf')
        max_sum=float('-inf')
        for i in range(len(nums)):
            # print(current_sum + nums[i], nums[i])
            current_sum = max(current_sum + nums[i], nums[i])
            max_sum = max(current_sum, max_sum)
            # print(max_sum)
        return max_sum
