import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:nums){
            set.add(i);
        }
       int max=0;
       for(int i=0;i<nums.length;i++){
           int ele=nums[i];
           if(!set.contains(ele-1)){
               int c=0;
               while(set.contains(ele+1)){
                   c++;
                   ele=ele+1;
               }
               max=Math.max(max,c+1);
           }
       }
        return max;
    }
}