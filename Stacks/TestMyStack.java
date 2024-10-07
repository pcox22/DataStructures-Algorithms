// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: IntelliJ
import java.util.Scanner;
public static void main(String[] args) throws Exception {
    // Variable and Object Creation
    int choice = -1;
    Scanner input = new Scanner(System.in);
    Scanner intput = new Scanner(System.in); // Second scanner to read integers and circumnavigate overflow from string input
    MyStack<Integer> stack = new MyStack<>();
    do // do-while ensures that menu runs at least once
    {
        // Menu options
        System.out.println("1 – Push element");
        System.out.println("2 – Pop element");
        System.out.println("3 – Get top element");
        System.out.println("4 – Get stack size");
        System.out.println("5 – Is empty stack?");
        System.out.println("6 - Print stack");
        System.out.println("7 - Exit program");

        System.out.print("\nEnter option number: ");
        choice = intput.nextInt();
        // Switch-case appropriately executes options
        switch (choice) {
            case 1:
                System.out.print("Enter an INTEGER to push to stack: ");
                try {
                    int push = intput.nextInt();
                    System.out.print("\nStack before pushing element: ");
                    stack.printStack();
                    System.out.println("\nPushing " + push + " to stack...");
                    stack.push(push);
                    System.out.print("Stack after pushing element: ");
                    stack.printStack();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                if (!stack.isEmpty()){
                    System.out.print("\nStack before popping element: ");
                    stack.printStack();

                    System.out.println("\nRemoving " + stack.pop() + " from stack...");
                    System.out.print("Stack after popping element: ");
                    stack.printStack();
                }
                else{
                    System.out.println("Cannot pop from an empty stack!");
                }
                break;
            case 3:
                if (!stack.isEmpty()){
                    System.out.print("Stack before getting top element: ");
                    stack.printStack();

                    System.out.println("\nTop of stack is: " + stack.top());

                    System.out.print("Stack after getting top element: ");
                    stack.printStack();
                    System.out.println();
                }
                else{
                    System.out.println("Cannot print from an empty stack!");
                }

                break;
            case 4:
                System.out.println("Current stack size is: " + stack.size());
                break;
            case 5:
                if (stack.isEmpty()){
                    System.out.println("Stack is empty.");
                }
                else{
                    System.out.println("Stack is not empty.");
                }
                break;
            case 6:
                System.out.print("Current stack is: ");
                stack.printStack();
                break;
        }
            System.out.println();


    }
    while (choice != 7);
    System.out.println("Shutting down...");
}
