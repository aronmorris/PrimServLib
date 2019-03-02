import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class GetHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        //read request for desired file
        Map<String, Object> params = new HashMap<String, Object>();

        URI requestedURI = httpExchange.getRequestURI();

        String query = requestedURI.getRawQuery();

        QueryParser.parseQuery(query, params);
        
        //and send the contents of that file (as text)

        //TODO put the proper logic in here
        String response = "get response";

        Signaller.sendSignal(Signaller.SIGNAL.GET);



    }

}
