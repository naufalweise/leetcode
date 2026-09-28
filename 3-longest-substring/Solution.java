import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // moving window
        // try each start index as the start of the window
        // expand the window forward as long as there is no duplicate
        // save the longest window:
        // compare current window's length with the last saved longest window
        // if bigger, set the longest window to current window
        // move on to the next starting index for the new window
        // repeat the process until all starti
        // return longest window
        int longestSubstring = 0;
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            Set<Character> substrSet = new HashSet<>();
            int endIndex = startIndex;
            while (endIndex < s.length() && !substrSet.contains(s.charAt(endIndex))) {
                substrSet.add(s.charAt(endIndex));
                endIndex++;
            }
            int length = endIndex - startIndex;
            longestSubstring = Math.max(longestSubstring, length);
        }
        return longestSubstring;
    }
}