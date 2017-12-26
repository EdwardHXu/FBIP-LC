class RandomizedSet {
    //FBIP 2R
    //why simply implement with HashSet is incorrect? since cannot make sure getRandom in O(1) complexity (actually in O(n))
    //should use HashMap to operate the last element make to O(1), map stores num and index and update nums List at same time
    List<Integer> nums;
    HashMap<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))   return false;
        map.put(val, nums.size());
        nums.add(val);                      //mind that first put to map then expand list so index of last one is nums.size()-1
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))  return false;
        int index = map.get(val);
        if (index < nums.size() - 1){       // not the last one than swap the last one with this val
            int lastNum = nums.get(nums.size() - 1);
            nums.set(index, lastNum);
            map.put(lastNum, index);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */