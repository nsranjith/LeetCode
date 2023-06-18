class Solution {
  Map<Pair<Integer, Integer>, Long> map = new HashMap<>();    
  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
      Arrays.sort(arr2);
      int temp[]=new int[arr1.length+1];
      temp[0]=-1;
      for(int i=1;i<temp.length;i++){
        temp[i]=arr1[i-1];
      }
      int val=(int)helper(temp,arr2,1,-1);
      return val==Integer.MAX_VALUE?-1:val;
    }
    private long helper(int[] arr1, int[] arr2, int curr, int prev){
      if(curr>=arr1.length) return 0; 
      long cost=Integer.MAX_VALUE;

      if(map.containsKey(new Pair<>(curr,prev))){
        return map.get(new Pair<>(curr,prev));
      }

      if(arr1[curr]>prev){
        cost=helper(arr1,arr2,curr+1,arr1[curr]); //skip
        int index=replace(arr2,prev);//change
        if(index<arr2.length)
            cost=Math.min(cost,1+helper(arr1,arr2,curr+1,arr2[index]));
      }else{
        int index=replace(arr2,prev);//change
        if(index<arr2.length)
            cost=Math.min(cost,1+helper(arr1,arr2,curr+1,arr2[index])); 
      }
      map.put(new Pair<>(curr,prev),cost);
      return cost;
    }

private int replace(int[] arr, int value) {
      int left = 0, right = arr.length-1;
      int ans=arr.length;
      while (left <=right) {
          int mid = (left + right) / 2;
          if (arr[mid] <= value) {
              left = mid + 1;
          } else {
              ans=mid;
              right = mid-1;
          }
      }
      return ans;
    } 
}