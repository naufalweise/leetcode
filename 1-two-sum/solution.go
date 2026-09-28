package twosum

func twoSum(nums []int, target int) []int {
	numToIndices := make(map[int][]int)
	for i := 0; i < len(nums); i++ {
		numToIndices[nums[i]] = append(numToIndices[nums[i]], i)
	}
	for num, numIndices := range numToIndices {
		diff := target - num
		diffIndices := numToIndices[diff]
		if num == diff && len(numIndices) >= 2 {
			return []int{numIndices[0], numIndices[1]}
		}
		if num != diff && len(numIndices) >= 1 && len(diffIndices) >= 1 {
			return []int{numIndices[0], diffIndices[0]}
		}

	}
	return nil

}
