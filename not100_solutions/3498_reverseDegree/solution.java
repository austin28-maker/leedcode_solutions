class Solution {
    public int reverseDegree(String s) {
        int sum = 0, ans = 1;
        int[] c = new int[26];
        char[] words = s.toCharArray();
        for(char word : words){
            int i = word - 'a';
            c[i] = 26 - i;
        }
        for(int i = 0; i < words.length; i++){
            int j = c[s.charAt(i) - 'a'];
            ans = (i + 1) * j;
            sum += ans;
        }
        return sum;
    }
}