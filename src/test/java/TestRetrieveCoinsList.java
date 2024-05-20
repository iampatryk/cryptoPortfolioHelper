import org.example.RetrieveCoinsList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRetrieveCoinsList {

    private RetrieveCoinsList retrieveCoinsList = new RetrieveCoinsList();

   @Test
    public void testRetrieveCoinsListAndSaveItInAFile() throws IOException {
        String filePathName = "coinListFile.txt";
        Path filePath = Paths.get(filePathName);

        Assertions.assertTrue(Files.exists(filePath),"File should exist");
        Assertions.assertTrue(Files.size(filePath) > 0, "File should not be empty");
   }

   @Test
    public void testSaveResponseToFile() throws IOException {
       String responseCoins = "Existing data";

       Path filePath = Paths.get(retrieveCoinsList.filePathName);
       Assertions.assertTrue(Files.exists(filePath), "File should exist");
       Assertions.assertEquals(responseCoins, Files.readString(filePath), "File content should match response data");
   }

   @Test
    public void testDataIsAlreadyExistsInFile() throws IOException {
       String existingData = "Existing data";
       Path filePath = Paths.get(retrieveCoinsList.filePathName);
       Files.writeString(filePath, existingData);

       boolean dataExists = Files.exists(filePath) && Files.size(filePath) > 0;

       Assertions.assertTrue(dataExists, "Data should exist in the file");

   }


}
