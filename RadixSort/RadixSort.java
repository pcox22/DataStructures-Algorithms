// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: IntelliJ

import java.util.Scanner;
import java.util.Arrays;
public class RadixSort {
    public static void main(String[] args) {
        Scanner intput = new Scanner(System.in);
        int choice = -1;
        int n = 0;
        int[] array = new int[0];

        do
        {
            // Loop Menu at start
            System.out.println("1 – Read array size");
            System.out.println("2 – Read array values");
            System.out.println("3 – Run Radix Sort and print outputs");
            System.out.println("4 – Exit program");

            System.out.print("\nEnter option number: ");
            choice = intput.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter array size: ");
                    n = intput.nextInt();
                    if (n <= 0){
                        System.out.println("Array size must be greater than zero");
                        break;
                    }
                    array = new int[n];
                    break;

                case 2:
                    if (array.length == 0){
                        System.out.println("Cannot enter values without an array size.");
                        break;
                    }
                    System.out.println("Enter array values: ");
                    for (int i = 1; i <= n; i++){
                        System.out.print("Number " + i + ": ");
                        array[i-1] = intput.nextInt();
                    }
                    System.out.println();
                    break;

                case 3:
                    if (array.length == 0){
                        System.out.println("Cannot sort an empty list.");
                        break;
                    }
                    // For-loop simulates a toString method to obtain each value in organized order
                    String userArray = "";
                    for (int i = 0; i < array.length; i++){
                        userArray += array[i] + " ";
                    }
                    System.out.println("Running Radix Sort on: " + userArray);
                    radixSort(array); // Method call sorts array


                    String sortedArray = "";
                    for (int i = 0; i < array.length; i++){
                        sortedArray += array[i] + " ";
                    }
                    System.out.println("Radix Sort completed: " + sortedArray);
            }
            System.out.println();
        }
        while (choice != 4);
        System.out.println("Shutting Down...");
    }

    public static int CountDigits(int[] valueList){
        // Function will navigate the list and determine the largest value
        // Subsequently divides the max by 10 as long as it is a whole number, and returns the number of times division occurred
        int max = valueList[0];
        for (int i = 0; i < valueList.length; i++){
            if (valueList[i] > max){
                max = valueList[i];
            }
        }
        int count = 0;
        while (max > 0){
            max /= 10;
            count++;
        }
        return count;
    }

    public static int ExtractDigits(int x, int power){
        return (int) ((x / Math.pow(10, power)) % 10); // Get Digit at position of 10^power - eg: 1, 10, 100
    }

    public static void radixSort(int[] values){
        MyQueue<Integer>[] sorter = new MyQueue[10]; // Utilizes array of Queues to ensure completion of sorting
        for (int i = 0; i < sorter.length; i++){
            sorter[i] = new MyQueue<>(); // Set each position to a Queue
        }
        int k = CountDigits(values); // Digits of highest value
        for (int i = 0; i < k; i++){
            int currentQueue = 0; // Measures which Queue is currently being used for sorting

            // foreach # in the array, get the value of the digit currently being measured and Enqueue
            for(int x : values){
                int currentDigit = ExtractDigits(x, i);
                sorter[currentDigit].enqueue(x); // Will Enqueue digits of one number into its own queue
                //System.out.println(x);
            }

            //
            for (int j = 0; j < values.length; j++){
                while(sorter[currentQueue].isEmpty()){
                    currentQueue++;
                }
                values[j] = sorter[currentQueue].dequeue();
            }
        }
    }
}
