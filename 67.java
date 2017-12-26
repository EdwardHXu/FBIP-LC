class Solution {
    public String addBinary(String a, String b) {
        //FBIP 3R
        //implement raw binary addition
        if (a == null || b == null)
            return a == null ? (b == null ? "" : b) : a;
        int indexA = a.length() - 1, indexB = b.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();
        while (indexA >= 0 || indexB >= 0){
            int sum = carry;
            if (indexA >= 0)    sum += a.charAt(indexA--) - '0';
            if (indexB >= 0)    sum += b.charAt(indexB--) - '0';
            result.append(sum % 2);         //add from less significant bit and append to sb, so need to reverse later
            carry = sum / 2;
        }
        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }
}