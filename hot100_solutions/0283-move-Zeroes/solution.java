public class solution {
    class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int num : nums) {
                if (num != 0) {
                    nums[index] = num;
                    index += 1;
                }
            }
            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
