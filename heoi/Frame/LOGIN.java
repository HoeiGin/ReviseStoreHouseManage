package gin.heoi.Frame;

import gin.heoi.BaseFile.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LOGIN extends JFrame {
    JPanel jp1, jp2, jp3, jp4;
    JButton jb1, jb2;
    JLabel jl1, jl2, jl3;
    JTextField jtf;
    JPasswordField jpf;

    public static void main(String[] args) {
        LOGIN lg = new LOGIN();
        lg.action();
    }

    public LOGIN() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jb1 = new JButton("登录");
        jb2 = new JButton("退出");

        jl1 = new JLabel();
        jl2 = new JLabel();
        jl3 = new JLabel();

        jl1.setIcon(new ImageIcon("src/main/java/gin/heoi/Pic/pic01.jpg"));
        jp1.add(jl1);

        jl2 = new JLabel("账号:");
        jl3 = new JLabel("密码:");

        jtf = new JTextField(15);
        jpf = new JPasswordField(15);

        jp2.add(jl2);
        jp2.add(jtf);

        jp3.add(jl3);
        jp3.add(jpf);

        jp4.add(jb1);
        jp4.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        this.setLayout(new FlowLayout());

        this.setSize(350, 300);
        this.setTitle("欢迎登录仓储管理系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/login.png");
        this.setIconImage(ico.getImage());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    }

    public void action() {
        jb1.addActionListener(e -> {
            String uName = jtf.getText();
            char[] psw = jpf.getPassword();
            String uPass = "";
            for (char i: psw) {
                uPass += i;
            }
            if (Login.toLogin(uName, uPass)) {
                new MENU().action();
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "登录失败！请检查用户名与密码是否正确！",
                        "登陆失败",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        jb2.addActionListener(e -> System.exit(0));
    }
}
