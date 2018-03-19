package user_management;

import com.google.gson.Gson;
import parsing_json.ElementCollectionInitializer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserCollectionInitializer {

    public static UserCollection generate() {
        Gson gson = new Gson();
        UserCollection userCollection = gson.fromJson(fileToString(), UserCollection.class);
        return userCollection;
    }

    private static String fileToString() {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = UserCollectionInitializer.class.getClassLoader();
        File file = new File(classLoader.getResource("users.json").getFile());
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
