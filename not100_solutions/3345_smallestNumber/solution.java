/**
 * 给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除
 */

public class Solution {
    public int smallestNumber(int n, int t) {
        int res = n;
        while (true) {
            int product = 1;
            int temp = res;
            while (temp > 0) {
                product *= temp % 10;// 取temp的个位数
                // 然后将temp除以10，得到temp的十位数
                // 以此类推，直到temp为0
                temp /= 10;
            }
            if (product % t == 0) {
                return res;
            }
            res++;
        }
    }
}
