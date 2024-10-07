// Name: Patrick Cox
// Class: CS 3305/section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 2

import java.util.Locale;
import java.util.Scanner;

public class Vowels {
    public static void main(String[] args) {

        // Used two scanners to circumnavigate the error that occurs when following a nextInt with nextLine
        Scanner input = new Scanner(System.in);
        Scanner numInput = new Scanner(System.in);
        int choice = -1;
        String userString = null;

        // do while loop ensures that menu will run at least once, and continue until user stops
        do
        {
            System.out.println("1. Read String Input");
            System.out.println("2. Compute Number of Vowels");
            System.out.println("3. Exit Program");

            System.out.print("\nEnter option number: ");
            choice = numInput.nextInt();

            // If-Statement will read user's selection and carry out corresponding action
            if(choice == 1){
                System.out.print("Enter input string: ");
                userString = input.nextLine();
                System.out.println();
            }
            if (choice == 2){
                System.out.println("\nYou entered string: " + userString);
                System.out.println("Number of vowels: " + countVowels(userString) + "\n");
            }
            else if (choice == 3){
                System.out.println("Shutting down...");
            }

        } while (choice != 3);
        System.out.println();
    }

    // Recursively counts the number of vowels when passed a string
    // Each recursive call checks the next char of the string to see if it is a vowel
    // Each proceeding call is passed a substring that excludes all char's that have been checked
    // When the length of the string can no longer be reduced without passing a null, the recursion terminates
    static int countVowels(String x){
        // new String y equals x in lowercase to save space in If-statement
        String y = x.toLowerCase();

        // If-Statement checks first Char in the array to verify whether it is one of the five specified vowels
        if (y.charAt(0) == 'a' || y.charAt(0) == 'e' || y.charAt(0) == 'i' || y.charAt(0) == 'o' || y.charAt(0) == 'u'){
                // Inside if statement prevents an IndexOutOfBounds error
                // Without statement, method will pass a string of length 1, which will throw an error when using string.substring
                if (x.length() > 1){
                    return 1 + countVowels(x.substring(1));
                }
                else {
                    return 1;
                }
        }
        else if (x.length() > 1){
            return countVowels(x.substring(1));
        }
        else {
            return 0;
        }


    }
}