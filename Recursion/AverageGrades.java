// Name: Patrick Cox
// Class: CS 3305/section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 2

import java.util.Scanner;

public class AverageGrades {
    public static void main(String[] args) {

        // First Scanner used for integers, Second Scanner used for strings
        Scanner intput = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        // Stores Class Size
        int classSize = 0;

        // Stores the input for user grades, separated by spaces. Later split into array formattedGrades
        String grades = null;
        String[] formattedGrades = null;

        // stores the average returned by findAverage
        double average = 0;

        // stores the values of formattedGrades upon being converted to doubles
        double[] roster = new double[classSize];

        // User's menu choice
        int choice = -1;

        // Used to check whether the number of grades matches the class-size. Will not allow computations if false.
        boolean formattedCorrectly = false;

        // Menu stores in do-while to ensure it runs at least once.
        do
        {
            System.out.println("\n1. Read class size");
            System.out.println("2. Read class grades");
            System.out.println("3. Compute class average");
            System.out.println("4. Exit program\n");

            System.out.print("Enter option number: ");
            choice = intput.nextInt();

            if (choice == 1){
                // Prompt and accept a classSize, sets integer array roster[] to size of class
                System.out.print("Enter Class Size: ");
                classSize = intput.nextInt();
                roster = new double[classSize];
            }
            else if (choice == 2){
                // Disallows computations when there is less than one student in the class
                if (classSize <= 0){
                    System.out.println("Invalid class size; Enter another class size.\n");
                }
                else {
                    // Accept grades in string form.
                    // Separates them using " " (SPACE) as a delimiter in formattedGrades
                    System.out.print("Enter grades: ");
                    grades = input.nextLine();
                    formattedGrades = grades.split(" ", classSize);

                    // Sets formattedCorrectly to false if number of grades entered does not match class size
                    if (formattedGrades.length != classSize){
                        System.out.println("Incorrect number of grades entered, please re-enter grades");
                        formattedCorrectly = false;
                    }
                    else {
                        formattedCorrectly = true;
                    }

                    // when properly formatted, will convert formattedGrades into doubles and store it in roster
                    if (formattedCorrectly){
                        for(int i = 0; i < classSize; i ++){
                            roster[i] = Double.parseDouble(formattedGrades[i]);
                            // If a given grade is not between 0 and 100, disallows computations
                            if(roster[i] < 0 || roster[i] > 100){
                                System.out.println("Invalid grade has been input, please re-enter grades.\n");
                                formattedCorrectly = false;
                                break;
                            }
                        }
                    }


                }
            }
            else if (choice == 3){
                if (formattedCorrectly){
                    // stores return value of findAverage
                    average = findAverage(classSize, roster);

                    // Displays information entered by user and computed average
                    System.out.println("You entered class size: " + classSize);
                    System.out.println("You entered grades: " + grades);
                    System.out.println("Class average: " + average);
                }
                else {
                    // Error message if all conditions were not met
                    System.out.println("Cannot compute because number of grades does not match class size or a grade was not a valid value.");
                    System.out.println("Please re-enter class grades.\n");
                }

            }
            else if (choice == 4){
                System.out.println("Shutting down...");
            }
        } while (choice != 4);
    }

    // Recursively finds the average of a double array
    static double findAverage(int size, double[] roster){
        // Base case of size 0 prevents index out of bounds error.
        // Returns zero to avoid disrupting calculations
        if (size == 0){
            return 0;
        }

        // Utilizes functional definition of Average to calculate average
        return ((size - 1) * findAverage(size-1, roster) + roster[size - 1]) / size;
    }
}