import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Coin;
import org.example.CoinsAPIHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public class TestCoinAPIHandler {

    private CoinsAPIHandler coinsAPIHandler;
    private final String testFilePath = "testCoinsListFile.txt";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() throws IOException {
        coinsAPIHandler = new CoinsAPIHandler();
        Files.deleteIfExists(Path.of(testFilePath));
    }

    @Test
    public void testSaveResponseToFile() throws IOException {

        String apiResponse = "[{\"id\":\"bitcoin\",\"symbol\":\"btc\",\"name\":\"Bitcoin\"}]";

        coinsAPIHandler.saveResponseToFile(apiResponse);

        List<String> fileContents = Files.readAllLines(Path.of(testFilePath));
        String content = String.join("", fileContents);
        Set<Coin> coins = objectMapper.readValue(content, Set.class);

        Assertions.assertEquals(1, coins.size());
        Assertions.assertEquals("bitcoin", coins.iterator().next().getSymbol());


    }
}
