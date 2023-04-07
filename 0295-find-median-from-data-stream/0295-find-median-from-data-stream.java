class MedianFinder {
    PriorityQueue<Integer> max=new PriorityQueue<Integer>((a,b)->b-a); // left array
    PriorityQueue<Integer> min=new PriorityQueue<Integer>(); //right array
    /*
        left array should be less than right
        and use max heap to store min elements and min heap to store max
        because for ex:
        1 2 3
        
        2 1  <=  3  all elements are lesser and meadian is max.pop()+min.pop()/2
        
        we cannot implement this if we treat min and max otherwise
    */
    public MedianFinder() {
        
    }
    public void addNum(int num) {
        max.add(num);
        if(max.size()>0 && min.size()>0 && max.peek()>min.peek()){
            min.add(max.poll());
        }
        int diff=Math.abs(max.size()-min.size());
        if(diff>1){
            if(max.size()>min.size()){
                min.add(max.poll());
            }else{
                max.add(min.poll());
            }
        }
    }
    /*
         1 2
         3 4  

         1

         1 
         2 3 4

         1 2

         3 4

   max= 2    
   min= 3 4




    */
    public double findMedian() {

       int temp=min.size()+max.size();
       if(temp%2==0){
           return (max.peek()+min.peek())/2.0;
       }else{
           if(min.size()>max.size()){
               return min.peek();
           }else{
               return max.peek();
           }
       }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */