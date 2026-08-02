public class solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        // 初始化数组的长度为26，因为只有26个字母，每个字母的出现次数都为0
        int[] pCount = new int[26];// 记录p中每个字符的出现次数
        int[] sCount = new int[26];// 记录s中每个字符的出现次数

        for (int i = 0; i < p.length(); i++) {
            // .charAt()方法可以获取字符串s的第i个字符，返回值为char类型
            // 例如，'a'的ASCII码为97，'b'的ASCII码为98，'c'的ASCII码为99，以此类推
            pCount[p.charAt(i) - 'a']++;// 为什么写这句话？因为p中每个字符的ASCII码减去'a'的ASCII码，就是字符在数组中的索引位置
            // 记录每个字符的出现次数，初始值为0，每次出现一次，就加1
        }
        for (int i = 0; i < p.length(); i++) {
            // 注意这里是p.length()，不是s.length()
            // 同理，记录s中每个字符的出现次数
            sCount[s.charAt(i) - 'a']++;
        }
        // 最后，判断pCount和sCount是否相等，相等说明s中从i开始的子字符串是p的异位词，将i加入到结果列表中
        // 窗口从左到右滑动，每次滑动一个字符，窗口大小为p的长度
        // 窗口滑动时，需要更新字符计数，将窗口外的字符出现次数减1，将窗口内的字符出现次数加1
        // 为什么s.length() - p.length()？因为窗口大小为p的长度，所以窗口的右边界为s.length() - p.length() + 1
        for (int i = 0; i <= s.length() - p.length(); i++) {
            // 这里i的范围划定在[0, s.length() - p.length() - 1]，是为了保证最后一个窗口的右边界是s.length() - 1
            if (Arrays.equals(pCount, sCount)) {
                res.add(i);
            }
            if (i < s.length() - p.length()) {
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + p.length()) - 'a']++;
            }
        }
        return res;
    }
}
