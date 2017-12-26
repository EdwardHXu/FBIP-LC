/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] cache = new char[4];
    int count = 0, index = -1;
    boolean EOF = false;           //since read() can be called many times, these variable must define here
    public int read(char[] buf, int n) {
        //FBIP 3R
        //the difference between this probelm and 157 is that read can be called more than once
        int total = 0;
        while (total < n){
            if (index == -1){
                if (EOF)    break;
                count = read4(cache);
                EOF = count < 4;
                index = 0;      //index = -1 means have not cache from read4 which index = 0 means have cached
            }
            else {
                if (index == count) index = -1;
                else    buf[total++] = cache[index++];
            }
        }
        return total;
    }
}
