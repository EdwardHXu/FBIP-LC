class Solution {
    public int leastInterval(char[] tasks, int n) {
        //FBIP 3R
        //use greedy approach to find the maxCountTask and then find the idleSlot so use map and sort them out first
        if (tasks == null || tasks.length == 0) return 0;
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int maxTask = map[25] - 1;                      //subtract 1 means last task in maxTask needs no idleSlot
        int idle = maxTask * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--)     //decrease i until map[i] == 0
            idle -= Math.min(map[i], maxTask);          //since map[25]-1 can be less than map[24]
        return idle > 0 ? tasks.length + idle : tasks.length;
    }
}