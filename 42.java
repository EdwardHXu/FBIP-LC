class Solution {
    public int trap(int[] height) {
        //FBIP 2R
        //using DP with two pointer from solution
        int left  = 0, right = height.length - 1, leftMax = 0, rightMax = 0, result = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= leftMax)    leftMax = height[left];
                else result += leftMax - height[left];
                left++;
            }
            else {
                if (height[right] >= rightMax)  rightMax = height[right];
                else result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
