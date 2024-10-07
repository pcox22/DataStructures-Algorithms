// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: IntelliJ

import java.util.List;

public class LinkedList_No_HT
{
   public Node ListName;

   //constructor method to create a list object with a specifc name. 
   public LinkedList_No_HT()
   {
      ListName = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {

      if (ListName == null) 
         ListName = new Node(data); // Creates single-node list
      else 
      {
         Node temp = ListName;
         while (temp.next != null) // Traverse each node to find and add new node to end of list
         {
            temp = temp.next;
         }
         
         temp.next = new Node(data); //link new node as last node
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node
   public void addFirstNode(int data)
   {
      Node newHead = new Node(data);   // Create new node containing parameter data
      newHead.next = ListName;   // Attaches existing list to the end of new node
      ListName = newHead;  // Assigns the "Head" to the new list, containing a new node at the start
   }
     
      
   //method #2: add node at index
   public void addAtIndex(int index, int data)
   {
      Node temp = ListName; // temp node can navigate through list without losing data

      // If creating a node at the start
      if (index == 0) {
         Node newHead = new Node(data);
         newHead.next = ListName;
         ListName = newHead;
         return;
      }
      else {
         // for loop iterates through LinkedList until node at index is reached
         for (int i = 0; i < index - 1; i ++){
            if(temp.next != null){
               temp = temp.next;
            }
         }
         Node newNode = new Node(data);
         newNode.next = temp.next; // Attach remaining Nodes to end of new Node
         // Temp has not changed, so assignment of temp.next inserts new node followed by remaining nodes
         temp.next = newNode;
      }


   }
      
      
   //method #3: remove first node
   public void removeFirstNode()
   {
      // Set the head of the list to the second item in the list, first node is disconnected.
      ListName = ListName.next;
   }
      
      
   //method #4: remove last node
   public void removeLastNode()
   {
      Node temp = ListName;

      // Removes the first node from a list, given that it is the only node in the list
      if (ListName.next == null){
         ListName = null;
         return;
      }
      // Navigate until last value is temp.next
      while (temp.next.next != null){
         temp = temp.next;
      }
      temp.next = null; // Nullifies last value
   }
    
    
   //method #5: remove node at index
   public void removeAtIndex(int index)
   {
      if (index == 0){
         ListName = ListName.next; // Set start of node to second position; cuts off first node
      }
      else{
         Node temp = ListName;
         // Traverse list until temp.next is the desired value
         for (int i = 0; i < index-1; i ++){
            if(temp.next.next != null){ // Traversal is stopped if end of list is reached
               temp = temp.next;
            }
         }
         // Nullify node determined to be at index
         temp.next = null;
      }

   }
          
   //method #6: countNodes
   public int countNodes()
   {
      int listSize= 0;
      Node temp = ListName;

      // As long as the current node is not null, increment listSize, and return it when all nodes are exhausted
      while (temp != null){
         temp = temp.next;
         listSize++;
      }
      return listSize; 
   }

   
   //method #7: printInReverse (must be a Recursive method)
   public void printInReverseRecursive(Node L)
   {
      // Base Case ends recursion when a node is null (end of list)
      if (L == null){
         return;
      }
      else {
         // Recursive Call before print statement ensures that
         // data is not printed until memory stack of all futures calls are resolved
         printInReverseRecursive(L.next);
         System.out.print(L.data + "   ");
      }
   }

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = ListName;

      // So long as current node is not null, print its data and traverse to next node
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

