class Solution {
    int l[];
    int r[];
    public int trap(int[] height) {
        l=new int[height.length+1];
        r=new int[height.length+1];
        l[0]=0;
        for(int i=1;i<height.length;i++){
            l[i]=Math.max(height[i-1],l[i-1]);
        }
        r[height.length-1]=0;
        for(int i=height.length-2;i>=0;i--){
            r[i]=Math.max(height[i+1],r[i+1]);
        }
        int ans=0;
        for(int i=0;i<height.length;i++){
            int max=Math.min(l[i],r[i]);
            ans+=max<height[i]?0:max-height[i];
        }
        return ans;
    }
}