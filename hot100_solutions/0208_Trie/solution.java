// // 写法一：
// class Trie {
//     class TireNode {
//         private boolean isEnd;
//         TireNode[] next;

//         public TireNode() {
//             isEnd = false;
//             next = new TireNode[26];
//         }
//     }

//     private TireNode root;

//     public Trie() {
//         root = new TireNode();
//     }

//     public void insert(String word) {
//         TireNode node = root;
//         for (char c : word.toCharArray()) {
//             if (node.next[c - 'a'] == null) {
//                 node.next[c - 'a'] = new TireNode();
//             }
//             node = node.next[c - 'a'];
//         }
//         node.isEnd = true;
//     }

//     public boolean search(String word) {
//         TireNode node = root;
//         for (char c : word.toCharArray()) {
//             node = node.next[c - 'a'];
//             if (node == null) {
//                 return false;
//             }
//         }
//         return node.isEnd;
//     }

//     public boolean startsWith(String prefix) {
//         TireNode node = root;
//         for (char c : prefix.toCharArray()) {
//             node = node.next[c - 'a'];
//             if (node == null) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// 写法二：
class Trie {
    private static class Node {
        Node[] son = new Node[26];
        boolean end = false;
    }

    private final Node root = new Node();

    public Trie() {
        
    }
    
    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        return find(word) == 2;
    }
    
    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word){
        Node cur = root;
        for(char c : word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                return 0;
            }
            cur = cur.son[c];
        }
        return cur.end ? 2 : 1;
    }
}

// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */