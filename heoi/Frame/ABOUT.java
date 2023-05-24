package gin.heoi.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ABOUT extends JFrame {
    JLabel author, version, info1, info2, info3, info4;
    JLabel pic;
    JButton confirm;
    JPanel jp;
    JLabel jl1, jl2;
    private int times = 0;
    public static void main(String[] a) {
        new ABOUT().action();
    }

    public ABOUT() {
        jp = new JPanel();
        jp.setLayout(null);
        author = new JLabel("作者: Jonas");
        version = new JLabel("版本: 1.0.3");
        info1 = new JLabel("许键");
        info2 = new JLabel("华南师范大学");
        info3 = new JLabel("人工智能学院");
        info4 = new JLabel("20214001078");

        confirm = new JButton("确认");
        pic = new JLabel();
        pic.setIcon(new ImageIcon("src/main/java/gin/heoi/Pic/jonas.jpg"));
        jl1 = new JLabel("Jonas");
        jl2 = new JLabel("GinHeoi@outlook.com");
        jl1.setFont(new Font("苹方黑体-中粗-简", Font.BOLD, 24));
        jl2.setFont(new Font("苹方黑体-中粗-简", Font.PLAIN, 15));

        pic.setBounds(50, 50, 165, 165);
        jl1.setBounds(50, 240, 75, 30);
        jl2.setBounds(50, 275, 175, 30);
        author.setBounds(325, 50, 100, 20);
        version.setBounds(325, 80, 100, 20);
        info1.setBounds(325, 110, 100, 20);
        info2.setBounds(325, 140, 100, 20);
        info3.setBounds(325, 170, 100, 20);
        info4.setBounds(325, 200, 100, 20);
        confirm.setBounds(325, 250, 70, 30);


        jp.add(pic);
        jp.add(jl1);
        jp.add(jl2);
        jp.add(author);
        jp.add(version);
        jp.add(info1);
        jp.add(info2);
        jp.add(info3);
        jp.add(info4);
        jp.add(confirm);

        this.add(jp);
        this.setTitle("关于");
        this.setSize(500, 400);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());
        ImageIcon ico = new ImageIcon("src/main/java/gin/heoi/Pic/icon/surprise.png");
        this.setIconImage(ico.getImage());
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void action() {
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABOUT.super.dispose();
            }
        });

        pic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                times ++;
                if (times == 10) {
                    JOptionPane.showMessageDialog(null,"你发现了彩蛋！","彩蛋",JOptionPane.INFORMATION_MESSAGE);
                    times = 0;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
