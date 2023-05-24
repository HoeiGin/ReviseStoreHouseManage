package gin.heoi.Frame;

import gin.heoi.BaseFile.Control;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EXPORT extends JFrame {
    JFileChooser jfc;
    String path;

    public EXPORT(int mode) {
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        Date time = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");


        Component parent = null;
        int returnVal = jfc.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = jfc.getSelectedFile().getPath();
        }

        if (mode == 1) {
            if (Control.exportObject(path)) {
                JOptionPane.showMessageDialog(null,"导出成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                try {
                    String isSelect = path + "\\" + formatter.format(time) + "导出的仓储数据文件.csv";
                    Runtime.getRuntime().exec("explorer /select, " + isSelect);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"导出失败！","失败",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (mode == 2) {
            if (Control.exportProducer(path)) {
                JOptionPane.showMessageDialog(null,"导出成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                try {
                    String isSelect = path + "\\" + formatter.format(time) + "导出的生产商数据文件.csv";
                    Runtime.getRuntime().exec("explorer /select, " + isSelect);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"导出失败！","失败",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
