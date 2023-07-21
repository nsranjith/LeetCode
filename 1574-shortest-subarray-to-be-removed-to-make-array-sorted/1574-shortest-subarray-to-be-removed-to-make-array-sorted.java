class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int N=arr.length;
        int left=0;
        int right=N-1;
        while(left+1 <N  && arr[left]<=arr[left+1]) left++;
        
        if(left==N) return 0;

        while(right-1>=0 && arr[right]>=arr[right-1]) right--;

        if(right==0) return 0;

        int ans=Math.min(right, N-left-1);

        int i=0;
        int j=right;

        while(i<=left && j<N){
            if(arr[j]>=arr[i]){
                ans=Math.min(ans,j-i-1);
                i++;
            }else{
                j++;
            }
        }

        return ans;
        
    }
}