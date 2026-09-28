function twoSum(nums: number[], target: number): number[] {
    
    const numToIndices: Map<number, number[]> = nums.reduce((acc, val, i) => {
        const indices = acc.get(val) || [];
        indices.push(i);
        acc.set(val, indices);
        return acc;
    }, new Map() );
    const theNum = [...numToIndices.keys()].find(val => {
        const diff = target - val;
        if (!numToIndices.has(diff)) {
            return false;
        }
        if (diff === val && (numToIndices.get(diff)?.length ?? 0) < 2) {
            return false;
        }
        return true;
        
    }) ?? -1;
    const diff = target - theNum;
    return [numToIndices.get(theNum)?.pop() ?? -1, numToIndices.get(diff)?.pop() ?? -1]; // ensure if diff is equal to theNum, it will not different indices
    // return [-1. -1] if no number with described constraints is found
};