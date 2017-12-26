class MedianFinder {
    //FBIP 3R
    //maintain two heaps: Max-heap has smaller half number and Min-heap has larger half number
    //check if two heaps have the same size. If they do, we should return the average of the two top values of heaps.
    //Otherwise also balancing less than one more element into max-heap
    PriorityQueue<Integer> min = new PriorityQueue();                               //element sorted less to greater
    PriorityQueue<Integer> max = new PriorityQueue(Collections.reverseOrder());     //element sorted greater to less
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size())
            max.offer(min.poll());          //always make sure max-heap is equal or one more elements than min-heap
    }
    
    public double findMedian() {
        if (max.size() == min.size())
            return (max.peek() + min.peek()) / 2.0;
        else
            return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */