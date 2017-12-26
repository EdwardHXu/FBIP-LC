class Solution {
    public String decodeString(String s) {
        //FBIP 2R
        //maintain two stack as numStack and strStack
        String result = "";
        if (s == null || s.length() == 0)   return result;
        Stack<Integer> numStack = new Stack();
        Stack<String> strStack = new Stack();
        int index = 0;
        while (index < s.length()){
            if (Character.isDigit(s.charAt(index))){    //push number into numStack. mind number may be greater than 10
                int num = 0;
                while (Character.isDigit(s.charAt(index))){
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                numStack.push(num);
            }
            else if (s.charAt(index) == '['){           //push result into strStack to repeat it after and set result to ""
                strStack.push(result);
                result = "";
                index++;
            }
            else if (s.charAt(index) == ']'){           //append top of strStack and append repeated result as top of numStack
                StringBuilder sb = new StringBuilder(strStack.pop());
                int num = numStack.pop();
                for (int i = 0; i < num; i++)
                    sb.append(result);
                result = sb.toString();
                index++;
            }
            else 
                result += s.charAt(index++);
        }
        return result;
    }
}