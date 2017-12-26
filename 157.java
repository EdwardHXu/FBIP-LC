/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        //FBIP 3R
        int total = 0;
        char[] temp = new char[4];
        boolean EOF = false;
        while (!EOF && total < n){
            int count = read4(temp);
            EOF = count < 4;
            count = Math.min(count, n - total);
            for (int i = 0; i < count; i++)
                buf[total++] = temp[i];
        }
        return total;
    }
}