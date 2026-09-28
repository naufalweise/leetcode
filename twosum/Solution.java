import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Deque<Integer>> numIndices = new HashMap<>();
        int index = 0;
        for (int num : nums) {
            Deque<Integer> indices = numIndices.computeIfAbsent(num, k -> new LinkedList<>());
            indices.add(index);
            index++;
        }
        List<Integer> sumPairIndices = new ArrayList<>();
        for (Map.Entry<Integer,Deque<Integer>> entry: numIndices.entrySet()) {
            Integer num = entry.getKey();

            Deque<Integer> thisIndices = entry.getValue();
            if (thisIndices.isEmpty()) {
                continue;
            }

            Integer diff = target - num;
            Deque<Integer> diffIndices = numIndices.get(diff);
            if (diffIndices == null || diffIndices.isEmpty()) {
                continue;
            }


            while (!thisIndices.isEmpty()) {
                Integer pair1 = thisIndices.pop();
                // Need to recheck if empty, for a condition where this num = diff
                if (diffIndices.isEmpty()) break;
                Integer pair2 = diffIndices.pop();
                sumPairIndices.add(pair1);
                sumPairIndices.add(pair2);
            }

        }
        return sumPairIndices.stream().mapToInt(e->e).toArray();
    }
}
