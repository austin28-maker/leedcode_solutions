public class solution {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);// sort方法可以对数组进行排序，返回值为 void，排序是升序排序
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;   
                }
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));// .asList() 方法可以将多个参数转换为一个 List 对象
                        // add() 方法可以将一个元素添加到 List 中，返回值为 boolean
                        left += 1;
                        right -= 1;
                        while (left < right && nums[left] == nums[left - 1]) {
                            // 为什么left < right？因为要跳过所有重复的元素，而不是跳过一个元素
                            // 如果left >= right，说明已经遍历完了所有元素，所以要跳出循环
                            // 为什么用while循环，而不是if语句？因为要跳过所有重复的元素，而不是跳过一个元素
                            left += 1;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right -= 1;
                        }
                    } else if (sum < 0) {
                        left += 1;
                    } else {
                        right -= 1;
                    }
                }
            }
        }
    }
}
