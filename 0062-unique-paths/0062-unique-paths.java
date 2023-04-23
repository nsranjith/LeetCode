class Solution {
    int dp[][];
    int ans=0;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        int visited[][]=new int[m][n];
        return helper(m,n,0,0,visited);
    }
    private int helper(int m,int n,int i, int j, int[][] visited){
        int rows[]={1,0};
        int cols[]={0,1};
        int ans=0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==m-1 && j==n-1){
            return 1;
        }
        for(int k=0;k<2;k++){
            int nr=rows[k]+i;
            int nc=cols[k]+j;
            if(nr<m && nc<n && nr>=0 && nc>=0 && visited[nr][nc]!=1){
                visited[nr][nc]=1;
                ans+=helper(m,n,nr,nc,visited);
                visited[nr][nc]=0;
            }
            
        }
        
        return dp[i][j]=ans;
    }
}