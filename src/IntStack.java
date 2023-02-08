/*
 * Copyright (c) 2022 Ian Clement. All rights reserved.
 */

/**
 * Stack class for Programming IV
 *
 * @author Ian Clement
 */
public class IntStack {

    // Constants

    private static final int DEFAULT_CAPACITY = 100;

    // Fields

    // store the stack in the lower portion of an array
    private int[] elements;
    private int tos;

    // Constructors

    public IntStack() {
        this(DEFAULT_CAPACITY);
    }

    public IntStack(int capacity) {
        this.tos = -1;
        this.elements = new int[capacity];
    }

    // Methods

    /**
     * Add item to the top of the stack.
     * @param element item to be placed on the top of the stack.
     * @precondition The stack is not full.
     * @postcondition The item has been added to the top of the stack.
     */
    public void push(int element) {
        if(isFull())  // check precondition
            throw new StackOverflowException();
        elements[++tos] = element;
    }

    /**
     * Remove and return the item from the top of the stack.
     * @return the item that was at the top of the stack.
     * @precondition The stack is not empty.
     * @postcondition The topmost item has been removed from the stack.
     */
    public int pop() {
        if(isEmpty()) // check precondition
            throw new StackUnderflowException();

        // pop the element.
        return elements[tos--];
    }

    /**
     * Get the item from the top of the stack.
     * @return the item at the top of the stack.
     * @precondition The stack is not empty.
    */
    public int top() {
        if(isEmpty()) // check precondition
            throw new StackUnderflowException();
        return elements[tos];
    }

    /**
     * Test whether the stack is empty.
     * @return true if the stack is empty, false otherwise.
     * @precondition None.
     */
    public boolean isEmpty() {
        return tos == -1;
    }

    /**
     * Test whether the stack is full.
     * @return true if the stack is full, false otherwise.
     * @precondition None.
     */
    public boolean isFull() {
        return tos == elements.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean first = true;
        for(int i = 0; i <= tos; i++) {
            if (first)
                first = false;
            else
                sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append("] <-- TOP");
        return sb.toString();
    }
}
