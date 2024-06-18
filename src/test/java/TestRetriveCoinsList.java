import org.example.CoinsAPIHandler;
import org.example.RetrieveCoinsList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestRetriveCoinsList {

    HttpClient mockClient = mock(HttpClient.class);
    CoinsAPIHandler mockHandler = mock(CoinsAPIHandler.class);
    RetrieveCoinsList retrieveCoinsList = new RetrieveCoinsList(mockClient, mockHandler);
    HttpResponse<String> mockResponse = mock(HttpResponse.class);

    @Test
    public void testRetriveCoinsListWhenDataDoesNotExistCallsSaveResponseToFile() throws IOException, InterruptedException {
        when(mockHandler.dataAlreadyExistsinFile()).thenReturn(false);
        when(mockClient.send(any(HttpRequest.class),any(HttpResponse.BodyHandler.class))).thenReturn(mockResponse);
        when(mockResponse.body()).thenReturn("response body");

        retrieveCoinsList.retrieveCoinsListAndSaveItInAFile();

        verify(mockHandler,times(1)).saveResponseToFile("response body");
    }

    @Test
    public void testRetriveCoinsListWhenDataExistsDoesCallsSaveResponseToFile() throws IOException {
        when(mockHandler.dataAlreadyExistsinFile()).thenReturn(true);

        retrieveCoinsList.retrieveCoinsListAndSaveItInAFile();

        verify(mockHandler, never()).saveResponseToFile(anyString());
    }

    @Test
    public void testRetriveCoinsListWhenInterruptedExceptionIsThrownAndRuntimeException() throws IOException, InterruptedException {
        when(mockClient.send(any(HttpRequest.class),any(HttpResponse.BodyHandler.class))).thenThrow(InterruptedException.class);

        Assertions.assertThrows(RuntimeException.class,retrieveCoinsList::retrieveCoinsListAndSaveItInAFile);
    }

}
