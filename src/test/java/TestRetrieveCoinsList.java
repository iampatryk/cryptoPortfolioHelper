import org.example.CoinsAPIHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestRetrieveCoinsList {

    private CoinsAPIHandler coinsAPIHandler;
    private Path path;
    private final String filePathName = "coinsListFile.txt";


    @BeforeEach
    void setUp() {
        coinsAPIHandler = new CoinsAPIHandler();
        path = Paths.get(filePathName);
    }

    @Test
    void saveResponseToFileShouldUpdateFileWithNewCoins() throws IOException, IOException {
        String existingCoins = "[{\"id\":\"bitcoin\",\"symbol\":\"btc\",\"name\":\"Bitcoin\"}]";
        String newCoins = "[{\"id\":\"ethereum\",\"symbol\":\"eth\",\"name\":\"Ethereum\"}]";

        Files.writeString(path,existingCoins);

        coinsAPIHandler.saveResponseToFile(newCoins);

        String updatedCoins = Files.readString(path);
        Assertions.assertTrue(updatedCoins.contains("etherum"));
    }

}
