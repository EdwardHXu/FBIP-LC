class Solution {
    public String convertToTitle(int n) {
        //convert num into 26based alphabet. the other version is even easier: just result = result * 26 + (s.charAt(i)-'A'+1)
        StringBuilder result = new StringBuilder();
        while (n > 0){
            n--;
            result.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return result.reverse().toString();
    }
}