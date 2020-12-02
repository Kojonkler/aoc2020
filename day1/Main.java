package day1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static final int TOTAL = 2020;

    public static void main(String[] args) {
        ArrayList<Integer> dataset = FileReader.readFile("./day1/dataset.txt");
        Collections.sort(dataset);

        /**
         * Exercise 1: this is a solution which is O(n), which uses two pointers
         */
        int left = 0;
        int right = dataset.size() - 1;

        while (left < right) {
            int partialSum = dataset.get(left) + dataset.get(right);
            if (partialSum == TOTAL) {
                System.out.println("Answer exercise 1: " + dataset.get(left) * dataset.get(right));
                break;
            } else if (partialSum < TOTAL) {
                left++;
            } else {
                right--;
            }
        }

        /**
         * Exercise 2: this is a solution which is O(n^2), which uses three pointers
         */
        for (int i = 0; i < dataset.size(); i++) {
            left = i + 1;
            right = dataset.size() - 1;

            while (left < right) {
                int partialSum = dataset.get(i) + dataset.get(left) + dataset.get(right);
                if (partialSum == TOTAL) {
                    System.out.println("Answer exercise 2: " + dataset.get(i) * dataset.get(left) * dataset.get(right));
                    break;
                } else if (partialSum < TOTAL) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
