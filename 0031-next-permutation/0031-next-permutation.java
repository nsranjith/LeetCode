class Solution {
    public void nextPermutation(int[] nums) {
    
        int pos=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pos=i;
                break;
            }
        }
        if(pos==-1){
            reverse(nums,0);
            return;
        }
        // 1 3 2 4
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>nums[pos]){
               int temp=nums[i];
               nums[i]=nums[pos];
               nums[pos]=temp;
               break;
            }
        }
        reverse(nums,pos+1);
    }
    private void reverse(int nums[], int index){
        int i=index;
        int j=nums.length-1;
        while(i<=j){
             int temp=nums[i];
             nums[i]=nums[j];
             nums[j]=temp;
             i++;
             j--;
        }
    }
}