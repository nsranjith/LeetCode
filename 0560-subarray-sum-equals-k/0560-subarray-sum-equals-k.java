class Solution {
    public int subarraySum(int[] nums, int k) {
        int pf[]=new int[nums.length];
        pf[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pf[i]=nums[i]+pf[i-1];
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int s=0;
        for(int i=0;i<pf.length;i++){
            if(pf[i]==k) s++;
            if(map.containsKey(pf[i]-k)){
                s+=map.get(pf[i]-k);
            }
            map.put(pf[i],map.getOrDefault(pf[i],0)+1);
        }
        return s;
    }
}