import org.example.RetrieveCoinsList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRetrieveCoinsList {

    private RetrieveCoinsList retrieveCoinsList = new RetrieveCoinsList();
    private String testResponse = "Sample response data";

   @Test
    public void testRetrieveCoinsListAndSaveItInAFile() throws IOException {
       //Check whether the method correctly retrieves data from the API and writes it to a file.
       //Scenarios when the file already exists and when there is no data in the file.
       retrieveCoinsList.RetrieveCoinsListAndSaveItInAFile();
       Assertions.assertTrue(retrieveCoinsList.dataIsAlreadyExistsInFile(),"File should exist and contain data");
   }

   @Test
    public void testSaveResponseToFile() throws IOException {
        //Check whether the method correctly saves the passed data to the file.
       retrieveCoinsList.saveResponseToFile(testResponse);
       Path filePath = Paths.get(retrieveCoinsList.filePathName);
       Assertions.assertTrue(Files.exists(filePath), "File should exist");
       Assertions.assertEquals(testResponse, Files.readString(filePath), "File content should match the response");
   }

   @Test
    public void testDataIsAlreadyExistsInFile() throws IOException {
       //Verify that the method correctly checks whether the file exists and contains data.
       Path filePath = Paths.get(retrieveCoinsList.filePathName);
       Files.writeString(filePath,"Sample response data");
       boolean result = retrieveCoinsList.dataIsAlreadyExistsInFile();
       Assertions.assertTrue(result, "File should exist and contain data");
   }


}
