class Solution {
    public int hIndex(int[] citations) {
        //FBIP 2R
        //sort citations first and find h-index
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int h = 0;
        while (h < citations.length && citations[citations.length - 1 - h] > h)
            h++;        //just increase h until h papers have at least h citations
        return h;
    }
}