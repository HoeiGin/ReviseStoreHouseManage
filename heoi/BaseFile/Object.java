package gin.heoi.BaseFile;


public class Object {
    private String OID = "o0";
    private String PID = "p0";
    private String ONAME = "NONE";
    private String ODATE = "1970-01-01";
    private int ONUM = -1;
    private String OCITY = "NONE";
    private String OZONE = "NONE";

    public Object() {

    }

    public Object(String oid, String pid, String oname, String odate, int onum, String ocity, String ozone) {
        this.OID = oid;
        this.PID = pid;
        this.ONAME = oname;
        this.ODATE = odate;
        this.ONUM = onum;
        this.OCITY = ocity;
        this.OZONE = ozone;
    }

    public void setOID(String oid) {
        this.OID = oid;
    }

    public void setPID(String pid) {
        this.PID = pid;
    }

    public void setONAME(String oname) {
        this.ONAME = oname;
    }

    public void setODATE(String odate) {
        this.ODATE = odate;
    }

    public void setONUM(int onum) {
        this.ONUM = onum;
    }

    public void setOCITY(String ocity) {
        this.OCITY = ocity;
    }

    public void setOZONE(String ozone) {
        this.OZONE = ozone;
    }

    public String getOID() {
        return this.OID;
    }

    public String getPID() {
        return this.PID;
    }

    public String getONAME() {
        return this.ONAME;
    }

    public String getODATE() {
        return this.ODATE;
    }

    public int getONUM() {
        return this.ONUM;
    }

    public String getOCITY() {
        return this.OCITY;
    }

    public String getOZONE() {
        return this.OZONE;
    }

    public String toString() {
        return "{" + this.OID + ", " + this.PID + ", " + this.ONAME + ", " + this.ODATE + ", " + this.ONUM + ", "
                + this.OCITY + ", " + this.OZONE + "}";
    }

    public String getInfo() {
        return "商品ID：" + this.OID + "\n" +
               "生产商ID：" + this.PID + "\n" +
               "商品名称：" + this.ONAME + "\n" +
               "操作日期：" + this.ODATE + "\n" +
               "库存：" + this.ONUM + "\n" +
               "生产地：" + this.OCITY + "\n" +
               "销售区域：" + this.OZONE + "\n";
    }
}
