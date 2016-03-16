import java.util.Stack;

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> mins = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        mins.push((mins.isEmpty()) ? x : Math.min(mins.peek(), x));
    }

    public void pop() {
        stack.pop();
        mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}
