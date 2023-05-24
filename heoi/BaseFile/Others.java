package gin.heoi.BaseFile;

import java.io.*;

public class Others {

    public static String format(int toFormat) {
        String base = "" + toFormat;
        if (base.length() < 4) {
            String res = "";
            for (int i = 0; i < 4 - base.length(); i++) {
                res = res + "0";
            }
            return (res + base);
        }
        else {
            return base;
        }
    }


}
