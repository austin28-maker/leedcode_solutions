class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        // 第一阶段：快慢指针找相遇点（必须用 do-while，因为初始都在0）
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 第二阶段：同速指针找入口
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
}

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int slow = 0;
//         int fast = 0;
//         slow = nums[slow];
//         fast = nums[nums[fast]];
//         while(slow != fast){
//             slow = nums[slow];
//             fast = nums[nums[fast]];
//         }
//         int pre1 = 0;
//         int pre2 = slow;
//         while(pre1 != pre2){
//             pre1 = nums[pre1];
//             pre2 = nums[pre2];
//         }
//         return pre1;
//     }
// }