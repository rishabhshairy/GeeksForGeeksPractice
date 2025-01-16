package com.stackQueue.learning;

public class QueueUsingArray {
    int front, rear;
    int arr[] = new int[100005];

    QueueUsingArray() {
        front = 0;
        rear = 0;
    }

    //Function to push an element x in a queue.
    void push(int x) {
        // Your code here
        arr[rear] = x;
        rear++;
    }

    //Function to pop an element from queue and return that element.
    int pop() {
        // Your code here
        if (rear == front) {
            return -1;
        }
        int val = arr[front];
        arr[front]=0;
        front++;
        return val;
    }
}
