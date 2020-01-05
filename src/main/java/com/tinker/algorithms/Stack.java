package com.tinker.algorithms;


/**
 * 栈的实现，可以 O(1)获取栈中元素的最小值；
 * O(1) 获取最小值，最小值栈与元素栈对应关系：
 * 截止到元素栈的某一个元素，最小值栈都存入的是最小值
 * 比如 元素栈 4，4，3，4，2，1，
 * 最小值栈：4，4，3，3，2，1
 * 那么弹出元素时，最小值栈跟随元素栈收缩：
 * 4，4，3，4
 * 4，4，3，3
 */
public class Stack {
    private int capacity;
    private int size;
    private int[] data;
    private int[] min;
    private int DEFAULT_CAPACITY = 1 << 8;
    private int tail;
    private int curMin;

    public Stack() {
        data = new int[DEFAULT_CAPACITY];
        min = new int[DEFAULT_CAPACITY];
        capacity = DEFAULT_CAPACITY;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        min = new int[capacity];
    }

    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception();
        }
        int res = data[tail--];
        size--;
        return res;
    }

    public void push(int val) throws Exception {
        if (size == 0) {
            curMin = val;
        }
        if (++size > capacity) {
            throw new Exception();
        }
        data[tail] = val;
        if (curMin > val) {
            curMin = val;
        }
        min[tail] = curMin;
        tail++;
    }

    public int min() {
        return min[tail];
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        try {
            stack.push(3);
            stack.push(2);
            stack.push(1);
            System.out.println(stack.min());
            System.out.println(stack.pop());
            System.out.println(stack.min());
        } catch (Exception e) {

        }
    }
}
