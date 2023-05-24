package gin.heoi.Frame;

import gin.heoi.BaseFile.Control;

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

        jl = new JLabel("请输入待删除物品的ID");
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
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/delete.png");
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
                jta.setText("");
                jta.setText(Control.searchFromObject(jtf.getText()).getInfo());
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Control.deleteData(1, jtf.getText())) {
                    JOptionPane.showMessageDialog(null,"删除成功！","成功",JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"操作失败！","失败",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
