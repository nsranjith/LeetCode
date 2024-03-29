class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag=false;
        for(int i=0;i<matrix.length;i++){ 
            if(matrix[i][0]==0){
                flag=true;
            }   
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        int N=matrix.length-1;
        int M=matrix[0].length-1;
        for(int i=N;i>=0;i--){
            for(int j=M;j>=1;j--){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(flag){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
    }
}