// Name: Patrick Cox
// Class: CS 3305/Section# 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: IntelliJ

import java.util.Queue;
import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner intput = new Scanner(System.in);
        MyQueue<Integer> queue = new MyQueue<>();
        int choice = -1;

        do
        {
            System.out.println("1 – Enqueue element");
            System.out.println("2 – Dequeue element");
            System.out.println("3 – Get front element");
            System.out.println("4 – Get queue size");
            System.out.println("5 – Is Empty queue?");
            System.out.println("6 - Print queue");
            System.out.println("7 - Exit program");

            System.out.print("\nEnter option number: ");
            choice = intput.nextInt();

            switch (choice){
                case 1:
                    System.out.print("\nEnter a value to enqueue: ");
                    int data = intput.nextInt();

                    System.out.print("\nQueue before adding " + data + ": ");
                    queue.printQueue();

                    System.out.println("\nAdding " + data + "...");
                    queue.enqueue(data);

                    System.out.print("Queue after adding " + data + ": ");
                    queue.printQueue();

                    System.out.println();
                    break;

                case 2:
                    if (!queue.isEmpty()){
                        System.out.print("\nQueue before removing " + queue.front() + ": ");
                        queue.printQueue();

                        System.out.println("\nRemoving " + queue.front() + " from queue...");
                        queue.dequeue();

                        System.out.print("Queue after removal: ");
                        queue.printQueue();

                        System.out.println();
                    }
                    else{
                        System.out.println("Cannot Dequeue while Queue is empty.");
                    }

                    break;

                case 3:
                    if (!queue.isEmpty())
                    {
                        System.out.println("Front element is: " + queue.front());
                    }
                    else
                    {
                        System.out.println("Front is: Null");
                    }
                    break;

                case 4:
                    System.out.println("Queue size is: " + queue.size());
                    break;

                case 5:
                    if (queue.isEmpty()){
                        System.out.println("Queue is empty.");
                    }
                    else{
                        System.out.println("Queue is not empty.");
                    }
                    break;

                case 6:
                    if (!queue.isEmpty()){
                        System.out.print("\nCurrent Queue: ");
                        queue.printQueue();
                        System.out.println();
                    }
                    else{
                        System.out.println("Cannot print while Queue is empty.");
                    }

            }
            System.out.println();

        } while (choice != 7);
        System.out.println("Shutting down...");

    }
}