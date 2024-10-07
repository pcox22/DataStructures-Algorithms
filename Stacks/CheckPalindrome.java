// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 4
// IDE Name: IntelliJ

import java.util.Scanner;
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Scanner intput = new Scanner(System.in);
    int choice = -1;
    String userString = null;
    MyStack<Character> stack = new MyStack<>();
    //StringBuilder palindromeCheck = new StringBuilder();

    do // do-while loop to ensure menu runs at least once
    {
        System.out.println("1 – Read input string");
        System.out.println("2 – Check palindrome and display output");
        System.out.println("3 - Exit Program");

        System.out.print("\nEnter option number: ");
        choice = intput.nextInt();

        switch (choice){
            // Note: Case 1 (Option 1 - Read input String) does not push the string to the stack
            // This is accomplished when option 2 is selected that way if the user continues to press Option 2, it will always reset and renew the stack
            case 1:
                System.out.print("Enter input string: ");
                userString = input.nextLine();
                break;
            case 2:
                System.out.println("You entered: " + userString);
                String palindromeCheck = "";
                // For loop pushes all chars to stack
                for(int i = 0; i < userString.length(); i++)
                {
                    stack.push(userString.charAt(i));
                }

                // While loop will collect all data from stack in LI-FO order
                while (!stack.isEmpty()){
                    palindromeCheck += (stack.pop());
                }

                // Checks if input was a palindrome by comparing against stack output
                if (palindromeCheck.equalsIgnoreCase(userString)){
                    System.out.println("Judgement: Palindrome");
                }
                else{
                    System.out.println("Judgement: Not Palindrome");
                }
        }
        System.out.println();
    } while (choice != 3);
    System.out.println("Shutting Down...");
}