class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        //FBIP 2R
        //use HashMap to store bricks position and occurrence. find the max occurrence and that's the least crossing line
        if (wall == null)   return 0;
        int maxCommonPos = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (List<Integer> list : wall){
            int position = 0;
            for (int i = 0; i < list.size() - 1; i++){      //cannot record to list.size() since all bricks end there so 0 break
                position += list.get(i);
                map.put(position, map.getOrDefault(position, 0) + 1);
                maxCommonPos = Math.max(maxCommonPos, map.get(position));
            }
        }
        return wall.size() - maxCommonPos;
    }
}