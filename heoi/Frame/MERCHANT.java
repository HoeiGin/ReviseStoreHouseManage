package gin.heoi.Frame;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Object;
import gin.heoi.BaseFile.Producer;
import gin.heoi.Frame.Merchant.DELETE;
import gin.heoi.Frame.Merchant.INSERT;
import gin.heoi.Frame.Merchant.REVISE;
import gin.heoi.Frame.Merchant.SEARCH;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MERCHANT extends JFrame {
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    JPanel jp;
    JTable table;
    JScrollPane jsp;

    String[] _columnName = {"生产商ID", "生产商名称", "生产地", "联系方式"};

    Vector<String> columnName = new Vector<>();
    Vector<Vector<String>> tableValue = new Vector<>();

    public static void main(String[] a) {
        new MERCHANT().action();
    }

    public MERCHANT() {
        jp = new JPanel();
        jp.setLayout(null);

        jb1 = new JButton("新增");
        jb1.setBounds(100, 50, 70, 30);
        jp.add(jb1);

        jb2 = new JButton("修改");
        jb2.setBounds(220, 50, 70, 30);
        jp.add(jb2);

        jb3 = new JButton("删除");
        jb3.setBounds(340, 50, 70, 30);
        jp.add(jb3);

        jb4 = new JButton("查询");
        jb4.setBounds(460, 50, 70, 30);
        jp.add(jb4);

        jb5 = new JButton("报表");
        jb5.setBounds(580, 50, 70, 30);
        jp.add(jb5);

        jb6 = new JButton("导出");
        jb6.setBounds(690, 50, 70, 30);
        jp.add(jb6);


        Collections.addAll(columnName, _columnName);


        table = new TABLE.MTable(tableValue, columnName);
        table.updateUI();
        // 关闭表格列的自动调整功能
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        // 选择模式为单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 被选择行的背景色为黄色
        table.setSelectionBackground(Color.YELLOW);
        // 被选择行的前景色（文字颜色）为红色
        table.setSelectionForeground(Color.RED);
        table.setRowHeight(30); // 表格的行高为30像素

        jsp = new JScrollPane(table);

        jsp.setBounds(100, 145, 670, 320);
        this.add(jsp);

        this.add(jp);
        this.setTitle("商户管理");
        this.setSize(877, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/merchant.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void action() {
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final List<Producer> userData = Control.getDataFromProducer();
                tableValue.clear();
                for (Producer i: userData) {
                    Vector<String> tmp = new Vector<>();
                    tmp.add(i.getPID());
                    tmp.add(i.getPNAME());
                    tmp.add(i.getPCITY());
                    tmp.add("" + i.getPCALL());
                    tableValue.add(tmp);
                }
                table.updateUI();
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new INSERT().action();
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new REVISE().action();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DELETE().action();
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SEARCH().action();
            }
        });

        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EXPORT(2);
            }
        });
    }
}
