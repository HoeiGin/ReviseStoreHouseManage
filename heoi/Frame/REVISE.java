package gin.heoi.Frame;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Object;
import gin.heoi.BaseFile.Producer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class REVISE extends JFrame {


    JPanel jp, jp1, jp2, jp3;
    JButton jb1, jb2, jb3, jb4;
    JTextField jtf1, jtf2, jtf3, jtf4;
    JLabel jl1, jl2, jl3, jl4;
    JTextArea jta;
    JRadioButton jr1;
    JRadioButton jr2;
    ButtonGroup btg;
    JButton jb;
    JTextField jtf;
    JTextField jtff;
    JPanel jp4;
    JLabel jl5;
    JTextField jtf5;
    JButton jb5, c;

    public static void main(String[] a) {
        new REVISE().action();
    }

    public REVISE() {
        jp = new JPanel();
        jp.setLayout(null);

        jl1 = new JLabel("商品ID");
        jl1.setBounds(50, 50, 70, 30);
        jp.add(jl1);

        jtf1 = new JTextField(10);
        jtf1.setBounds(140, 50, 70, 30);
        jp.add(jtf1);

        jb1 = new JButton("查询");
        jb1.setBounds(50, 100, 70, 30);
        jp.add(jb1);

        jb2 = new JButton("清空");
        jb2.setBounds(140, 100, 70, 30);
        jp.add(jb2);

        jta = new JTextArea(30, 50);
        jta.setEditable(false);
        jta.setBounds(50, 150, 160, 120);
        jp.add(jta);


        jp1 = new JPanel();
        jp1.setLayout(null);
        jp1.setBorder(new TitledBorder(new EtchedBorder(), "修改商品数量"));
        jp1.setBounds(245, 35, 370, 130);

        jr1 = new JRadioButton("进库");
        jr2 = new JRadioButton("出库");
        btg = new ButtonGroup();
        btg.add(jr1);
        btg.add(jr2);
        jl2 = new JLabel("请输入操作数量");
        jtf2 = new JTextField(10);
        c = new JButton("确认");

        jr1.setBounds(30, 30, 50, 30);
        jr2.setBounds(100, 30, 50, 30);
        jl2.setBounds(30, 70, 100, 30);
        jtf2.setBounds(150, 70, 100, 30);
        c.setBounds(270, 70, 70, 30);

        jp1.add(jr1);
        jp1.add(jr2);
        jp1.add(jl2);
        jp1.add(jtf2);
        jp1.add(c);
        jp.add(jp1);

        jl3 = new JLabel("请输入商品的名称");
        jtf3 = new JTextField(20);
        jb3 = new JButton("确认");
        jp2 = new JPanel();
        jp2.setLayout(null);
        jp2.setBorder(new TitledBorder(new EtchedBorder(), "修改商品名称"));
        jp2.setBounds(245, 185, 370, 90);
        jl3.setBounds(30, 30, 100, 30);
        jtf3.setBounds(150, 30, 100, 30);
        jb3.setBounds(270, 30, 70, 30);

        jp2.add(jl3);
        jp2.add(jtf3);
        jp2.add(jb3);
        jp.add(jp2);

        jl4 = new JLabel("新的生产商代码");
        jb4 = new JButton("确认");
        jb = new JButton("查询");

        jtf = new JTextField(10);
        jtff = new JTextField(20);
        jtff.setEditable(false);
        jtf.setEditable(false);
        jtf4 = new JTextField(10);
        jp3 = new JPanel();
        jp3.setLayout(null);
        jp3.setBorder(new TitledBorder(new EtchedBorder(), "修改商品生产商"));
        jp3.setBounds(50, 300, 265, 200);

        jl4.setBounds(30, 30, 100, 30);
        jtf4.setBounds(150, 30, 85, 30);
        jb.setBounds(30, 70, 70, 30);
        jtf.setBounds(120, 70, 115, 30);
        jb4.setBounds(30, 150, 70, 30);
        jtff.setBounds(30, 110, 205, 30);
        jp3.add(jl4);
        jp3.add(jtf4);
        jp3.add(jb);
        jp3.add(jtf);
        jp3.add(jb4);
        jp3.add(jtff);
        jp.add(jp3);



        jp4 = new JPanel();
        jp4.setLayout(null);
        jp4.setBorder(new TitledBorder(new EtchedBorder(), "修改商品销售区"));
        jp4.setBounds(345, 300, 265, 200);
        jl5 = new JLabel("新的商品销售区");
        jtf5 = new JTextField(10);
        jb5 = new JButton("确认");
        jl5.setBounds(30, 30, 100, 30);
        jtf5.setBounds(30, 80, 100, 30);
        jb5.setBounds(30, 130, 100, 30);
        jp4.add(jl5);
        jp4.add(jtf5);
        jp4.add(jb5);

        jp.add(jp4);

        this.add(jp);

        this.setTitle("修改数据");
        this.setSize(660, 600);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/revise.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void action() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
                jta.setText(Control.searchFromObject(jtf1.getText()).getInfo());
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.setText("");
                jtf1.setText("");
                jtf2.setText("");
                jtf3.setText("");
                jtf.setText("");
                jtff.setText("");
                jtf4.setText("");
                jtf5.setText("");
            }
        });

        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int be = Control.searchFromObject(jtf1.getText()).getONUM();
                if (jr1.isSelected()) {
                    int newNum = be + Integer.parseInt(jtf2.getText());
                    if (Control.updateObject(4, jtf1.getText(), "" + newNum)) {
                        Control.refreshDate(jtf1.getText());
                        JOptionPane.showMessageDialog(null,"修改成功！新的数量为" + newNum,"成功",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (jr2.isSelected()) {
                    int newNum = be - Integer.parseInt(jtf2.getText());
                    if (Control.updateObject(4, jtf1.getText(), "" + newNum)) {
                        Control.refreshDate(jtf1.getText());
                        JOptionPane.showMessageDialog(null,"修改成功！新的数量为" + newNum,"成功",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Control.updateObject(2, jtf1.getText(), jtf3.getText())) {
                    Control.refreshDate(jtf1.getText());
                    JOptionPane.showMessageDialog(null,"修改成功！新的名称为\n" + jtf3.getText(),"成功",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producer ce = Control.searchFromProducer(jtf4.getText());
                jtf.setText("");
                jtff.setText("");
                jtf.setText(ce.getPCITY());
                jtff.setText(ce.getPNAME());
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producer ce = Control.searchFromProducer(jtf4.getText());
                if (Control.updateObject(1, jtf1.getText(), ce.getPID())) {
                    Control.refreshDate(jtf1.getText());
                    JOptionPane.showMessageDialog(null,"修改成功！新的生产商为\n" + ce.getPNAME(),"成功",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Control.updateObject(5, jtf1.getText(), jtf5.getText())) {
                    Control.refreshDate(jtf1.getText());
                    JOptionPane.showMessageDialog(null,"修改成功！\n新的销售区域为" + jtf5.getText(),"成功",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
