package gin.heoi.Frame;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class INSERT extends JFrame {

    public static void main(String[] a) {
        new INSERT().action();
    }

    JButton search, confirm, reset;
    JTextField oid, pid, name, date, num, zone, city;
    JLabel toid, tpid, tname, tdate, tnum, tzone;
    JTextArea info;
    JScrollPane jsp;

    JPanel jp;




    public INSERT() {

        jp = new JPanel();
        jp.setLayout(null);


        oid = new JTextField(10);
        oid.setText(Control.setNewID(1));
        oid.setEditable(false);

        toid = new JLabel("商品ID");
        toid.setBounds(50, 50, 70, 30);
        jp.add(toid);

        oid.setBounds(140, 50, 100, 30);
        jp.add(oid);

        tpid = new JLabel("生产商ID");
        tpid.setBounds(50, 100, 70, 30);
        jp.add(tpid);

        pid = new JTextField(10);
        pid.setBounds(140, 100, 100, 30);
        jp.add(pid);

        search = new JButton("查询生产地");
        search.setBounds(50, 150, 70, 30);
        jp.add(search);

        city = new JTextField(10);
        city.setEditable(false);
        city.setBounds(140, 150, 70, 30);
        jp.add(city);

        tname = new JLabel("商品名称");
        tname.setBounds(50, 200, 70, 30);
        jp.add(tname);

        name = new JTextField(10);
        name.setBounds(140, 200, 100, 30);
        jp.add(name);

        Date d = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(d));

        tdate = new JLabel("操作日期");
        tdate.setBounds(50, 250, 70, 30);
        jp.add(tdate);

        date = new JTextField(10);
        date.setText(formatter.format(d));
        date.setBounds(140, 250, 100, 30);
        jp.add(date);


        tnum = new JLabel("入库数量");
        tnum.setBounds(50, 300, 70, 30);
        jp.add(tnum);

        num = new JTextField(10);
        num.setBounds(140, 300, 100, 30);
        jp.add(num);

        tzone = new JLabel("销售区域");
        tzone.setBounds(50, 350, 70, 30);
        jp.add(tzone);

        zone = new JTextField(10);
        zone.setBounds(140, 350, 100, 30);
        jp.add(zone);


        confirm = new JButton("确认");
        confirm.setBounds(50, 450, 75, 30);
        jp.add(confirm);

        reset = new JButton("重置");
        reset.setBounds(165, 450, 75, 30);
        jp.add(reset);

        info = new JTextArea(50, 40);
        info.setText("--------日志--------");
        info.setEditable(false);
        jsp = new JScrollPane(info);

        jsp.setBounds(290, 50, 300, 430);
        jp.add(jsp);


        this.add(jp);

        this.setTitle("新增数据");
        this.setSize(660, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/insert.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void action() {
        search.addActionListener(e -> city.setText(Control.getCity(pid.getText())));

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object f = new Object(oid.getText(),
                        pid.getText(),
                        name.getText(),
                        date.getText(),
                        Integer.parseInt(num.getText()),
                        Control.getCity(pid.getText()),
                        zone.getText());
                if (Control.insertToObject(f)) {
                    JOptionPane.showMessageDialog(null, "新增成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                    info.append("\n");
                    Date date1 = new Date(); // this object contains the current date value
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    info.append(formatter.format(date1));
                    info.append("新增商品的信息：\n" +
                            "商品ID：" + f.getOID() + "\n" +
                            "生产商ID：" + f.getPID() + "\n" +
                            "商品名称：" + f.getONAME() + "\n" +
                            "操作日期：" + formatter.format(date1) + "\n" +
                            "入库数量：" + f.getONUM() + "\n" +
                            "生产城市：" + f.getOCITY() + "\n" +
                            "销售区域：" + f.getOZONE() + "\n");
                }
                else {
                    JOptionPane.showMessageDialog(null, "操作失败！请检查对应操作！", "失败", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date2 = new Date(); // this object contains the current date value
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                oid.setText("");
                oid.setText(Control.setNewID(1));
                pid.setText("");
                city.setText("");
                name.setText("");
                date.setText(formatter.format(date2));
                num.setText("");
                zone.setText("");
            }
        });
    }
}
