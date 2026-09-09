import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            // 把 s 排序，作为哈希表的 key
            char[] sortedS = s.toCharArray();
            Arrays.sort(sortedS);
            // 排序后相同的字符串，保存到同一组中
            // computeIfAbsent：如果 key 不在哈希表中，则插入一个新的 ArrayList
            m.computeIfAbsent(new String(sortedS), _ -> new ArrayList<>()).add(s);
        }
        // 哈希表的所有 value 就是分组结果
        return new ArrayList<>(m.values()); 
    }
}