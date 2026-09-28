from functools import reduce
from collections import defaultdict


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        nums_set = set()
        nums_duplicate = set()
        num_to_indices = defaultdict(list)

        for index, num in enumerate(nums):
            num_to_indices[num].append(index)
            if not num in nums_set:
                nums_set.add(num)
            else:
                nums_duplicate.add(num)
        for num in nums_set:
            diff = target - num
            if diff in nums_set and not ((diff == num) ^ (num in nums_duplicate)):
                x = num_to_indices[num].pop()
                y = num_to_indices[diff].pop()
                return [x, y]
        return [0, 0]