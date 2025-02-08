package Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class View_Doctor extends JFrame implements ActionListener {
    String x[] = { "Name", "Username", "DOB", "Address", "Phone", "Email", "City", "Gender", "Blood group", "Age", "Clinic No", "Joining Date", "Specialization", "Availability" };
    JButton bt, bt1;
    String y[][] = new String[20][14];
    int i = 0, j = 0;
    JTable t;
    JLabel l1, l2;
    JTextField tf1;
    JPanel p1, p2, p3;
    Font f, f1;

    View_Doctor(int login_id) {
        super("Doctor Information");
        setSize(1500, 400);
        setLocation(1, 1);

        f = new Font("MS UI Gothic", Font.BOLD, 15);

        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from doctor";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("username");
                y[i][j++] = rest.getString("dob");
                y[i][j++] = rest.getString("address");
                y[i][j++] = rest.getString("phone");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("city");
                y[i][j++] = rest.getString("gender");
                y[i][j++] = rest.getString("blood");
                y[i][j++] = rest.getString("age");
                y[i][j++] = rest.getString("clinic_no");
                y[i][j++] = rest.getString("joining_date");
                y[i][j++] = rest.getString("specialization");
                y[i][j++] = rest.getString("availability");
                i++;
                j = 0;
            }
            t = new JTable(y, x);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.white);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t);
        if(login_id==4){
            f1 = new Font("Lucida Fax", Font.BOLD, 25);
            l1 = new JLabel("Doctor Username");
            l2 = new JLabel("Delete or Edit any Doctor");
            l2.setHorizontalAlignment(JLabel.CENTER);

            l1.setForeground(Color.GRAY);
            l2.setForeground(Color.YELLOW);

            l1.setFont(f1);
            l2.setFont(f1);
            bt = new JButton("Delete Doctor");
            bt1 = new JButton("Edit Doctor Record");
            bt.addActionListener(this);
            bt1.addActionListener(this);

            bt.setBackground(Color.BLACK);
            bt1.setBackground(Color.BLACK);
            bt.setForeground(Color.RED);
            bt1.setForeground(Color.RED);

            tf1 = new JTextField();
            tf1.setFont(f);

            p1 = new JPanel();
            p1.setLayout(new GridLayout(1, 1, 10, 10));
            p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1, 4, 10, 10));
            p2.add(l1);
            p2.add(tf1);
            p2.add(bt);
            p2.add(bt1);

            p3 = new JPanel();
            p3.setLayout(new GridLayout(2, 1, 10, 10));
            p3.add(p1);
            p3.add(p2);
            p1.setBackground(Color.BLACK);
            p2.setBackground(Color.BLACK);
            p3.setBackground(Color.BLACK);
            add(p3, "South");
        }
        add(sp);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String username = tf1.getText();
        if (ae.getSource() == bt) {
            try {
                ConnectionClass obj1 = new ConnectionClass();
                String q = "DELETE FROM doctor WHERE username='" + username + "'";
                obj1.stm.executeUpdate(q);
                String q2 = "UPDATE appointment SET appointment_status='Cancel' WHERE doctor_username='" + username + "' AND appointment_status='open'";
                obj1.stm.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Doctor deleted successfully!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == bt1) {
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill the Doctor Username!");
            } else {
                setVisible(false);
                new Edit_Doctor(username).setVisible(true);
            }
        }
    }
//
//    public static void main(String[] args) {
//        new View_Doctor().setVisible(true);
//    }
}
