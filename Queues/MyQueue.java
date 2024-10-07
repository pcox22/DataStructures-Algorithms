// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: IntelliJ

public class MyQueue<E> {
    private Node<E> top; // Switched to using Nodes to create manual Linked List
    private int size; // Increments with each new or deleted node
    private static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
        }
    }


    public MyQueue() {
        top = null;
        size = 0;
    }

    public void enqueue (E element){
        Node<E> newNode = new Node<>(element); // Create new node with data

        if (top == null){
            top = newNode;
        }
        else{
            Node temp = top;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }

        this.size++;
    }
    public E dequeue(){
        E returnValue = top.data;
        top = top.next;
        this.size--;
        return returnValue;
    }

    public E front() {
        return top.data;
    }

    public int size(){
        return this.size; // returns size of stack
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void printQueue(){
        Node<E> temp = top;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}
