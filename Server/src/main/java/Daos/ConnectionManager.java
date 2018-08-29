package Daos;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionManager {
    protected Connection conn;

    static {
        try {
            final String driver = "org.sqlite.JDBC";
            Class.forName(driver);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void openConnection()throws Exception{
        try{
            final String CONNECTION_URL = "jdbc:sqlite:D://jacob//Documents//FamilyMap//DBFamilyMap.db";
            //open connection
            System.out.println("Openning Connection");
            conn = DriverManager.getConnection(CONNECTION_URL);
            //start transaction
            conn.setAutoCommit(false);
        }catch(Exception err){
            System.out.println("opening connection failed.");
        }
    }

    public void closeConnection(boolean commit) throws Exception {
        try {
            if (commit) {
                System.out.println("Commiting Connection");
                conn.commit();
            }
            else {
                System.out.println("Rolling back Connection");
                conn.rollback();
            }
            conn.close();
            conn = null;
        }
        catch (Exception e) {
            conn.close();
            conn = null;
            System.out.println("Closing connection failed.");
        }
    }
    //Maybe we will make a custom Exception
    public void register() throws Exception{
        RegisterDao registerDao = new RegisterDao();
        registerDao.openConnection();
        System.out.println("CONNECTION MANAGER: Creating User");
        registerDao.createUser();
        registerDao.closeConnection(true);
    }

}
