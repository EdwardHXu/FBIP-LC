/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        //FBIP 3R
        //find the node of outdegree=0 in directed graph
        int candidate = 0;
        for (int i = 0; i < n; i++)
            if (knows(candidate, i))
                candidate = i;
        for (int i = 0; i < n; i++)
            if (!knows(i, candidate) || (knows(candidate, i) && i != candidate))
                return -1;
        return candidate;
    }
}
