class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                 int temp=matrix[i][j];
                 matrix[i][j]=matrix[j][i];
                 matrix[j][i]=temp;   
            }
        }
        int j=matrix[0].length-1;
        int k=0;
        while(k<j){
            for(int i=0;i<matrix.length;i++){ 
                int temp=matrix[i][k];
                matrix[i][k]=matrix[i][j];
                matrix[i][j]=temp;
            }
            j--;
            k++;
        }
    }
}