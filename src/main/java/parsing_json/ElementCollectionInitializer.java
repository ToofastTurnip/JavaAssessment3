package parsing_json;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ElementCollectionInitializer {

    public static ElementCollection generate() {
        Gson gson = new Gson();
        ElementCollection elementCollection = gson.fromJson(fileToString(), ElementCollection.class);
        return elementCollection;
    }

    public static String fileToString() {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = ElementCollectionInitializer.class.getClassLoader();
        File file = new File(classLoader.getResource("periodic_table.json").getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
