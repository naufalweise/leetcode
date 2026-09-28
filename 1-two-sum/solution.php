class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $numToIndices = [];
        for ($i = 0; $i < count($nums); $i++) {
            $diff = $target - $nums[$i];
            if (isset($numToIndices[$diff])) {
                return [$numToIndices[$diff], $i];
            }
            $numToIndices[$nums[$i]] = $i;
        }
        return [];
    }
}
