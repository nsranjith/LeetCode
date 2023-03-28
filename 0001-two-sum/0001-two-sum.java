class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> set=new HashMap<Integer,Integer>();
        int[] ind=new int[2];
        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];
            if(set.containsKey(diff)){
                ind[0]=set.get(diff);
                ind[1]=i;
                break;
            }
            set.put(nums[i],i);
        }
        return ind; 
    }
}