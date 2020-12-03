package day3;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> dataset = FileReader.readFile("./day3/dataset.txt");
        exercise1(dataset);
        exercise2(dataset);
    }

    public static int countTrees(ArrayList<String> dataset, int incrementX, int incrementY) {
        int forestWidth = dataset.get(0).length();
        int count = 0;
        int indentation = 0;

        for (int index = 0; index < dataset.size(); index += incrementY) {
            String row = dataset.get(index);
            if (row.charAt(indentation % forestWidth) == '#') {
                count++;
            }

            indentation += incrementX;
        }

        return count;
    }

    /**
     * Exercise 1
     * 
     * @param dataset
     */
    public static void exercise1(ArrayList<String> dataset) {
        System.out.println("Answer exercise 1: " + countTrees(dataset, 3, 1));
    }

    /**
     * Exercise 2
     * 
     * @param dataset
     */
    public static void exercise2(ArrayList<String> dataset) {
        ArrayList<Integer> counts = new ArrayList<>();
        counts.add(countTrees(dataset, 1, 1));
        counts.add(countTrees(dataset, 3, 1));
        counts.add(countTrees(dataset, 5, 1));
        counts.add(countTrees(dataset, 7, 1));
        counts.add(countTrees(dataset, 1, 2));

        // Since the product of this array goes beyond 2^31, we use BigInteger
        long total = counts.stream().map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply).longValue();

        System.out.println("Answer exercise 2: " + total);
    }
}
