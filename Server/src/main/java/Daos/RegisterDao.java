package Daos;

import java.sql.PreparedStatement;

public class RegisterDao extends ConnectionManager{

    public void createUser() throws Exception{
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO Users()";//FIXME: Still need to finish
    }
}
