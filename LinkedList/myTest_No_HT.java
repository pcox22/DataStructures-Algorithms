// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 3
// IDE Name: IntelliJ

import java.util.Scanner;

public class myTest_No_HT
{
   public static void main (String[] args)
   {
      LinkedList_No_HT myList = new LinkedList_No_HT(); //create a list object
      Scanner input = new Scanner(System.in);
      Scanner intput = new Scanner(System.in);
      int nodeData;
      int index;

      int userChoice = -1;
      do
      {
         System.out.println("1 - Add First Node");
         System.out.println("2 - Add Last Node");
         System.out.println("3 - Add At Index");
         System.out.println("4 - Remove First Node");
         System.out.println("5 - Remove Last Node");
         System.out.println("6 - Remove At Index");
         System.out.println("7 - Print List Size");
         System.out.println("8 - Print List Forward");
         System.out.println("9 - Print List In Reverse");
         System.out.println("10 - Exit Program");

         System.out.print("\nEnter Option Number: ");
         userChoice = intput.nextInt();

         switch(userChoice){
            case 1:
               System.out.print("Enter value to insert into list: ");
               nodeData = intput.nextInt();

               // Prints list before adding new node
               System.out.println("Adding " + nodeData + " to list...");
               System.out.print("List content before adding " + nodeData + " is: ");
               myList.printList();

               myList.addFirstNode(nodeData); // method call to add node to first position

               // Prints list after adding new node
               System.out.print("\nList content after adding " + nodeData + " is: ");
               myList.printList();

               break;
            case 2:
               System.out.print("Enter value to insert at the end of the list: ");
               nodeData = intput.nextInt();

               // Prints list before adding new node
               System.out.println("Adding " + nodeData + " to list...");
               System.out.print("List content before adding " + nodeData + " is: ");
               myList.printList();

               // Method call to add node to last position
               myList.addLastNode(nodeData);

               // Prints list after adding new node
               System.out.print("\nList content after adding " + nodeData + " is: ");
               myList.printList();

               break;
            case 3:
               // Ask for and store index to pass to method
               System.out.print("Enter Index: ");
               index =  intput.nextInt();

               // Input validation for index
               if (index > myList.countNodes() || index < 0){
                  System.out.println("Invalid index, please try again.");
               }
               else{
                  System.out.print("\nEnter value to insert at index: ");
                  nodeData = intput.nextInt();


                  // Prints list before adding new node
                  System.out.println("Adding " + nodeData + " to list...");
                  System.out.print("List content before adding " + nodeData + " is: ");
                  myList.printList();

                  myList.addAtIndex(index, nodeData);
                  System.out.print("\nList content after adding " + nodeData + " is: ");
                  myList.printList();

               }

               break;
            case 4:
               System.out.println("Removing first node...");
               System.out.print("\nList before removing first node: ");
               myList.printList();

               myList.removeFirstNode(); // Method call to remove first node

               System.out.print("\nList after removing first node: ");
               myList.printList();
               break;

            case 5:
               System.out.println("Removing last node...");
               System.out.print("\nList before removing last node: ");
               myList.printList();

               myList.removeLastNode(); // Method call to remove last node

               System.out.print("\nList after removing last node: ");
               myList.printList();
               break;
            case 6:
               // Ask for and store index to pass to method
               System.out.print("Enter Index: ");
               index =  intput.nextInt();

               // Input validation for index
               if (index >= myList.countNodes() || index < 0){
                  System.out.println("Invalid index, please try again.");
               }
               else{
                  // Prints list before removing node
                  System.out.println("Removing node " + index + " from list...");
                  System.out.print("\nList content before removing node " + index + " is: ");
                  myList.printList();

                  myList.removeAtIndex(index); // Method call to remove node at index

                  System.out.print("\nList content after removing node " + index + " is: ");
                  myList.printList();
               }
               break;
            case 7:
               System.out.println("List size: " + myList.countNodes()); // print and Method call of countNodes
               break;
            case 8:
               System.out.println("Printing List:");
               myList.printList(); // Method call to print list
               break;
            case 9:
               System.out.println("Printing List in reverse: ");
               myList.printInReverseRecursive(myList.ListName); // Method call to recursively print list backwards
               break;
         }

         System.out.println("\n"); // Whitespace
      }  while (userChoice != 10);

      System.out.println("Shutting down...");

      /*
      for (int i=1; i <= 5; i++) //add 5 nodes to the list
      {
         myList.addLastNode(i*10);
      } 
      
      //print out the list content
      System.out.print("\nMy test list values are:  ");
      myList.printList();
      System.out.println();
      */
   } 
}
    
