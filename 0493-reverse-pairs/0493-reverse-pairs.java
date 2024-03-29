class Solution {
    int count=0;
    public int reversePairs(int[] nums) {
        helper(nums,0,nums.length-1);
        return count;
    }
    private void helper(int[] nums, int start, int end){
        if(start>=end) return;
        int mid=start+(end-start)/2;
        helper(nums,start,mid);
        helper(nums,mid+1,end);
        merge(nums,start,mid,end);
    }
    private void merge(int[] nums, int start, int mid, int end){
       int N=mid-start+1;
       int M=end-mid;
       int left[]=new int[N];
       int right[]=new int[M];
       int s=start;
       int e=mid+1; 
       while(s<=mid && e<=end){
           int one=nums[s];
           int two=nums[e];
           if((long)one>(long)2*two){
               count+=mid-s+1;
               e++;
           }else{
               s++;
           }
        }

       for(int i=0;i<N;i++){
           left[i]=nums[i+start];
       }
       for(int i=0;i<M;i++){
           right[i]=nums[i+mid+1];
       }
       int temp[]=new int[N+M];
       int k=0;
       int l=0;
       int c=0;
       while(k<N && l<M){
          // if((long)left[k]>(long)2*right[l]){
          //      count+=N-k;
          //  }
           if(left[k]<right[l]){
               temp[c]=left[k];
               k++;
               c++;
           }else if(left[k]==right[l]){
               temp[c]=left[k];
               k++;
               c++;
               temp[c]=right[l];
               l++;
               c++;
           }else{
               temp[c]=right[l];
               l++;
               c++;
           }
       }
       while(k<N){
           temp[c]=left[k];
           c++;
           k++;
       }
        while(l<M){
           temp[c]=right[l];
           c++;
           l++;
       }
       int j=0;
       for(int i=start;i<=end;i++){
           nums[i]=temp[j];
           j++;
       }
    }
}