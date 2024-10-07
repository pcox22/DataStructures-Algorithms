import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] bubSort = new int[10];
        int[] selSort = new int[10];
        int[] insSort = new int[10];
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter number " + i + ": ");
            int storeNum = input.nextInt();
            bubSort[i - 1] = storeNum;
            selSort[i - 1] = storeNum;
            insSort[i - 1] = storeNum;
        }
        // for i in range(bubSort.length)
        // for j in range(bubSort.length - 1 - i)
        for (int i = 0; i < bubSort.length; i++) {
            for (int j = 0; j < bubSort.length - 1 - i; j++) {
                if (bubSort[j] > bubSort[j + 1]) {
                    int temp = bubSort[j];
                    bubSort[j] = bubSort[j + 1];
                    bubSort[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < selSort.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (selSort[j] > selSort[i]) {
                    int temp = selSort[j];
                    selSort[j] = selSort[i];
                    selSort[i] = temp;
                }
            }
        }

        for (int i = 1; i < insSort.length; i++) {
            for (int j = i; j > 0; j--) {
                if (insSort[j-1] > insSort[j]) {
                    int temp = insSort[j-1];
                    insSort[j-1] = insSort[j];
                    insSort[j] = temp;
                }
            }
        }

            System.out.println("Now printing the new arrays: ");

            System.out.print("Bubble Sort:  ");
            for (int i = 0; i < bubSort.length; i++) {
                System.out.print(bubSort[i] + " ");
            }

            System.out.print("\nSelection Sort: ");
            for (int i = 0; i < selSort.length; i++) {
                System.out.print(selSort[i] + " ");
            }

            System.out.print("\nInsertion Sort: ");
            for (int i = 0; i < selSort.length; i++) {
                System.out.print(insSort[i] + " ");
            }

        }
    }
