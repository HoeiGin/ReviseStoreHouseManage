package gin.heoi.Frame.Merchant;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Object;
import gin.heoi.BaseFile.Producer;

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

    JPanel jp;

    JLabel tpid;
    JLabel tpname;
    JLabel tpcity;
    JLabel tpcall;
    JTextField pid;
    JTextField pname;
    JTextField pcity;
    JTextField pcall;
    JButton confirm;
    JButton reset;
    JTextArea info;

    public INSERT() {

        jp = new JPanel();
        jp.setLayout(null);

        tpid = new JLabel("生产商ID");
        tpname = new JLabel("名称");
        tpcity = new JLabel("所在地");
        tpcall = new JLabel("联系方式");

        pid = new JTextField(10);
        pid.setText(Control.setNewID(0));
        pid.setEditable(false);
        pname = new JTextField(15);
        pcity = new JTextField(15);
        pcall = new JTextField(15);

        confirm = new JButton("确认");
        reset = new JButton("重置");

        info = new JTextArea(80, 50);
        info.setEditable(false);

        tpid.setBounds(50, 50, 70, 30);
        pid.setBounds(150, 50, 70, 30);
        jp.add(tpid);
        jp.add(pid);

        tpname.setBounds(50, 100, 50, 30);
        pname.setBounds(130, 100, 90, 30);
        jp.add(tpname);
        jp.add(pname);

        tpcity.setBounds(50, 150, 50, 30);
        pcity.setBounds(130, 150, 90, 30);
        jp.add(tpcity);
        jp.add(pcity);

        tpcall.setBounds(50, 200, 50, 30);
        pcall.setBounds(130, 200, 90, 30);
        jp.add(tpcall);
        jp.add(pcall);

        confirm.setBounds(50, 250, 70, 30);
        reset.setBounds(150, 250, 70, 30);
        jp.add(confirm);
        jp.add(reset);

        info.setBounds(270, 50, 250, 230);
        jp.add(info);


        this.add(jp);

        this.setTitle("新增生产商数据");
        this.setSize(585, 380);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());

        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/merchantInsert.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void action() {
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pname.setText("");
                pcity.setText("");
                pcall.setText("");
                pid.setText(Control.setNewID(0));
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producer fac = new Producer(pid.getText(), pname.getText(), pcity.getText(), Long.parseLong(pcall.getText()));
                if (Control.insertToProducer(fac)) {
                    JOptionPane.showMessageDialog(null,"新增成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    String newInfo = formatter.format(date) + "新增了数据：\n" +
                                     "生产商ID：" + pid.getText() + "\n" +
                                     "生产商名称：" + pname.getText() + "\n" +
                                     "生产商所在地：" + pcity.getText() + "\n" +
                                     "生产商联系方式：" + pcall.getText() + "\n" + "\n";
                    info.append(newInfo);
                }
                else {
                    JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

