class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        //FBIP 2R
        //maintain a stack to store log id and record prev timestamp of the same id, use Integer.parseInt to get time interval
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        int prev = 0;
        for (String log : logs){
            String[] part = log.split(":");
            if (!stack.isEmpty())       //to deal with current task during time when encounter switching tasks
                result[stack.peek()] += Integer.parseInt(part[2]) - prev;
            prev = Integer.parseInt(part[2]);
            if (part[1].equals("start"))
                stack.push(Integer.parseInt(part[0]));
            else {                      //if log is end then increase current logID lasting time by 1 and prev time by 1
                result[stack.pop()]++;
                prev++;
            }
        }
        return result;
    }
}