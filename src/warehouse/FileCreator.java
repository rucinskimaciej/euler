package warehouse;

import java.io.*;
import java.util.Arrays;
import java.util.List;

class FileCreator {

    FileCreator(String fileName){
        try (
                var fileWriter = new FileWriter(new File(fileName), true);
                var writer = new BufferedWriter(fileWriter);
                ) {
            String[] fileList = fileContent.split("\n");
            for (String s: fileList){
                writer.write(s);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String fileContent =
            "Apple Macbook Pro 13;12\n" +
            "Klawiatura Logitech Pro;66\n" +
            "Dell XPS 2016;22\n" +
            "Monitor Samsung 24;36\n" +
            "Monitor HP;28\n" +
            "Mysz Dell;53"
            ;

}
