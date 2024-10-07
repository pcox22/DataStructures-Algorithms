// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: IntelliJ

import java.util.Scanner;
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Scanner intput = new Scanner(System.in); // Scanner designated for ints to circumnavigate overflow
    MyStack<String> stack = new MyStack<>();
    String userString = null;
    int choice = -1;
    do
    {
        System.out.println("1 – Read input string of words");
        System.out.println("2 – Reverse string and display outputs");
        System.out.println("3 - Exit program\n");
        System.out.print("Enter option number: ");
        choice = intput.nextInt();

        switch (choice){
            case 1:
                System.out.print("Enter a string: ");
                userString = input.nextLine();
                break;
            case 2:
                // For loop will execute whenever user has entered a string
                // For loop will always push string to stack whenever option 2 is called. Ensures that repeating option 2 looks natural.
                if (userString!= null){
                    String[] splitString = userString.split(" ");
                    for(String s : splitString){
                        stack.push(s);
                    }
                }

                if (userString == null || stack.isEmpty()){
                    System.out.println("You have not entered a string!");
                }
                else{
                    System.out.println("Entered string: " + userString);
                    System.out.print("Reversed string: ");
                    while (!stack.isEmpty()){
                        System.out.print(stack.pop() + " ");
                    }

                }
                System.out.println();
        }
        System.out.println();

    } while (choice != 3);
    System.out.println("Shutting down...");
}
