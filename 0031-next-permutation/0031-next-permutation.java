class Solution {
    public void nextPermutation(int[] nums) {
        int smallest=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                smallest=i;
                break;
            }
        }
        if(smallest !=-1){
            for(int i=nums.length-1;i>smallest;i--){
                if(nums[i]>nums[smallest]){
                    swap(nums,smallest,i);
                    break;
                }
            }
        }
        reverse(nums,smallest+1,nums.length-1);
    }
    private void swap(int nums[],int i,int j) {
        int temp =nums[i];
        nums[i] =nums[j];
        nums[j] =temp;
    }

    private void reverse(int nums[],int left,int right) {
        while (left<right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}