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
​
}else{
//
int lookup=i=L;
int windowLength=R-L+1;
if(Z[lookup]<windowLength){
Z[i]=Z[lookup];
}else{
L=i;
while(R<f.length() && f.charAt(R)==f.charAt(R-L)){
R++;
}
Z[i]=R-L;
R--;
System.out.println("heloooooooooooooooo");
}
}
}
System.out.println("heloooooooooooooooo");
}