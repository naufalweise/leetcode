/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const numToIndices = nums.reduce((acc, val, i) => {
        const indices = acc.get(val) || [];
        indices.push(i);
        acc.set(val, indices);
        return acc;
    }, new Map() );
    const theNum = numToIndices.keys().find(val => {
        const diff = target - val;
        if (!numToIndices.has(diff)) {
            return false;
        }
        if (diff == val && numToIndices.get(diff).length < 2) {
            return false;
        }
        return true;
        
    });
    const diff = target - theNum;
    return [numToIndices.get(theNum).pop(), numToIndices.get(diff).pop()]; // ensure if diff is equal to theNum, it will not different indices

};
const test1 = twoSum([2, 7, 11, 15], 9);
console.log(test1);
