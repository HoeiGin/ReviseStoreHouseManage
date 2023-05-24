package gin.heoi.BaseFile;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Login {
    private static User once = null;

    public static User getOnce() {
        if (once == null) {
            once = new User();
        }
        return once;
    }

    private static boolean verify(String uname, String upsw) {
        Connection conn = null;
        try {
            conn = Connect.getConn();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM smanage.admin WHERE UNAME=" + "'" + uname + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
//                User allow = new User(rs.getString("UID"), rs.getString("UNAME"), rs.getString("UPSW"));
                System.out.println("Has Found " + uname);
                if (upsw.equals(rs.getString("UPSW"))) {
                    return true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean toLogin(String usn, String psw) {
        return verify(usn, psw);
    }

}
