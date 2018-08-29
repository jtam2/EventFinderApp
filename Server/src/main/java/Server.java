import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.net.*;

import Handlers.EventHandler;
import Handlers.LoginHandler;

public class Server {

    private static final int MAX_WAITING_CONNECTIONS = 12;
    private HttpServer server;
    private void run(String portNumber){

        System.out.println("Initializing HTTP Server");
        try{
            server = HttpServer.create(new InetSocketAddress(Integer.parseInt(portNumber)),MAX_WAITING_CONNECTIONS);
        }
        catch(Exception e){
            e.printStackTrace();
            return;
        }

        server.setExecutor(null);

        System.out.println("Creating contexts");
        server.createContext("/login", new LoginHandler());
        server.createContext("/event/",new EventHandler());

        server.start();


    }
    public static void main(String[] args){
        String portNumber = args[0];
        new Server().run(portNumber);
    }


}
