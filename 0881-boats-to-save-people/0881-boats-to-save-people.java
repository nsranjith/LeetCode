class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int c=0;
        int i=0;
        int j=people.length-1;
        while(i<=j){
           int temp1=people[i];
           int temp2=people[j];
           int sum=temp1+temp2;
           if(sum==limit){
               i++;
               j--;
               c++;
           }else if(sum>limit){
               j--;
               c++;
           }else{
               i++;
               j--;
               c++;
           }
        }
        return c;
    }
}