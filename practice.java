package Hospital;

import javax.swing.*;
import java.awt.*;

public class practice extends JFrame {
    JFrame f;
    JLabel l1,l3,l2,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    practice(){
        f=new JFrame("tk");
        f.setBackground(Color.WHITE);
        f.setLayout(null);


        l1 = new JLabel("Annual Rate: ");
        l1.setBounds(20, 10, 150, 20);
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
        l1.setForeground(Color.BLACK);
        f.add(l1);

        l2 = new JLabel("Number of Payments: ");
        l2.setBounds(20, 40, 250, 20);
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        l2.setForeground(Color.BLACK);
        f.add(l2);

        l3 = new JLabel("Loan Principle: ");
        l3.setBounds(20, 70, 200, 20);
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setForeground(Color.BLACK);
        f.add(l3);

        l4 = new JLabel("Monthly Payment: ");
        l4.setBounds(20, 100, 200, 20);
        l4.setFont(new Font("Arial", Font.PLAIN, 20));
        l4.setForeground(Color.BLACK);
        f.add(l4);

        l5 = new JLabel("Remaining Loan: ");
        l5.setBounds(20, 130, 200, 20);
        l5.setFont(new Font("Arial", Font.PLAIN, 20));
        l5.setForeground(Color.BLACK);
        f.add(l5);

        t1 = new JTextField();
        t1.setBounds(310, 10, 250, 20);
        f.add(t1);

        t2 = new JTextField();
        t2.setBounds(310, 40, 250, 20);
        f.add(t2);

        t3 = new JTextField();
        t3.setBounds(310, 70, 250, 20);
        f.add(t3);

        t4 = new JTextField();
        t4.setBounds(310, 100, 250, 20);
        f.add(t4);

        t5 = new JTextField();
        t5.setBounds(310, 130, 250, 20);
        f.add(t5);

        b1 = new JButton("Final Balance");
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setForeground(Color.BLACK);
        b1.setBounds(20, 220, 150, 30);
        f.add(b1);

        b2 = new JButton("Monthly Payment");
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setForeground(Color.BLACK);
        b2.setBounds(200, 220, 150, 30);
        f.add(b2);

        b3 = new JButton("Quit");
        b3.setBackground(Color.LIGHT_GRAY);
        b3.setForeground(Color.BLACK);
        b3.setBounds(390, 220, 150, 30);
        f.add(b3);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setLocation(300, 100);
        f.setResizable(false);
    }

    public static void main(String[] args) {
        new practice();
    }
}
