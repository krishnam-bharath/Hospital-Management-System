package Hospital;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3;
    JButton b1, b2, b3, b4;
    int loginId;

    Index() {
        f = new JFrame("Index Page");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 800, 570);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/icons/first page.jpg"));
        Image i1 = img.getImage().getScaledInstance(800, 570, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        f.add(l1);

        l2 = new JLabel("Same As Usual Group");
        l2.setBounds(70, 315, 500, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        l3 = new JLabel("Provide best quality healthcare for you");
        l3.setBounds(86, 340, 500, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 14));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        b1 = new JButton("Doctor");
        b1.setBounds(50, 390, 150, 40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l1.add(b1);

        b2 = new JButton("Patient");
        b2.setBounds(220, 390, 150, 40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l1.add(b2);

        b3 = new JButton("Receptionist");
        b3.setBounds(50, 450, 150, 40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        l1.add(b3);

        b4 = new JButton("Admin");
        b4.setBounds(220, 450, 150, 40);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        l1.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        f.setSize(800, 570);
        f.setLocation(300, 100);
        f.setVisible(true);
        f.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            loginId=1;
            f.setVisible(false);
            new LoginPage(loginId);
        } else if (ae.getSource() == b2) {
            loginId=2;
            f.setVisible(false);
            new LoginPage(loginId);
        } else if (ae.getSource() == b3) {
            loginId=3;
            f.setVisible(false);
            new LoginPage(loginId);
        } else if (ae.getSource() == b4) {
            loginId=4;
            f.setVisible(false);
            new LoginPage(loginId);
        }
    }

    public static void main(String[] args) {
        new Index();
    }
}
