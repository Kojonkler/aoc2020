package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public FileReader() {
        super();
    }

    public static ArrayList<Integer> readFile(String path) {
        ArrayList<Integer> result = new ArrayList<>();
        try {
            File dataset = new File(path);
            Scanner scanner = new Scanner(dataset);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                result.add(Integer.parseInt(data));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

}
