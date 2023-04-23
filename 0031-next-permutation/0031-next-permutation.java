class Solution {
    public void nextPermutation(int[] nums) {
     /*
        1 2 3
        index1=1
        index 2=2
        1 3 2


     */
     
     
       int pos=-1;
       for(int i=nums.length-2;i>=0;i--){
           if(nums[i]<nums[i+1]){
               pos=i;
               break;
           }
       }
       
       if(pos==-1){

           /*
                3 2 1
                index 1

           */
           int i=0;
           int j=nums.length-1;
           while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
         }
         return;
       } // already in sorted and last one

       int pos1=-1;
       for(int i=nums.length-1;i>=0;i--){
           if(nums[i]>nums[pos]){
             pos1=i;
             break;
            }
       }
       int temp=nums[pos];
       nums[pos]=nums[pos1];
       nums[pos1]=temp;
       int j=nums.length-1;
       int i=pos+1;
       while(i<j){
        temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        i++;
        j--;
       }
    }
}