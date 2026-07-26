class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        // Preprocess the string to handle even length palindromes
        String T = preprocess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i; // Find the mirror of i
            
            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }
            
            // Attempt to expand palindrome centered at i
            while (i + (1 + P[i]) < n && i - (1 + P[i]) >= 0 && 
                   T.charAt(i + (1 + P[i])) == T.charAt(i - (1 + P[i]))) {
                P[i]++;
            }
            
            // If palindrome centered at i expands past R,
            // adjust center and right boundary
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        
        // Find the maximum element in P
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        
        // Extract the longest palindromic substring
        int start = (centerIndex - maxLen) / 2;
        int end = start + maxLen;
        return s.substring(start, end);
    }
    
    // Helper method to preprocess the string
    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
}