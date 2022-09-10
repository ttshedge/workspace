package com.test.test;

import java.util.LinkedList;

class Node{
    int data;
    Node next;
}

class MyLinkedList{

    Node head;
    Node tail;

    public void add(int i){
        Node n = new Node();
        n.data = i;
        n.next = null;
        if (head == null){
            head = n;
            tail = n;
        }else {
            tail.next = n;
            tail = n;
        }
    }

    public void remove(int i){
        Node n = head;
        if (n.data == i){
            head = n.next;
            n = null;
        }else {
            while (n.next.data != i && n.next != null) {
                n = n.next;
            }
            System.out.println("Element Removed");
            if(n.next.next == null){
                n.next = null;
                tail = n;
            }else {
                Node temp = n.next;
                n.next = n.next.next;
                temp = null;
            }
        }
    }

    @Override
    public String toString() {
        Node n = head;
        String op = "";
        while (n != null){
            op+="==>"+n.data;
            n = n.next;
        }
        return op;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.add(10);
        mll.add(20);
        mll.add(30);
        mll.add(40);
        mll.add(50);
        mll.remove(50);
        mll.remove(30);
        System.out.println(mll.toString());
    }

}
