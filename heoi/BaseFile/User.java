package gin.heoi.BaseFile;

public class User {
    private String UID = "NONE";
    private String UNAME = "NONE";
    private String UPSW = "NONE";

    public User() {

    }

    public User(String uid, String uname, String upsw) {
        this.UID = uid;
        this.UNAME = uname;
        this.UPSW = upsw;
    }

    public void setUNAME(String uname) {
        this.UNAME = uname;
    }

    public void setUPSW(String upsw) {
        this.UPSW = upsw;
    }

}
