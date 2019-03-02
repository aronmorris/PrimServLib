import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class PostHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        //TODO should capture the stuff sent and pass it as a byte array or something to the fileserver for storing

    }
}
