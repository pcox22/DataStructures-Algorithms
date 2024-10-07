// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: IntelliJ

import java.util.LinkedList;
public class MyStack <E>{
    // private LinkedList<E> stack; - Originally completed assignment using built-in Linked List
    private Node<E> top; // Switched to using Nodes to create manual Linked List
    private int size; // Increments with each new or deleted node
    private static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
        }
    }


    public MyStack() {
        top = null;
        size = 0;
    }

    public void push (E element){
        // stack.addFirst(element); - Originally used to perform the following code automatically

        Node<E> newNode = new Node<>(element); // Create new node with data
        newNode.next = top; // Set rest of new node = current list
        top = newNode; // Establish the list as the new node plus the existing list
        this.size++; // Increment Size
    }
    public E pop(){
        /*
        if (!stack.isEmpty()){
            return stack.removeFirst(); // Remove most recently added element, if one exists
        }
        else{
            return null;
        }
         */
        E returnValue = top.data;
        top = top.next;
        this.size--;
        return returnValue;

    }

    public E top() throws Exception {
        /*
        if (!stack.isEmpty()){
            return stack.getFirst(); // Peeks at the element in the first position, given it exists
        }
        else{
            throw new Exception("Cannot peek from an empty stack!");
        }
         */
        return top.data;
    }

    public int size(){
        return this.size; // returns size of stack
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void printStack(){
        Node<E> temp = top;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}
