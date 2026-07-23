class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int maxLen= 0;
        int left= 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            left =Math.max(index[current], left);
            maxLen= Math.max(maxLen, i-left + 1);
            index[current] = i + 1;
        }
        return maxLen;
    }
}