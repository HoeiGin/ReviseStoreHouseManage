package gin.heoi.BaseFile;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private static Connection conn = null;
    public static Connection getConn() {
        // uname: the username of database
        // psw: the password of database
        String uname = "root"; // Your username
        String psw = "psw123456";   // Your password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/smanage";
            conn = DriverManager.getConnection(url, uname, psw);
        }
        catch (Exception e) {
            System.out.println("Fail to connect the database");
            e.printStackTrace();
        }
        return conn;
    }
}
