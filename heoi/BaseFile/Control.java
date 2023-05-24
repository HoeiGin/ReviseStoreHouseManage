package gin.heoi.BaseFile;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class Control {

    private static Control instance = null;

    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

    public static boolean insertToObject(Object fac) {
        boolean res = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "INSERT INTO smanage.object(OID, PID, ONAME, ODATE, ONUM, OCITY, OZONE) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fac.getOID());
            stmt.setString(2, fac.getPID());
            stmt.setString(3, fac.getONAME());
            stmt.setString(4, fac.getODATE());
            stmt.setInt(5, fac.getONUM());
            stmt.setString(6, fac.getOCITY());
            stmt.setString(7, fac.getOZONE());

            int i = stmt.executeUpdate();
            if (i == 1) {
                res = true;
            }
        }
        catch (SQLException e) {
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
        return res;
    }


    public static boolean insertToProducer(Producer fac) {
        boolean res = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "INSERT INTO smanage.producer(PID, PNAME, PCITY, PCALL) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fac.getPID());
            stmt.setString(2, fac.getPNAME());
            stmt.setString(3, fac.getPCITY());
            stmt.setLong(4, fac.getPCALL());

            int i = stmt.executeUpdate();
            if (i == 1) {
                res = true;
            }
        }
        catch (SQLException e) {
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
        return res;
    }

    public static String findLastId(int idx) {
        boolean res = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            if (idx == 1) {
                String sql = "select * from object order by OID desc limit 1";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    /*
                    Object obj = new Object(rs.getString("OID"),
                                            rs.getString("PID"),
                                            rs.getString("ONAME"),
                                            rs.getString("ODATE"),
                                            rs.getInt("ONUM"),
                                            rs.getString("OCITY"),
                                            rs.getString("OZONE"));
                     */
                    return rs.getString("OID");
                }
            }
            else if (idx == 0) {
                String sql = "select * from producer order by PID desc limit 1";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    /*
                    Object obj = new Object(rs.getString("OID"),
                                            rs.getString("PID"),
                                            rs.getString("ONAME"),
                                            rs.getString("ODATE"),
                                            rs.getInt("ONUM"),
                                            rs.getString("OCITY"),
                                            rs.getString("OZONE"));
                     */
                    return rs.getString("PID");
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
        return "NONE";
    }

    public static String getCity(String pid) {
        boolean res = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "SELECT * FROM producer WHERE PID = " + "'" + pid + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("PCITY");
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
        return "NONE";
    }

    public static boolean updateObject(int idx, String oid, String fac) {
        boolean res = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            if (idx == 1) {
                String sql_a = "UPDATE smanage.object SET PID = ? WHERE OID = ?";
                String sql_b = "UPDATE smanage.object SET OCITY = ? WHERE OID = ?";
                PreparedStatement stmt_a = conn.prepareStatement(sql_a);
                PreparedStatement stmt_b = conn.prepareStatement(sql_b);
                stmt_a.setString(1, fac);
                stmt_a.setString(2, oid);
                stmt_b.setString(1, getCity(fac));
                stmt_b.setString(2, oid);
                int f1 = stmt_a.executeUpdate();
                int f2 = stmt_b.executeUpdate();
                if (f1 == 1 && f2 == 1) {
                    res = true;
                }
            }
            else if (idx == 2) {
                String sql = "UPDATE smanage.object SET ONAME = ? WHERE OID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, fac);
                stmt.setString(2, oid);
                if (stmt.executeUpdate() == 1) {
                    res = true;
                }
            }
            else if (idx == 3) {
                String sql = "UPDATE smanage.object SET ODATE = ? WHERE OID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, fac);
                stmt.setString(2, oid);
                if (stmt.executeUpdate() == 1) {
                    res = true;
                }
            }
            else if (idx == 4) {
                String sql = "UPDATE smanage.object SET ONUM = ? WHERE OID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(fac));
                stmt.setString(2, oid);
                if (stmt.executeUpdate() == 1) {
                    res = true;
                }
            }
            else {
                String sql = "UPDATE smanage.object SET OZONE = ? WHERE OID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, fac);
                stmt.setString(2, oid);
                if (stmt.executeUpdate() == 1) {
                    res = true;
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
        return res;
    }

    public static boolean updateProducer(int idx, String pid, String fac) {
        boolean res = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            if (idx == 1) {
                String sql = "UPDATE smanage.producer SET PNAME = ? WHERE PID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, fac);
                stmt.setString(2, pid);
                if (stmt.executeUpdate() == 1) {
                    res = true;
                }
            }
            else if (idx == 2) {
                String sql_a = "UPDATE smanage.producer SET PCITY = ? WHERE PID = ?";
                String sql_b = "UPDATE smanage.object SET OCITY = ? WHERE PID = ?";
                PreparedStatement stmt_a = conn.prepareStatement(sql_a);
                PreparedStatement stmt_b = conn.prepareStatement(sql_b);
                stmt_a.setString(1, fac);
                stmt_a.setString(2, pid);
                stmt_b.setString(1, fac);
                stmt_b.setString(2, pid);
                if (stmt_a.executeUpdate() >= 0 && stmt_b.executeUpdate() >= 0) {
                    res = true;
                }
            }
            else if (idx == 3) {
                String sql = "UPDATE smanage.producer SET PCALL = ? WHERE PID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setLong(1, Long.parseLong(fac));
                stmt.setString(2, pid);
                if (stmt.executeUpdate() == 1) {
                    res = true;
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
        return res;
    }

    public static boolean deleteData(int idx, String id) {
        boolean res = false;
        Connection conn = null;
        try {
            conn = Connect.getConn();
            if (idx == 1) {
                String sql = "DELETE FROM smanage.object WHERE OID = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, id);
                if (stmt.executeUpdate() > 0) {
                    res = true;
                }
            }
            else if (idx == 2) {
                String sql_a = "DELETE FROM smanage.producer WHERE PID = ?";
                PreparedStatement stmt_a = conn.prepareStatement(sql_a);
                stmt_a.setString(1, id);
                String sql_b = "DELETE FROM smanage.object WHERE PID = ?";
                PreparedStatement stmt_b = conn.prepareStatement(sql_b);
                stmt_b.setString(1, id);

                if (stmt_a.executeUpdate() > 0 && stmt_b.executeUpdate() > 0) {
                    res = true;
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
        return res;
    }

    public static List<Object> getDataFromObject() {
        List<Object> storage = new ArrayList<Object>();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM smanage.object");
            while (rs.next()) {
                Object obj = new Object(rs.getString("OID"),
                        rs.getString("PID"),
                        rs.getString("ONAME"),
                        rs.getString("ODATE"),
                        rs.getInt("ONUM"),
                        rs.getString("OCITY"),
                        rs.getString("OZONE"));
                storage.add(obj);
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
        return storage;
    }

    public static String setNewID(int idx) {
        String last = findLastId(idx);
        if (idx == 1) {
            return "O" + Others.format(Integer.parseInt(last.substring(1)) + 1);
        }
        else {
            return "P" + Others.format(Integer.parseInt(last.substring(1)) + 1);
        }
    }

    public static List<Producer> getDataFromProducer() {
        List<Producer> storage = new ArrayList<Producer>();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM smanage.producer");
            while (rs.next()) {
                Producer pro = new Producer(rs.getString("PID"),
                        rs.getString("PNAME"),
                        rs.getString("PCITY"),
                        rs.getLong("PCALL"));
                storage.add(pro);
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
        return storage;
    }

    public static boolean exportObject(String path) {
        List<Object> dt = Control.getDataFromObject();
        String fPath = path + "\\";
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String saveTime = formatter.format(time);
        String file = "导出的仓储数据文件.csv";

        CSVPrinter printer = null;
        String toPath = fPath + saveTime + file;
        try {
            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (toPath,false),"GBK"));
            // FileWriter wri = new FileWriter(toPath);
            printer = CSVFormat.EXCEL.print(writer);
            java.lang.Object[] headCell = {"商品ID", "生产商ID", "商品名称", "操作日期", "库存数量", "生产地", "销售地"};
            printer.printRecord(headCell);
            for (Object i: dt) {
                java.lang.Object[] unitCell = {i.getOID(),
                        i.getPID(),
                        i.getONAME(),
                        i.getODATE(),
                        i.getONUM(),
                        i.getOCITY(),
                        i.getOZONE()};
                printer.printRecord(unitCell);
            }
            printer.flush();
            printer.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean exportProducer(String path) {
        List<Producer> dt = Control.getDataFromProducer();
        String fPath = path + "\\";
        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String saveTime = formatter.format(time);
        String file = "导出的生产商数据文件.csv";

        CSVPrinter printer = null;
        String toPath = fPath + saveTime + file;
        try {
            BufferedWriter writer = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (toPath,false),"GBK"));
            // FileWriter wri = new FileWriter(toPath);
            printer = CSVFormat.EXCEL.print(writer);
            java.lang.Object[] headCell = {"生产商ID", "生产商名称", "生产地", "联系方式"};
            printer.printRecord(headCell);
            for (Producer i: dt) {
                java.lang.Object[] unitCell = {i.getPID(),
                        i.getPNAME(),
                        i.getPCITY(),
                        i.getPCALL()};
                printer.printRecord(unitCell);
            }
            printer.flush();
            printer.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object searchFromObject(String oid) {
        Object fac = new Object();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "SELECT * FROM object WHERE OID = " + "'" + oid + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                fac = new Object(rs.getString("OID"),
                                 rs.getString("PID"),
                                 rs.getString("ONAME"),
                                 rs.getString("ODATE"),
                                 rs.getInt("ONUM"),
                                 rs.getString("OCITY"),
                                 rs.getString("OZONE"));
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
        return fac;
    }

    public static Producer searchFromProducer(String pid) {
        Producer fac = new Producer();
        Connection conn = null;
        try {
            conn = Connect.getConn();
            String sql = "SELECT * FROM producer WHERE pid = " + "'" + pid + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                fac = new Producer(rs.getString("PID"),
                        rs.getString("PNAME"),
                        rs.getString("PCITY"),
                        rs.getLong("PCALL"));
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
        return fac;
    }

    public static void refreshDate(String oid) {
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(date));
        updateObject(3, oid, formatter.format(date));
    }

}