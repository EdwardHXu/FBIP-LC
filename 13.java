class Solution {
    private static final HashMap<Character, Integer> map = new HashMap();
    static{
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        //FBIP 2R
        //rules of roman to int is not that clear but first convert char in s to int according to alphabet
        if (s.length() == 0)    return 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (i + 1 < s.length() && map.get(s.charAt(i + 1)) > map.get(c)){
                result += map.get(s.charAt(i + 1)) - map.get(c);    //like IV is 4 = 5 - 1
                i++;                                                //need to increase i since dealed with 2 digits already
            } else 
                result += map.get(c);
        }
        return result;
    }
}