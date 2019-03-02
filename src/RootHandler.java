import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class RootHandler implements HttpHandler {

    private static String response = ""; //set to empty initially

    @Override
    public void handle(HttpExchange he) throws IOException {

        //TODO should tell the server it's got this request then wait for a reply

        Signaller.sendSignal(Signaller.SIGNAL.ROOT);

        he.sendResponseHeaders(200, response.length());

        OutputStream os = he.getResponseBody();

        os.write(response.getBytes());

        os.close();

        response = "";

    }

    //allow the fileserver sitting on top of the http server to write in the list of stuff in directory
    public static void writeRootResponse(String dirStr) {

        response = dirStr;

    }

}
