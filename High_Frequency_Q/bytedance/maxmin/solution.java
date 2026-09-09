package High_Frequency_Q.bytedance.maxmin;

import java.util.Arrays;

/**
 * 字节高频面试题：用数字集合 A 中的数字，组成小于 n 的最大数
 *
 * 示例：n = 23121, A = {2, 4, 9} -> 22999
 *
 * 核心思路：贪心 + 回溯（基于 n 的十进制字符串）
 * 1. 同位数尝试：从左到右逐位贪心选 A 中 <= n 当前位的最大数字；
 *    某位一旦严格小于 n，后面各位不再受限，直接填最大数字。
 * 2. 回溯缩小：若某位无数字可选、或构造结果恰好等于 n，
 *    从右往左找最近一个"能换更小数字"的位置，缩小后其余位填最大数字。
 * 3. 退一位：回溯彻底失败，改用 L-1 位、全部填最大数字。
 *
 * 时间复杂度：O(L * |A|)，L 为 n 的位数（|A| <= 10，视为常数）
 * 空间复杂度：O(L)，存储构造中的数字串
 */
public class solution {

    /**
     * 返回由 digitSet 中数字组成的小于 n 的最大数；不存在则返回 -1。
     * 题目约定 n 为正整数，digitSet 中均为 0~9 的数字。
     */
    public long maxLessThanN(long n, int[] digitSet) {
        if (digitSet == null || digitSet.length == 0) {
            return -1; // 边界：数字集合为空，无解
        }
        int[] digits = digitSet.clone();
        Arrays.sort(digits);
        int maxDigit = digits[digits.length - 1];

        String s = Long.toString(n);
        int len = s.length();

        // ---- 阶段一：同位数贪心构造 ----
        // prefix 保存已确定的各位数字；未提前返回时，每一位都与 n 对应位"相等"
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (i < len) {
            int cur = s.charAt(i) - '0';
            int d = maxDigitAtMost(digits, cur);
            if (d < 0) {
                break; // 没有数字 <= cur 可选，转入回溯
            }
            prefix.append((char) ('0' + d));
            if (d < cur) {
                // 当前位已严格小于 n，剩余各位直接填最大数字
                return Long.parseLong(prefix + repeatDigit(maxDigit, len - i - 1));
            }
            i++;
        }

        // ---- 阶段二：回溯缩小 ----
        // 从右往左找最近一个能换更小数字的位置
        String fixed = prefix.toString();
        for (int j = fixed.length() - 1; j >= 0; j--) {
            int d = maxDigitBelow(digits, fixed.charAt(j) - '0');
            if (d >= 0) {
                // 保留前 j 位，第 j 位缩小，剩余各位填最大数字
                String head = fixed.substring(0, j) + (char) ('0' + d);
                return Long.parseLong(head + repeatDigit(maxDigit, len - j - 1));
            }
        }

        // ---- 阶段三：退一位 ----
        if (len - 1 == 0) {
            return -1; // n 只有 1 位且回溯失败，无解
        }
        return Long.parseLong(repeatDigit(maxDigit, len - 1));
    }

    /** digits 中 <= c 的最大数字；不存在返回 -1 */
    private int maxDigitAtMost(int[] digits, int c) {
        int best = -1;
        for (int d : digits) {
            if (d <= c && d > best) {
                best = d;
            }
        }
        return best;
    }

    /** digits 中严格小于 c 的最大数字；不存在返回 -1 */
    private int maxDigitBelow(int[] digits, int c) {
        int best = -1;
        for (int d : digits) {
            if (d < c && d > best) {
                best = d;
            }
        }
        return best;
    }

    /** 将数字 d 重复 count 次组成字符串，如 repeatDigit(9, 3) -> "999" */
    private String repeatDigit(int d, int count) {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < count; k++) {
            sb.append((char) ('0' + d));
        }
        return sb.toString();
    }
}
