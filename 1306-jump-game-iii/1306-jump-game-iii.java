class Solution {
    public boolean canReach(int[] arr, int start) {
        int used[]=new int[arr.length];
        return helper(arr,start,used)>0 ? true:false;
    }
    private int helper(int nums[], int pos, int used[]){
        if(pos>=nums.length || pos<0) return 0;
        if(nums[pos]==0) return 1;
        if(used[pos]!=1){
            used[pos]=1;
            int left=helper(nums,pos-nums[pos],used);
            int right=helper(nums,pos+nums[pos],used);
            return left | right;
        }
        return 0;
    }
}