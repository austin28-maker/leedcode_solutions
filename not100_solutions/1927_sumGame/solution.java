class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int[] left = calc(num.substring(0, n / 2));
        int[] right = calc(num.substring(n / 2));
        int ql = left[0], sumL = left[1];
        int qr = right[0], sumR = right[1];
        return (ql + qr) % 2 > 0 || (ql - qr) / 2 * 9 != sumR - sumL;
    }

    private int[] calc(String s) {
        int q = 0;
        int sum = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '?') {
                q++;
            } else {
                sum += ch - '0';
            }
        }
        return new int[]{q, sum};
    }
}