package Hospital;
import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4;
    JTextField tf;
    JPasswordField pf;
    JButton bt1, bt2;
    int loginId;

    LoginPage(int login_id) {
        f = new JFrame("Login Page");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        loginId=login_id;

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/icons/admin Login.jpg"));
        Image i = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);

        f.add(l1);

        l2 = new JLabel("Login Page");
        l2.setBounds(190, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);

        l3 = new JLabel("Username: ");
        l3.setBounds(130, 120, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        l4 = new JLabel("Password: ");
        l4.setBounds(130, 170, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf = new JTextField();
        tf.setBounds(310, 120, 150, 30);
        l1.add(tf);

        pf = new JPasswordField();
        pf.setBounds(310, 170, 150, 30);
        l1.add(pf);

        bt1 = new JButton("Login");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(130, 220, 150, 40);
        l1.add(bt1);

        bt2 = new JButton("Back");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(310, 220, 150, 40);
        l1.add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 350);
        f.setLocation(300, 100);
        f.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt1) {
            try{
                ConnectionClass obj=new ConnectionClass();
                String name=tf.getText();
                String pass=pf.getText();
                ResultSet rs;
                if(loginId==1){
                    String q="select * from doctor where username='"+name+"'and password='"+pass+"'";
                    rs=obj.stm.executeQuery(q);
                    if(rs.next()){
                        String doctorname=rs.getString("name");
                        String doctor_id=rs.getString("doc_id");
                        String doctor_username=rs.getString("username");
                        new DoctorHomePage(doctorname,doctor_id,loginId,doctor_username).setVisible(true);
                        f.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered wrong username and password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }else if(loginId==2){
                    String q="select * from patient where username='"+name+"'and password='"+pass+"'";
                    rs=obj.stm.executeQuery(q);
                    if(rs.next()){
                        String patientname=rs.getString("name");
                        String patient_id=rs.getString("pat_id");
                        String patient_username=rs.getString("username");
                        new PatientHomePage(patientname,patient_id,loginId,patient_username).setVisible(true);
                        f.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered wrong username and password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }else if(loginId==3){
                    String q="select * from receptionist where username='"+name+"'and password='"+pass+"'";
                    rs=obj.stm.executeQuery(q);
                    if(rs.next()){
                        String receptionistname=rs.getString("name");
                        String receptionist_id=rs.getString("res_id");
                        String reception_username=rs.getString("username");
                        new ReceptionistHomePage(receptionistname,receptionist_id,loginId,reception_username).setVisible(true);
                        f.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered wrong username and password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }else if(loginId==4){
                    String q="select * from admin where username='"+name+"'and password='"+pass+"'";
                    rs=obj.stm.executeQuery(q);
                    if(rs.next()){
                        String adminname=rs.getString("name");
                        String admin_id=rs.getString("admin_id");
                        String admin_username=rs.getString("username");
                        new AdminHomePage(adminname,admin_id,loginId,admin_username).setVisible(true);
                        f.setVisible(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You have entered wrong username and password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }

                }
            }catch(Exception Ex){
                Ex.printStackTrace();
            }
        } else if (ae.getSource() == bt2) {
            f.setVisible(false);
            new Index();
        }
    }
//    public static void main(String[] args) {
//        new LoginPage();
//    }
}
