class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //FBIP 2R
        //topological sort problem
        //DFS
    //     List<List<Integer>> graph = new ArrayList(numCourses);
    //     for (int i = 0; i < numCourses; i++)
    //         graph.add(new ArrayList());
    //     for (int i = 0; i < prerequisites.length; i++)
    //         graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    //     boolean[] visited = new boolean[numCourses];
    //     Stack<Integer> stack = new Stack();
    //     for (int i = 0; i < numCourses; i++)
    //         if (!dfs(graph, i, stack, visited, new boolean[numCourses]))  //use dfs to check graph valid and push to stack
    //             return new int[0];
    //     int index = 0;
    //     int[] result = new int[numCourses];
    //     while (!stack.isEmpty())
    //         result[index++] = stack.pop();
    //     return result;
    // }
    // private boolean dfs(List<List<Integer>> graph, int v, Stack<Integer> stack, boolean[] visited, boolean[] hasCycle){
    //     if (visited[v])     return true;
    //     if (hasCycle[v])    return false;
    //     hasCycle[v] = true;
    //     for (int u : graph.get(v))
    //         if (!dfs(graph, u, stack, visited, hasCycle))
    //             return false;
    //     visited[v] = true;
    //     stack.push(v);
    //     return true;
        
        //BFS
        if (numCourses == 0)    return null;
        int[] indegree = new int[numCourses], order = new int[numCourses];
        int index = 0;
        for (int i = 0; i < prerequisites.length; i++)
            indegree[prerequisites[i][0]]++;                    //indegree represents how many prerequisites needed
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){                              //add to order if has no prerequisites
                order[index++] = i;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){                               //courses do not need prerequisites
            int prerequisite = queue.remove();                  //already finished prerequisite
            for (int i = 0; i < prerequisites.length; i++){
                if (prerequisites[i][1] == prerequisite){
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0){
                        order[index++] = prerequisites[i][0];
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return index == numCourses ? order : new int[0];
    }
}