package gin.heoi.BaseFile;

public class Producer {
    private String PID = "p0";
    private String PNAME = "NONE";
    private String PCITY = "NONE";
    private long PCALL = 1111111111;

    public Producer() {

    }

    public Producer(String pid, String pname, String pcity, long pcall) {
        this.PID = pid;
        this.PNAME = pname;
        this.PCITY = pcity;
        this.PCALL = pcall;
    }

    public void setPID(String pid) {
        this.PID = pid;
    }

    public void setPNAME(String pname) {
        this.PNAME = pname;
    }

    public void setPCITY(String pcity) {
        this.PCITY = pcity;
    }

    public void setPCALL(long pcall) {
        this.PCALL = pcall;
    }

    public String getPID() {
        return this.PID;
    }

    public String getPNAME() {
        return this.PNAME;
    }

    public String getPCITY() {
        return this.PCITY;
    }

    public long getPCALL() {
        return this.PCALL;
    }

    public String toString() {
        return "{" + this.PID + ", " + this.PNAME + ", " + this.PCITY + ", " + this.PCALL + "}";
    }

    public String getInfo() {
        return "生产商ID：" + this.PID + "\n" +
                "生产商名称：" + this.PNAME + "\n" +
                "生产商所在地：" + this.PCITY + "\n" +
                "生产商联系方式：" + "" + this.PCALL;
    }

}
