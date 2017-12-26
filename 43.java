class Solution {
    public String multiply(String num1, String num2) {
        //FBIP 3R
        //math problem impelment multiply. bit manipulation
        //consider nums as array, num1[i] * num2[j] result will be placed at index [i + j, i + j + 1] index from left to right
        int m = num1.length(), n = num2.length();
        int nums[] = new int[m + n];
        for (int i = m - 1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1; //num1[i] and num2[j] are added into index i+j and i+j+1 use two pointers record
                int sum = mul+ nums[p2];
                nums[p1] += sum / 10;
                nums[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
            if (sb.length() != 0 || num != 0)
                sb.append(num);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
