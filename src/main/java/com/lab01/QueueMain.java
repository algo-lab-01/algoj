package com.lab01;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(12);
        queue.add(13);
        queue.add(11);
        queue.add(14);
        System.out.println("size" + queue.size);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println("size" + queue.size);
    }
}

class Queue{
    Node head;
    Node tail;
    int size = 0;

    Queue(){
        head = null;
        tail = null;
    }

    void add(int val){
        if(head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
        size ++;
    }

    public int remove(){
        if(head == null) {
            throw new RuntimeException("Queue is empty");
        }
        Node node = head;
        head = head.next;
        size -- ;
        return node.val;
    }
    public int peek(){
        if(head == null) {
            throw new RuntimeException("Queue is empty");
        }
        return head.val;
    }

}

class Node{
    int val;
    Node next;
    Node (int val){
        this.val = val;
        this.next = null;
    }
}