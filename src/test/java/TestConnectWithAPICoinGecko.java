import org.example.ConnectWithAPICoinGecko;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class TestConnectWithAPICoinGecko {
    @Test
    void testCheckAPIServerStatus() {
        ConnectWithAPICoinGecko connectWithAPICoinGecko = new ConnectWithAPICoinGecko();
        HttpResponse<String> response = connectWithAPICoinGecko.CheckAPIServerStatus();
        Assertions.assertNotNull(response, "Response should not be null");
        Assertions.assertEquals(200, response.statusCode(), "Expected status code 200 OK");
    }
}
