// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: IntelliJ

import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int choice = -1; // controls menu / switch
        String sample = ""; // contains data to be converted into BST
        String[] splitSample = null; // will split data into unique entries that will enter unique nodes
        Scanner input = new Scanner(System.in); // scanner for strings
        Scanner intput = new Scanner(System.in); // scanner for integers
        BST<String> myTree = new BST<String>(); // BST for operations

        do {
            System.out.println("-----------------MAIN MENU---------------\n" +
                    "1. Read input string\n" +
                    "2. Remove duplicates and display outputs\n" +
                    "3. Exit program");

            System.out.print("\nEnter option Number: ");
            choice = intput.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter string: ");
                    sample = input.nextLine();
                    splitSample = sample.split(" ");
                    for (String x: splitSample){
                        myTree.insert(x);
                    }
                    break;
                case 2:
                    // if tree has not been inserted upon, will not try to remove duplicates.
                    if (myTree.isEmpty()){
                        System.out.println("Cannot print from empty tree.");
                        continue;
                    }
                    if (sample.isEmpty()){
                        System.out.println("Enter a valid input string");
                        continue;
                    }

                    // BST by default doesn't allow duplicates
                    // To "remove duplicates", printed from base input and then printed inorder from tree
                    System.out.println("Original Text: ");
                    for (String x: splitSample){
                        System.out.print(x + " ");
                    }

                    System.out.println("\nProcessed Text: ");
                    myTree.inorder();

                    System.out.println();
                    break;
                case 3:
                    System.out.println("Shutting down...");
                    break;
            }
            System.out.println();
        }
        while (choice != 4);


    }
}
