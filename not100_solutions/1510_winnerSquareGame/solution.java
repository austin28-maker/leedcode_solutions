/**
 * Alice 和 Bob 两个人轮流玩一个游戏，Alice 先手。

一开始，有 n 个石子堆在一起。每个人轮流操作，正在操作的玩家可以从石子堆里拿走 任意 非零 平方数 个石子。

如果石子堆里没有石子了，则无法操作的玩家输掉游戏。

给你正整数 n ，且已知两个人都采取最优策略。如果 Alice 会赢得比赛，那么返回 True ，否则返回 False 。
 */

class Solution {
        public boolean winnerSquareGame(int n) {
            // 动态规划，计算n-i*i的情况
            boolean[] state = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                int sqrt = (int) Math.sqrt(i);
                if (sqrt * sqrt == i) {
                    // 当前石子数是平方数，稳赢
                    state[i] = true;
                } else {
                    // 当前石子数不是平方数，拿掉i*i个后如果自己之前是输的，那Bob按这个拿法肯定输，Alice就赢了
                    for (int j = 1; j * j < i; j++) {
                        if (state[i - j * j] == false) {
                            state[i] = true;
                            break;
                        }
                    }
                }
            }
            return state[n];
        }
    }