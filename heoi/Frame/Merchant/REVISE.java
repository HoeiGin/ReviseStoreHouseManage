package gin.heoi.Frame.Merchant;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Producer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class REVISE extends JFrame {
    public static void main(String[] a) {
        new REVISE().action();
    }

    JLabel tpid, thing;
    JTextField pid, th;
    JButton confirm, reset, search;
    JRadioButton name, city, call;
    ButtonGroup btg;
    JPanel jp;
    JTextArea board;

    public REVISE() {
        jp = new JPanel();
        jp.setLayout(null);

        tpid = new JLabel("生产商ID");
        tpid.setBounds(50, 40, 70, 30);
        pid = new JTextField(10);
        pid.setBounds(150, 40, 195, 30);
        jp.add(tpid);
        jp.add(pid);

        JPanel inside = new JPanel();
        inside.setBorder(new TitledBorder(new EtchedBorder(), "修改项"));
        inside.setLayout(null);
        inside.setBounds(45, 100, 300, 200);
        name = new JRadioButton("名称");
        city = new JRadioButton("城市");
        call = new JRadioButton("联系方式");

        btg = new ButtonGroup();
        btg.add(name);
        btg.add(city);
        btg.add(call);

        name.setBounds(30, 30, 50, 30);
        city.setBounds(100, 30, 50, 30);
        call.setBounds(180, 30, 100, 30);
        inside.add(name);
        inside.add(city);
        inside.add(call);
        jp.add(inside);

        board = new JTextArea(50, 50);
        board.setBounds(375, 105, 265, 195);
        board.setEditable(false);
        jp.add(board);

        search = new JButton("搜索");
        confirm = new JButton("确认");
        reset = new JButton("重置");
        search.setBounds(375, 40, 75, 30);
        confirm.setBounds(470, 40, 75, 30);
        reset.setBounds(565, 40, 75, 30);
        jp.add(confirm);
        jp.add(search);
        jp.add(reset);

        thing = new JLabel("请输入修改后的内容");
        th = new JTextField(10);
        thing.setBounds(30, 80, 135, 30);
        th.setBounds(30, 130, 135, 30);
        inside.add(thing);
        inside.add(th);


        this.add(jp);

        this.setTitle("修改生产商");
        this.setSize(720, 380);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/merchantRevise.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void action() {
        search.addActionListener(e -> {
            String id = pid.getText();
            Producer fac = Control.searchFromProducer(id);
            board.setText("");
            board.setText(fac.getInfo());
        });

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.isSelected()) {
                    if (Control.updateProducer(1, pid.getText(), th.getText())) {
                        JOptionPane.showMessageDialog(null,"操作成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (city.isSelected()) {
                    if (Control.updateProducer(2, pid.getText(), th.getText())) {
                        JOptionPane.showMessageDialog(null,"操作成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (call.isSelected()) {
                    if (Control.updateProducer(3, pid.getText(), th.getText())) {
                        JOptionPane.showMessageDialog(null,"操作成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pid.setText("");
                th.setText("");
                board.setText("");
            }
        });
    }

}
