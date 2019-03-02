import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class PrimHTTPServer {

    public PrimHTTPServer(int port) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", new RootHandler());
        server.createContext("/get", new GetHandler());
        server.createContext("/post", new PostHandler());

        server.setExecutor(null);

        server.start();

    }





}
