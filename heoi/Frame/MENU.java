package gin.heoi.Frame;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Object;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MENU extends JFrame {
    JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10;
    JPanel jp1;

    JLabel jl1;
    JScrollPane jsp;
    JTable table;

    JTextField jtf;
    JTextArea jta;
    String welcome = "欢迎使用仓储管理系统！";

    String[] _columnName = {"商品ID", "生产商ID", "商品名称", "操作日期", "库存数量", "生产地", "销售地"};
    Vector<String> columnName = new Vector<>();
    Vector<Vector<String>> tableValue = new Vector<>();



    public static void main(String[] a) {
        MENU m = new MENU();
        m.action();
    }

    public MENU() {

        Collections.addAll(columnName, _columnName);


        jp1 = new JPanel();
        jp1.setLayout(null);


        jtf = new JTextField(100);
        jta = new JTextArea(100, 100);
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(date));
        jta.setText("用户名: admin" + "\n");
        jta.append("版本号: 1.0.3\n");
        jta.append("登录时间：\n" + formatter.format(date));


        jb1 = new JButton("新增");
        jb2 = new JButton("修改");
        jb3 = new JButton("查询");
        jb4 = new JButton("删除");
        jb5 = new JButton("报表");
        jb6 = new JButton("商户");
        jb7 = new JButton("导出");
        jb8 = new JButton("关于");
        jb9 = new JButton("注销");
        jb10 = new JButton("退出");


        jb1.setBounds(50, 50, 70, 30);
        jp1.add(jb1);

        jb2.setBounds(50, 100, 70, 30);
        jp1.add(jb2);

        jb3.setBounds(50, 150, 70, 30);
        jp1.add(jb3);

        jb4.setBounds(50, 200, 70, 30);
        jp1.add(jb4);

        jb5.setBounds(140, 50, 70, 30);
        jp1.add(jb5);

        jb6.setBounds(140, 100, 70, 30);
        jp1.add(jb6);

        jb7.setBounds(140, 150, 70, 30);
        jp1.add(jb7);

        jb8.setBounds(140, 200, 70, 30);
        jp1.add(jb8);

        jb9.setBounds(50, 250, 160, 30);
        jp1.add(jb9);

        jb10.setBounds(50, 300, 160, 30);
        jp1.add(jb10);

        jtf.setEditable(false);

        jtf.setText(welcome);
        jtf.setBounds(0, 540, 1185, 25);
        jp1.add(jtf);


        jta.setBounds(50, 350, 160, 135);
        jta.setEditable(false);

        jp1.add(jta);



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

        jsp.setBounds(260, 50, 870, 440);
        jp1.add(jsp);






        this.add(jp1);



        this.setTitle("仓储管理系统");
        this.setSize(1200, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/menu.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void action() {
        jb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new INSERT().action();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("向仓库中增加新的物品");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new REVISE().action();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("修改仓库内物品的数据");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SEARCH().action();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("查询仓库内的相关数据");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new DELETE().action();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("删除仓库内某一项物品");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final List<Object> userData = Control.getDataFromObject();
                tableValue.clear();
                for (Object i: userData) {
                    Vector<String> tmp = new Vector<>();
                    tmp.add(i.getOID());
                    tmp.add(i.getPID());
                    tmp.add(i.getONAME());
                    tmp.add(i.getODATE());
                    tmp.add("" + i.getONUM());
                    tmp.add(i.getOCITY());
                    tmp.add(i.getOZONE());
                    tableValue.add(tmp);
                }
                table.updateUI();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("查看仓库内的所有物品信息");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MERCHANT().action();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("操作在账的相关商户信息");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb7.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new EXPORT(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("将仓库内物品的信息以Excel文件格式导出");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb8.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ABOUT().action();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("该系统的相关信息");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb9.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MENU.super.dispose();
                new LOGIN().action();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("退出账户登录");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });

        jb10.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jtf.setText("");
                jtf.setText("退出软件");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jtf.setText("");
                jtf.setText(welcome);
            }
        });
    }

}
