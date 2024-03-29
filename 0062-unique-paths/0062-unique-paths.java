class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        int grid[][]=new int[m][n];
        int vis[][]=new int[m][n];
        dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(grid,0,0,vis);
    }
    private int helper(int grid[][], int m, int n,int vis[][]){ 
        if(m==grid.length-1 && n==grid[0].length-1){
            return 1;
        }
        int rows[]={1,0};
        int cols[]={0,1};
        vis[m][n]=1;
        int res=0;
        if(dp[m][n]!=-1) return dp[m][n];
        for(int i=0;i<2;i++){
            int nr=m+rows[i];
            int nc=n+cols[i];
            if(nr<grid.length && nc<grid[0].length && nr>=0 && nc>=0 && vis[nr][nc]!=1) {
              res += helper(grid,nr,nc,vis);
            }
        }
        vis[m][n]=0;
        return dp[m][n]=res;
    }
}