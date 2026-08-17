import java.util.Deque;
import java.util.ArrayDeque;

class MinStack {
    private Deque<Integer> deque;
    private Deque<Integer> min_deque;

    public MinStack() {
        deque = new ArrayDeque<>();
        min_deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.push(x);
        if (min_deque.isEmpty() || x <= min_deque.peek()) {
            min_deque.push(x);
        }
    }

    public void pop() {
        if (deque.pop().equals(min_deque.peek())) {
            min_deque.pop();
        }
    }

    public int top() {
        return deque.peek();
    }

    public int getMin() {
        return min_deque.peek();
    }
}