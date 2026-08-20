import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        a.add(nums[0]);
        b.add(nums[1]);
        for(int i = 2; i < n; i++){
            if(a.get(a.size() - 1) > b.get(b.size() - 1)){
                a.add(nums[i]);
            }else{
                b.add(nums[i]);
            }
        }
        a.addAll(b); // .addAll() 方法将 b 中的元素添加到 a 中
        for(int i = 0; i < n; i++){
            nums[i] = a.get(i);
        }
        return nums;
    }
}