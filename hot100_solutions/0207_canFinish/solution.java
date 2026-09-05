import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

// 方法一：通过有向图的入度概念判断
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         // 入度数组，用于记录每门课程的入度
//         int[] inDegree = new int[numCourses];
//         // 邻接表，存储每门课程的后续课程
//         List<List<Integer>> adjList = new ArrayList<>(); // 此时 adjList 是一个空的 ArrayList，没有空间存储元素，
//         // 相当于adjList = [ ]，啥也没有，连元素的概念都没有，其实就是先提出一个框架概念
//         for (int i = 0; i < numCourses; i++) {
//             adjList.add(new ArrayList<>()); // 初始化 adjList，这时候有元素的概念了，
//             // 只不过每个元素都是一个空的 ArrayList，相当于adjList = [ [], [], [], ... ]
//             // 元素里面啥也没有，只是占位符
//             // 不过有重要作用：既撑起外壳长度，又保证每个格子指向真实可用的空列表。保证.get(preCourse) 和.add(course) 两个方法的正常运行。
//         }

//         // 计算每门课程的入度，并构建邻接表
//         for (int[] prerequisite : prerequisites) {
//             int course = prerequisite[0];
//             int preCourse = prerequisite[1];
//             inDegree[course]++;
//             adjList.get(preCourse).add(course); // .get(preCourse) 是获取前修课程的后续课程列表，.add(course) 是将当前课程添加到后续课程列表中
//         }

//         // 存储入度为 0 的课程的队列
//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < numCourses; i++) {
//             if (inDegree[i] == 0) { // inDegree[i] 是课程 i 的入度数值，入度为 0 表示没有前修课程
//                 queue.offer(i); // 注意这里offer的是课程编号，不应该是offer.(inDegree[i])
//             }
//         }

//         // 记录已完成课程的数量
//         int count = 0;
//         while (!queue.isEmpty()) {
//             int selectedCourse = queue.poll(); // .poll() 是从队列中取出一个元素
//             count++;
//             // 获取当前课程的后续课程列表
//             List<Integer> nextCourses = adjList.get(selectedCourse);
//             for (int nextCourse : nextCourses) {
//                 // 后续课程的入度减 1
//                 inDegree[nextCourse]--;
//                 if (inDegree[nextCourse] == 0) {
//                     queue.offer(nextCourse); // 注意这里offer的是课程编号，不应该是offer.(inDegree[nextCourse])
//                 }
//             }
//         }

//         // 如果已完成课程的数量等于总课程数，则可以完成所有课程
//         return count == numCourses;
//     }
// }

// 方法二：有向图中是否有环
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses]; // 邻接表，存储每门课程的后续课程，ArrayList[numCourses]表示有 numCourses 个元素的 ArrayList 数组
        Arrays.setAll(g, i -> new ArrayList<>());  // 初始化邻接表，每个元素都是一个空的 ArrayList
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
        }

        int[] colors = new int[numCourses]; // 0：未访问，1：访问中，2：已访问
        Arrays.fill(colors, 0); // 初始化 colors 数组，所有元素都设为 0，表示未访问
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) { // 如果课程 i 未访问过，且从课程 i 出发有环
                // 则课程 i 以及后续课程都不能完成
                return false; // 有环
            }
        }
        return true; // 没有环
    }

    // 返回 true 表示找到了环
    private boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1; // x 正在访问中
        for (int y : g[x]) { // g[x] 是课程 x 的后续课程列表
            // 情况一：colors[y] == 1，表示发生循环依赖，找到了环
            // 情况二：colors[y] == 0，没有访问过 y，继续递归 y 获取信息
            // 情况三：colors[y] == 2，重复访问 y 只会重蹈覆辙，和之前一样无法找到环，跳过
            if (colors[y] == 1 || colors[y] == 0 && dfs(y, g, colors)) {
                return true; // 找到了环
            }
        }
        colors[x] = 2; // x 完全访问完毕，从 x 出发无法找到环
        return false; // 没有找到环
    }
}