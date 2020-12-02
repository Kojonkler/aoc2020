package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> dataset = FileReader.readFile("./day2/dataset.txt");
        exercise1(dataset);
        exercise2(dataset);
    }

    /**
     * Exercise 1
     * 
     * @param dataset
     */
    public static void exercise1(ArrayList<String> dataset) {
        int count = 0;
        for (String row : dataset) {
            List<String> parts = Arrays.asList(row.split(": "));
            String identifiers = parts.get(0);
            String password = parts.get(1);

            parts = Arrays.asList(identifiers.split(" "));
            String bounds = parts.get(0);
            char letter = parts.get(1).charAt(0);

            parts = Arrays.asList(bounds.split("-"));
            int minimum = Integer.parseInt(parts.get(0));
            int maximum = Integer.parseInt(parts.get(1));

            // Using some spicy Java 8 code that will make this code a lot cleaner
            long occurences = password.chars().filter(c -> c == letter).count();
            if (occurences >= minimum & occurences <= maximum) {
                count++;
            }
        }

        System.out.println("Answer exercise 1: " + count);
    }

    /**
     * Exercise 2
     * 
     * @param dataset
     */
    public static void exercise2(ArrayList<String> dataset) {
        int count = 0;
        for (String row : dataset) {
            List<String> parts = Arrays.asList(row.split(": "));
            String identifiers = parts.get(0);
            String password = parts.get(1);

            parts = Arrays.asList(identifiers.split(" "));
            String bounds = parts.get(0);
            char letter = parts.get(1).charAt(0);

            parts = Arrays.asList(bounds.split("-"));

            // We now subtract one, since they need to be used as indices in Java
            int index1 = Integer.parseInt(parts.get(0)) - 1;
            int index2 = Integer.parseInt(parts.get(1)) - 1;

            // Since the OR (||) also is true if both sides are true, we need to use XOR (^)
            if (password.charAt(index1) == letter ^ password.charAt(index2) == letter) {
                count++;
            }
        }

        System.out.println("Answer exercise 2: " + count);
    }
}
