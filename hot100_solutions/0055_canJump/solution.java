class Solution {
    public boolean canJump(int[] nums) {
        int mx = 0; // mx 记录从起点出发、目前所有位置能触达的最远下标
        for(int i = 0; i < nums.length; i++){
            if(i > mx){
                return false;
            }
            mx = Math.max(mx, i + nums[i]);
        }
        return true;
    }
}

// // 方法二 : 提前退出循环
// class Solution {
//     public boolean canJump(int[] nums) {
//         int mx = 0;
//         for(int i = 0; mx < nums.length - 1; i++){
//             if(i > mx){
//                 return false;
//             }
//             mx = Math.max(mx, i + nums[i]);
//         }
//         return true;
//     }
// }