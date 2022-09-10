package com.test.test;

public class MyStack {
    int[] arr;
    int top = -1;

    MyStack(int size){
        arr = new int[size];
    }

    public void push(int data){
        ++top;
        if (isStackOverflow()) {
            System.out.println("Stack Overflow");
            System.exit(0);
        }
        else {
            arr[top] = data;
            System.out.println("Pushed "+ data);
        }
    }

    public int pop(){
        int popData = 0;
        if (isEmpty()) {
            System.out.println("Stack Empty");
            System.exit(0);
        }
        else {
            popData = arr[top];
            --top;
            System.out.println("Popped "+ popData);
        }
        return popData;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isStackOverflow(){
        return top == arr.length;
    }

    public static void main(String[] args) {
        MyStack ms = new MyStack(5);
        ms.push(10);
        ms.push(20);
        ms.push(30);
        ms.push(40);
        ms.push(50);
        ms.pop();
        ms.pop();
        ms.pop();
    }

}
