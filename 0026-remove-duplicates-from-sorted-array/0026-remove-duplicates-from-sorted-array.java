class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; 
        
        int next = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[next]) { 
                next++;
                nums[next] = nums[i];
            }
        }
        
        return next + 1;
    }
}