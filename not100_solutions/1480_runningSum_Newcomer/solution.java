/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 */

class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}

/**
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 */
class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            res++;
        }
        return res;
    }
}

/**
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户
 */

class Solution {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > res) {
                res = sum;
            }
        }
        return res;
    }
}
/**
 * 给你一个整数 n ，返回一个字符串数组 answer（下标从 1 开始），其中：

answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
answer[i] == "Fizz" 如果 i 是 3 的倍数。
answer[i] == "Buzz" 如果 i 是 5 的倍数。
answer[i] == i （以字符串形式）如果上述条件全不满足。
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");// add() 方法将元素添加到列表的末尾
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            res[magazine.charAt(i) - 'a']++;// 记录 magazine 中每个字符出现的次数
            // charAt() 方法返回字符串中指定索引的字符，索引从 0 开始
            // 'a' 是字符 'a' 的 ASCII 码，'a' - 'a' = 0
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            res[ransomNote.charAt(i) - 'a']--;// 原理是什么？
            // 这是在res的基础上进行减法操作，减去的值是 ransomNote 中每个字符出现的次数
            // 1. 先将 ransomNote 中的每个字符转换为 ASCII 码，再减去 'a' 的 ASCII 码，得到字符在 res 数组中的索引
            // 2. 将 res 数组中对应索引的元素减 1，表示使用了一个字符
        }
        for (int i = 0; i < 26; i++) {
            if (res[i] < 0) {// 为什么 res 数组中元素小于 0 时，说明 ransomNote 中有字符在 magazine 中没有
                // 因为 res 数组中每个元素表示 magazine 中每个字符出现的次数，所以如果 res 数组中元素小于 0，说明 ransomNote 中有字符在 magazine 中没有出现
                return false;
            }
        }
        return true;
    }
}
