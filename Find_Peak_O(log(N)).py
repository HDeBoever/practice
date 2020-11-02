# Binary search O(log(n)) recursive
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # Now come up with the O(log(n)) solution, divide and conquer
        return self.search(nums, 0, len(nums) - 1)

    def search(self, A, left, right):
        if left == right:
            return left
        middle_index = (left + right) // 2
        if(A[middle_index] > A[middle_index + 1]):
            # Search the left half
            return self.search(A, left, middle_index)
        # Else search the right half
        return self.search(A, middle_index + 1, right)
