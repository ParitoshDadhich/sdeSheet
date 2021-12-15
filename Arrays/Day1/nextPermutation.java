class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <=1) return;
        
        // first break point can occur at second last index
        int i = nums.length-2;
        
        // checking for the break point;
        while(i>=0 && nums[i] >= nums[i+1])
            i--;
        
        // if we have got the break point
        if(i >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i]) j--;
            swap(i, j, nums);
        }
        
        reverseArray(nums, i+1, nums.length-1);
    }
    
    private void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void reverseArray(int nums[], int i, int l){
        while(i<l){
            swap(i++, l--, nums);
        }
    }
    
}
