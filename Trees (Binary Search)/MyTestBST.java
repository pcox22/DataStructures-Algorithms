// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: IntelliJ

import java.util.ArrayList;
import java.util.Scanner;
public class MyTestBST {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner for strings
        Scanner intput = new Scanner(System.in); // Scanner for integers
        String dt = ""; // will store the initial data type when selecting option 0
        String data; // reused throughout program as string-form data to operate on
        int dataInsConv; // integer version of data
        int choice = -1; // navigates menu / switch
        BST<String> myTree = new BST<String>(); // separate BST for strings
        BST<Integer> myIntTree = new BST<Integer>(); // separate BST for integers
        boolean isString = false; // 2 booleans to control which BST is being operated on
        boolean isInt = false;
        boolean zeroCheck = false; // will not allow operations until a data type is selected.

        /* Most if not all cases see two versions of very similar code.
        This is because there is one set of operations for the integer search tree,
        and one set of operations for the string search tree.

        As a result, the string section (which is always the lower half of each case)
        will not see as many comments since it has generally been explained in the
        integer section.
         */
        do{
            System.out.println("----------------MAIN MENU---------------\n" +
                    "0. Enter Tree Data Type (integer or string)\n" +
                    "1. Insert Data Element\n" +
                    "2. Delete Data Element\n" +
                    "3. Search for Data Element\n" +
                    "4. Print Tree Size\n" +
                    "5. Path from Root to Data Element\n" +
                    "6. Check if Empty Tree\n" +
                    "7. Print Preorder Traversal\n" +
                    "8. Print Inorder Traversal\n" +
                    "9. Print Postorder Traversal\n" +
                    "10. Exit program");

            System.out.print("Enter option number: ");
            choice = intput.nextInt();
            System.out.println();

            if (!zeroCheck && choice != 0){ // prevents menu functions unless 0 is fulfilled
                System.out.println("You must first enter Tree Data Type.");
                System.out.println();
                continue;
            }
            switch(choice){
                case 0:
                    System.out.print("Select \"Integer\" or \"String\": ");
                    dt = input.nextLine();

                    if (dt.equalsIgnoreCase("integer")){
                        isInt = true;
                        isString = false;
                        zeroCheck = true;
                    }
                    else if (dt.equalsIgnoreCase("string")){
                        isInt = false;
                        isString = true;
                        zeroCheck = true;
                    }
                    else{
                        System.out.println("Please enter \"Integer\" or \"String\" !");
                    }

                    break;
                case 1:
                    System.out.print("Enter Data Element for Insertion: ");
                    data = input.nextLine();

                    if (isInt){
                        // Try blocks used throughout program to prevent input mismatch of data types
                        try {
                            System.out.print("BST before adding " + data + ": ");
                            myIntTree.inorder();


                            dataInsConv = Integer.parseInt(data);
                            myIntTree.insert(dataInsConv);

                            System.out.print("\nBST after adding " + data + ": ");
                            myIntTree.inorder();

                            System.out.println();
                        }
                        catch (Exception e){
                            System.out.println("\nInvalid data type");
                        }

                    }
                    if (isString){
                        System.out.print("\nBST before adding " + data + ": ");
                        myTree.inorder();
                        myTree.insert(data);

                        System.out.print("\nBST after adding " + data + ": ");
                        myTree.inorder();
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.print("Enter data element to be deleted: ");
                    data = input.nextLine();

                    if (isInt){
                        try{
                            dataInsConv = Integer.parseInt(data);
                            // Data must be located before deletion attempt
                            if(myIntTree.search(dataInsConv)){
                                System.out.print("BST before deleting " + data + ": ");
                                myIntTree.inorder();
                                myIntTree.delete(dataInsConv);

                                System.out.print("\nBST after deleting " + data + ": ");
                                myIntTree.inorder();
                            }
                            else{
                                System.out.println("Tree does not contain " + data);
                            }
                        }
                        catch (Exception e){
                            System.out.println("\nInvalid Data Type");
                        }
                    }
                    else if (isString){
                        if (myTree.search(data)){
                            System.out.print("BST before deleting " + data + ": ");
                            myTree.inorder();

                            myTree.delete(data);

                            System.out.print("\nBST after deleting " + data + ": ");
                            myTree.inorder();

                            System.out.println();
                        }
                        else{
                            System.out.println("Tree does not contain " + data);
                        }

                    }
                    break;
                case 3:
                    System.out.print("Enter element to search for: ");
                    data = input.nextLine();
                    if (isInt){
                        // Try block includes search conversion and search for data in tree
                        // catch will tell user input was invalid
                        try {
                            dataInsConv = Integer.parseInt(data);
                            System.out.println("Is " + dataInsConv + " in the tree? " + myIntTree.search(dataInsConv));
                        }
                        catch (Exception e){
                            System.out.println("\nInvalid Data Type");
                        }
                    }
                    else if (isString){
                        System.out.println("Is " + data + " in the tree? " + myTree.search(data));
                    }
                    break;
                case 4:
                    if (isInt){
                        System.out.println("Tree is currently size " + myIntTree.getSize());
                    }
                    else if (isString){
                        System.out.println("Tree is currently size " + myTree.getSize());
                    }
                    break;
                case 5:
                    System.out.print("Enter data to find path: ");
                    data = input.nextLine();
                    if (isInt){
                        // try to convert input to integer, print if failed
                        // Each node will be stored in a list and printed out from root to target node
                        try{
                            dataInsConv = Integer.parseInt(data);
                            if (myIntTree.search(dataInsConv)){
                                ArrayList<BST.TreeNode<Integer>> path = myIntTree.path(dataInsConv); // pull list from path method
                                for (BST.TreeNode<Integer> x : path){
                                    System.out.print(x.element + " ");// print data element of each item in list from root to search node
                                }
                            }
                            else{
                                System.out.println("Tree does not contain " + data);
                            }
                        }
                        catch (Exception e){
                            System.out.println("\nInvalid Data Type");
                        }
                    }
                    else if (isString){
                        if (myTree.search(data)){
                            ArrayList<BST.TreeNode<String>> path = myTree.path(data);
                            for (BST.TreeNode<String> x : path){
                                System.out.print(x.element + " ");
                            }
                        }
                        else{
                            System.out.println("Tree does not contain " + data);
                        }
                    }
                    System.out.println();
                    break;
                case 6:
                    if(isInt){
                        if(myIntTree.isEmpty()){
                            System.out.println("Tree is empty.");
                        }
                        else{
                            System.out.println("Tree is not empty.");
                        }
                    }
                    else if (isString){
                        if(myTree.isEmpty()){
                            System.out.println("Tree is empty");
                        }
                        else{
                            System.out.println("Tree is not empty.");
                        }
                    }
                    break;
                case 7:
                    // If-statement ensures operation only occurs when tree is not empty
                    // Basic call of preorder method to print as intended
                    if (isInt){
                        if (!myIntTree.isEmpty()){
                            System.out.print("\nPrinting Preorder: ");
                            myIntTree.preorder();
                        }
                        else{
                            System.out.println("Tree is empty");
                        }
                    }
                    else if (isString){
                        if(!myTree.isEmpty()){
                            System.out.print("\nPrinting Preorder: ");
                            myTree.preorder();
                        }
                        else{
                            System.out.println("Tree is empty");
                        }
                    }
                    break;
                case 8:
                    // If-statement ensures operation only occurs when tree is not empty
                    // Basic call of inorder method to print as intended
                    if (isInt){
                        if (!myIntTree.isEmpty()){
                            System.out.print("\nPrinting Inorder: ");
                            myIntTree.inorder();
                        }
                        else{
                            System.out.println("Tree is empty");
                        }
                    }
                    else if (isString){
                        if(!myTree.isEmpty()){
                            System.out.print("\nPrinting Inorder: ");
                            myTree.inorder();
                        }
                        else{
                            System.out.println("Tree is empty");
                        }
                    }
                    break;
                case 9:
                    // If-statement ensures operation only occurs when tree is not empty
                    // Basic call of postorder method to print as intended
                    if (isInt){
                        if (!myIntTree.isEmpty()){
                            System.out.print("\nPrinting Post Order: ");
                            myIntTree.postorder();
                        }
                        else{
                            System.out.println("Tree is empty");
                        }
                    }
                    else if (isString){
                        if(!myTree.isEmpty()){
                            System.out.print("\nPrinting Post Order: ");
                            myTree.postorder();
                        }
                        else{
                            System.out.println("Tree is empty");
                        }
                    }
                    break;
                case 10: // implemented to prevent error message occurring when user wants to quit
                    break;
                default: // handles edge cases
                    System.out.println("Enter a valid option number.");
            }
            System.out.println();
        }
        while (choice != 10);
        System.out.println("Shutting down...");

    }
}