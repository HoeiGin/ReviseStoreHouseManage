package gin.heoi.Frame;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;

public class SEARCH extends JFrame {
    public static void main(String[] a) {
        new SEARCH().action();
    }

    JPanel jp;
    JButton search, reset;
    JLabel jl;
    JTextField jtf;
    JTable table;
    JScrollPane jsp;

    String[] _columnName = {"商品ID", "生产商ID", "商品名称", "操作日期", "库存数量", "生产地", "销售地"};
    Vector<String> columnName = new Vector<>();
    Vector<Vector<String>> tableValue = new Vector<>();

    public SEARCH() {
        jp = new JPanel();
        jp.setLayout(null);

        jl = new JLabel("商品ID");
        jtf = new JTextField(10);
        search = new JButton("确认");
        reset = new JButton("清空");

        jl.setBounds(100, 50, 50, 30);
        jtf.setBounds(180, 50, 280, 30);
        search.setBounds(520, 50, 100, 30);
        reset.setBounds(650, 50, 100, 30);
        jp.add(jl);
        jp.add(jtf);
        jp.add(search);
        jp.add(reset);


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

        jsp.setBounds(50, 130, 760, 350);
        jp.add(jsp);



        this.add(jp);

        this.add(jp);
        this.setTitle("信息查找");
        this.setSize(877, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/search.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void action() {
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object ce = Control.searchFromObject(jtf.getText());
                Vector<String> toIn = new Vector<String>();
                toIn.add(ce.getOID());
                toIn.add(ce.getPID());
                toIn.add(ce.getONAME());
                toIn.add(ce.getODATE());
                toIn.add("" + ce.getONUM());
                toIn.add(ce.getOCITY());
                toIn.add(ce.getOZONE());
                tableValue.add(toIn);
                table.updateUI();
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
                tableValue.clear();
                table.updateUI();
            }
        });
    }
}
