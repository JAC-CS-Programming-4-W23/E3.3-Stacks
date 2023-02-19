public class IntStack {

    private int[] elements;
    private int top;

    public IntStack(int cap) {
        elements = new int[cap];
        top = -1;
    }

    public void push(int element) {
        if (isFull()) //(top == elements.length - 1)
            throw new StackOverflowException();
        elements[++top] = element;
    }

    public int pop() {
        if (isEmpty())  //(top == -1)
            throw new StackUnderflowException();
        return elements[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int top() {
        if (isEmpty())
            throw new StackUnderflowException();
        return elements[top];
    }

}
