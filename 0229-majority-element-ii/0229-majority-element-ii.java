class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=0;
        int c2=0;
        int me1=-1;
        int me2=-1;
        for(int i=0;i<nums.length;i++){
             if(nums[i]==me1){
                c1++;
            }else if(nums[i]==me2){
                c2++;
            }else if(c1==0){
                me1=nums[i];
                c1++;
            }else if(c2==0){
                me2=nums[i];
                c2++;
            } else{
                c1--;
                c2--;
            }
        }
        List<Integer> list=new ArrayList<>();
        int count1=0;
        int count2=0;
        System.out.print(me1+"-"+me2);
        for(int i:nums){
            if(i==me1){
                count1++;
            }
            if(i==me2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            list.add(me1);
        }
        if(me2!=me1 && count2>nums.length/3){
            list.add(me2);
        }
        return list;
    }
}