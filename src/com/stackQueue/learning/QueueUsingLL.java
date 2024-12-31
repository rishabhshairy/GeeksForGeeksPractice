package com.stackQueue.learning;

public class QueueUsingLL {
    static class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    QueueNode front, rear;

    //Function to push an element into the queue.
    void push(int a) {
        // Your code here
        QueueNode temp = new QueueNode(a);
        if (rear == null) {
            rear = front = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    //Function to pop front element from the queue.
    int pop() {
        // Your code here
        if (front == null) {
            return -1;
        }

        int val = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return val;
    }
}
