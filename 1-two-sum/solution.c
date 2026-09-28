#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    *returnSize = 2;
    int* result = (int*)malloc(sizeof(int) * (*returnSize));
    for (int i = 0; i < numsSize; i++) {
        int diff = target - nums[i];
        for (int j = i + 1 ; j < numsSize; j++) {
            if (nums[j] == diff) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    } 
    result[0] = -1;
    result[1] = -1;
    return result;
}
