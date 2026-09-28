#include <vector>
#include <unordered_map>
#include <iostream>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::unordered_map<int, int> numToIndices;
        for (int i = 0; i < nums.size(); i++) {
            int diff = target - nums[i];
            if (numToIndices.count(diff)) {
                return {i, numToIndices[diff]};
            }
            numToIndices[nums[i]] = i;
        }
        return {};
    }
};

int main() {
    std::cout << "Hello World" << std::endl;
    Solution solution;
    std::vector<int> nums1 = {2, 7, 11, 15};
    int target1 = 9;
    std::vector<int> res1 = solution.twoSum(nums1, target1);
    std::cout << res1[0] << "," << res1[1] << std::endl;
}