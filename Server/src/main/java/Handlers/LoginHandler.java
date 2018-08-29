package Handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;

import Requests.RegisterRequest;
import Responses.RegisterResponse;
import Services.LoginService;

public class LoginHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try{
            boolean success = false;
            if(exchange.getRequestMethod().toLowerCase().equals("post")){

                Gson gson = new Gson();
                //convert string into response
                RegisterRequest reqData = gson.fromJson(new InputStreamReader(exchange.getRequestBody()), RegisterRequest.class);
                LoginService loginService = new LoginService();

                //In side this method is where the everything happens.
                RegisterResponse loginResponse = loginService.login(reqData);
                //loginResponse.setError("Success!");
                //write response to my exchange.
                Writer writer = new OutputStreamWriter(exchange.getResponseBody());

                writer.write(gson.toJson(loginResponse));
                //Sending a 200
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,0);
                writer.flush();

                exchange.getResponseBody().close();
                success = true;
            }

            if(!success){
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST,0);
                exchange.getResponseBody().close();
            }
        }
        catch(Exception e){
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}
