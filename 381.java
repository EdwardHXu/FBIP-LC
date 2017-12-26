class RandomizedCollection {
    //FBIP 2R follow-up question of 380
    //since duplicated element allowed here so has to use HashMap, the value is HashSet to record nums multiple indexs
    List<Integer> nums;
    HashMap<Integer, HashSet<Integer>> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exsits = map.containsKey(val);
        if (!exsits)    map.put(val, new HashSet());
        map.get(val).add(nums.size());      //always add element into nums as last element so the index always is nums.size()
        nums.add(val);
        return !exsits;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))  return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);     //remove from index HashSet
        if (index < nums.size() - 1){   //set the index element in nums list as last element and delete the last element
            int lastNum = nums.get(nums.size() - 1);
            nums.set(index, lastNum);
            map.get(lastNum).remove(nums.size() - 1);
            map.get(lastNum).add(index);
        }
        nums.remove(nums.size() - 1);
        if (map.get(val).isEmpty())
            map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */