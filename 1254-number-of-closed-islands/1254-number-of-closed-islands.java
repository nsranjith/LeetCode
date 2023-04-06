class Solution {
    public int closedIsland(int[][] grid) {
        int visited[][]=new int[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    boolean flag=dfs(grid,i,j,visited);
                    if(flag) c++;
                }
            }
        }
        return c;
    }
    private boolean dfs(int[][] grid, int r, int c, int[][] visited){
        int rows[]={-1,1,0,0};
        int cols[]={0,0,-1,1};
        if(r==0 || c==0 || r==(grid.length-1) || c==(grid[0].length-1)) return false;
        grid[r][c]=1;
        visited[r][c]=1;
        boolean flag=true;
        for(int i=0;i<4;i++){
            int nr=rows[i]+r;
            int nc=cols[i]+c;
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==0 && visited[nr][nc]!=1){
                flag=flag & dfs(grid,nr,nc,visited);
            }
        }
        visited[r][c]=0;
        return flag;
    }
}