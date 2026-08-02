public class solution {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                int area = Math.min(height[left], height[right]) * (right - left);
                maxArea = Math.max(maxArea, area);
                if (height[left] < height[right]) // 这里为什么要比较height[left] < height[right]，因为要找到面积最大的两个值，所以要移动高度较小的那个指针
                // 但是面积是长宽乘积，长度变了，宽度也变了啊，所以要移动高度较小的那个指针，才能找到面积最大的两个值
                // 宽度减小了，长度增大了，这种情况下，面积可能会增大，所以要移动高度较小的那个指针
                {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
            return maxArea;
        }
    }
}
