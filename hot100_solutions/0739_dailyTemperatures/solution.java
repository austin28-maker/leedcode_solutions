class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];

        //从右向左遍历
        // 由于最后一个元素没有后续元素，从右开始遍历就是从索引值 length - 2 开始
        for (int i = length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break; // 注意一定要有跳出当前循环的操作，否则没有会一直循环下去，不能体现优化的目的了。
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break; // 同理
                }
            }
        }

        return result;
    }
}