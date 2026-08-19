import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度数组，用于记录每门课程的入度
        int[] inDegree = new int[numCourses];
        // 邻接表，存储每门课程的后续课程
        List<List<Integer>> adjList = new ArrayList<>(); // 此时 adjList 是一个空的 ArrayList，没有空间存储元素，
        // 相当于adjList = [ ]，啥也没有，连元素的概念都没有，其实就是先提出一个框架概念
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>()); // 初始化 adjList，这时候有元素的概念了，
            // 只不过每个元素都是一个空的 ArrayList，相当于adjList = [ [], [], [], ... ]
            // 元素里面啥也没有，只是占位符
            // 不过有重要作用：既撑起外壳长度，又保证每个格子指向真实可用的空列表。保证.get(preCourse) 和.add(course) 两个方法的正常运行。
        }

        // 计算每门课程的入度，并构建邻接表
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            inDegree[course]++;
            adjList.get(preCourse).add(course); // .get(preCourse) 是获取前修课程的后续课程列表，.add(course) 是将当前课程添加到后续课程列表中
        }

        // 存储入度为 0 的课程的队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) { // inDegree[i] 是课程 i 的入度数值，入度为 0 表示没有前修课程
                queue.offer(i); // 注意这里offer的是课程编号，不应该是offer.(inDegree[i])
            }
        }

        // 记录已完成课程的数量
        int count = 0;
        while (!queue.isEmpty()) {
            int selectedCourse = queue.poll(); // .poll() 是从队列中取出一个元素
            count++;
            // 获取当前课程的后续课程列表
            List<Integer> nextCourses = adjList.get(selectedCourse);
            for (int nextCourse : nextCourses) {
                // 后续课程的入度减 1
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse); // 注意这里offer的是课程编号，不应该是offer.(inDegree[nextCourse])
                }
            }
        }

        // 如果已完成课程的数量等于总课程数，则可以完成所有课程
        return count == numCourses;
    }
}