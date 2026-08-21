## 解题思路

- 回溯思想
- 剪枝一：若子集和超过 target ，则直接结束循环
- 剪枝二：从 start 开始遍历，避免生成重复子集
    - 重点理解：为什么从 start 开始遍历，避免生成重复子集？

## 知识点

- 

## 注意事项

- 理解res.add(new ArrayList<>(state)) 做的事
    - 给 state 拍一张“快照”，把快照存进结果。
    - 如果不 new 直接存 state 本身，res 里所有条目最后都会变成空列表。
    - 17题的`res.add(sb.toString());// 注意其他题目res如果是列表，加入的时候需要new新的列表，否则最后一定被回溯到空列表`同理
    - 举例：
    ```
    import java.util.ArrayList;
    import java.util.List;

    public class Demo {
        public static void main(String[] args) {
            // ═══════════ 实验 1：直接 add（不 new）═══════════
            List<Integer> state = new ArrayList<>();
            List<List<Integer>> res1 = new ArrayList<>();

            state.add(2);
            state.add(2);
            state.add(3);
            res1.add(state);            // ✗ 存引用（直播摄像头）

            state.remove(state.size() - 1);   // 回溯：删 3
            state.remove(state.size() - 1);   // 回溯：删 2
            state.remove(state.size() - 1);   // 回溯：删 2

            System.out.println("实验1 res = " + res1);
            // 输出: 实验1 res = [[]]     ← 空列表！state 被删空，res 里的引用同步变空

            // ═══════════ 实验 2：new 拷贝后 add ═══════════
            List<Integer> state2 = new ArrayList<>();
            List<List<Integer>> res2 = new ArrayList<>();

            state2.add(2);
            state2.add(2);
            state2.add(3);
            res2.add(new ArrayList<>(state2));   // ✓ 拍快照（照片）

            state2.remove(state2.size() - 1);
            state2.remove(state2.size() - 1);
            state2.remove(state2.size() - 1);

            System.out.println("实验2 res = " + res2);
            // 输出: 实验2 res = [[2, 2, 3]]  ← 完好保存！
        }
    }
    ```

    - 实验1内存图：
    ```
    res1.add(state) 之后:

        res1 ──→ [ 引用 ]
                │
                └──→ state ──→ [2, 2, 3]      ← res1[0] 和 state 指向同一个对象！

    回溯删掉 3:      state ──→ [2, 2]           ← res1"里面"也跟着变了
    回溯删掉 2:      state ──→ [2]
    回溯删掉 2:      state ──→ []                ← res1[0] 现在是空列表

    递归结束:  state == res1[0]，同一对象，内容 = []
    ```

    - 实验2内存图：
    ``` 
    res2.add(new ArrayList<>(state2)) 之后:

        res2 ──→ [ 引用 ]
                │
                └──→ 新对象 [2, 2, 3]     ← 独立副本，拷贝构造时定格

        state2 ──→ [2, 2, 3]                ← 原列表，和副本各过各的

    回溯删掉 3:      state2 ──→ [2, 2]      ← 副本纹丝不动
    回溯删掉 2:      state2 ──→ [2]
    回溯删掉 2:      state2 ──→ []          ← 原列表清空，副本还是 [2,2,3]

    递归结束:  res2 = [ [2,2,3] ]   ✓
    ```