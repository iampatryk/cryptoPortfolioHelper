import org.example.CoinsAPIHandler;
import org.example.RetrieveCoinsList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.Mockito.*;

public class TTestRetrieveCoinsList {

    private RetrieveCoinsList retrieveCoinsList;
    private CoinsAPIHandler mockCoinsAPIHandler;
    private HttpClient mockHttpClient;
    private HttpResponse<String> mockHttpResponse;

    @BeforeEach
    public void setUp() {
        mockCoinsAPIHandler = Mockito.mock(CoinsAPIHandler.class);
        mockHttpClient = Mockito.mock(HttpClient.class);
        mockHttpResponse = Mockito.mock(HttpResponse.class);
        retrieveCoinsList = new RetrieveCoinsList();
        retrieveCoinsList.coinsAPIHandler = mockCoinsAPIHandler;
        retrieveCoinsList.client = mockHttpClient;
    }

    @Test
    public void testRetrieveCoinsListAndSaveItInAFile_dataDoesNotExist() throws IOException, InterruptedException, IOException {
        when(mockCoinsAPIHandler.dataAlreadyExistsinFile()).thenReturn(false);
        when(mockHttpResponse.body()).thenReturn("dummy response");
        when(mockHttpClient.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(mockHttpResponse);

        retrieveCoinsList.retrieveCoinsListAndSaveItInAFile();

        verify(mockCoinsAPIHandler, times(1)).saveResponseToFile("dummy response");
    }

    @Test
    public void testRetrieveCoinsListAndSaveItInAFile_dataExists() throws IOException {
        when(mockCoinsAPIHandler.dataAlreadyExistsinFile()).thenReturn(true);

        retrieveCoinsList.retrieveCoinsListAndSaveItInAFile();

        verify(mockCoinsAPIHandler, never()).saveResponseToFile(anyString());
    }
}
