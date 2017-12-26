class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        //FBIP 2R
        //may be the most difficult problem ever encountered
        //first sort critical points and scan from left to right of critical points
        //when encounter left edge of rectangle add it into heap with height as its key when encounter right edge remove it 
        //the key point of this algo is scan critical points instead of rectangle (scan rectangle with time complexity O(n^2))
        //while this approach only cost time complexity with O(n*logn)
        List<int[]> result = new ArrayList();
        List<int[]> height = new ArrayList();
        for (int[] b : buildings){
            height.add(new int[] {b[0], -b[2]});        //add left edge into height as negative 
            height.add(new int[] {b[1],  b[2]});        //add right edge into height as positive
        }
        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] != b[0])
                    return a[0] - b[0];
                else 
                    return a[1] - b[1];
            }
        });     //override sort function with sorting x position if x are same then sort y instead
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });     //initialize heap as pq in Java. sort them with y position (height)
        pq.add(0);
        int prev = 0;       //record last critical point height
        for (int[] h : height){
            if (h[1] < 0)
                pq.add(-h[1]);      //add left edge point into heap
            else 
                pq.remove(h[1]);    //remove right edge point from heap
            int curr = pq.peek();
            if (prev != curr){      //if new height is different from last critical point height, add new critical point
                result.add(new int[] {h[0], curr});
                prev = curr;
            }
        }
        return result;
    }
}