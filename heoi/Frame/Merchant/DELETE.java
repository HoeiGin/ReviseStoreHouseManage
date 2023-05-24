package gin.heoi.Frame.Merchant;

import gin.heoi.BaseFile.Control;
import gin.heoi.BaseFile.Producer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DELETE extends JFrame {
    JPanel jp;
    JTextField jtf;
    JButton delete, search;
    JTextArea jta;
    JLabel jl;

    public static void main(String[] a) {
        new DELETE().action();
    }

    public DELETE() {
        jp = new JPanel();
        jp.setLayout(null);

        jl = new JLabel("待删除生产商的ID");
        jl.setBounds(50, 50, 125, 30);
        jtf = new JTextField(10);
        jtf.setBounds(195, 50, 70, 30);
        search = new JButton("搜索");
        delete = new JButton("删除");
        search.setBounds(50, 250, 90, 30);
        delete.setBounds(175, 250, 90, 30);
        jta = new JTextArea(30, 50);
        jta.setEditable(false);
        jta.setBounds(50, 100, 215, 120);

        jp.add(jl);
        jp.add(jtf);
        jp.add(search);
        jp.add(delete);
        jp.add(jta);

        this.add(jp);
        this.setTitle("删除商品");
        this.setSize(335, 380);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());

        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/merchantDelete.png");
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
                String pid = jtf.getText();
                Producer uinfo = Control.searchFromProducer(pid);
                jta.setText("");

                jta.setText(uinfo.getInfo());
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"确认", "返回"};
                if (JOptionPane.showOptionDialog(null,"注意：此举会同时删除相关的商品内容\n是否继续？","注意",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]) == 0) {
                    String pid = jtf.getText();
                    if (Control.deleteData(2, pid)) {
                        JOptionPane.showMessageDialog(null,"操作成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
