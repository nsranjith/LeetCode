class Solution {
    public int strStr(String haystack, String needle) {
        String f=needle+ '$' + haystack;
        int Z[]=new int[f.length()];
        Z[0]=f.length();
        Zarr(f,Z);
        for(int i=0;i<Z.length;i++){
            if(Z[i]==needle.length()){
                return i-needle.length()-1;
            }
            // System.out.print(z[i]);
        }
        return -1;
    }
    private void Zarr(String f, int[] Z){
       int L=0;
       int R=0;
        System.out.println("hii");
        for(int i=1;i<f.length();i++){
            if(i>R){
                //bf
                L=R=i;
                while(R<f.length() && f.charAt(R)==f.charAt(R-L)){
                    R++;
                }
                Z[i]=R-L;
                R--;
                                // System.out.println("heloooooooooooooooo");

            }else{
                //
                int lookup=i-L;
                int windowLength=R-i+1;
                if(Z[lookup]<windowLength){
                    Z[i]=Z[lookup];
                }else{
                    L=R=i;
                    while(R<f.length() && f.charAt(R)==f.charAt(R-L)){
                        R++;
                    }
                    Z[i]=R-L;
                    R--;
                      // System.out.println("heloooooooooooooooo");
                }
            }
        }
                System.out.println("heloooooooooooooooo");
    }
}