package Services;

import Daos.ConnectionManager;
import Requests.RegisterRequest;
import Responses.RegisterResponse;

public class LoginService {

    private RegisterResponse response = new RegisterResponse();

    //We might want to Throw a differentException. Maybe Make an custom Exception
    public RegisterResponse login(RegisterRequest request) throws Exception{

        ConnectionManager connectionManager = new ConnectionManager();
        //Call login on connection Manager.

        return null;
    }

}
