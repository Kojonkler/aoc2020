package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public FileReader() {
        super();
    }

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> result = new ArrayList<>();
        try {
            File dataset = new File(path);
            Scanner scanner = new Scanner(dataset);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                result.add(data);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

}
