package Hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorHomePage extends JFrame implements ActionListener {

    JLabel l1;
    Font f, f1, f2;
    public String doctor_id2;
    int login__id;
    String username2;

    DoctorHomePage(String doctorname, String doctor_id,int login_id,String username) {
        super("Doctor Home Page");
        setLocation(0, 0);
        setSize(1500, 730);

        login__id=login_id;
        doctor_id2=doctor_id;
        username2=username;

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Hospital/icons/doctor home.jpg"));
        Image i = img.getImage().getScaledInstance(1500, 730, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(i);
        l1 = new JLabel(ic1);
        l1.setBounds(0, 0, 1500, 730);
        add(l1);


        f = new Font("Lucida Fax", Font.BOLD, 20);
        f1 = new Font("Gadugi", Font.BOLD, 35);
        f2 = new Font("MS UI Gothic", Font.BOLD, 10);

        JMenuBar m1 = new JMenuBar();

        JMenu men1 = new JMenu("Doctor");
        //JMenuItem ment1 = new JMenuItem("Add Doctor");
        JMenuItem ment2 = new JMenuItem("View Doctor");

        JMenu men2 = new JMenu("Patient");
        //JMenuItem ment3 = new JMenuItem("Add Patient");
        JMenuItem ment4 = new JMenuItem("View Patient");

        JMenu men3 = new JMenu("Receptionist");
        //JMenuItem ment5 = new JMenuItem("Add Receptionist");
        JMenuItem ment6 = new JMenuItem("View Receptionist");

        JMenu men4 = new JMenu("Appointment");
        //JMenuItem ment7 = new JMenuItem("Add Appointment");
        JMenuItem ment8 = new JMenuItem("View Appointment");

        JMenu men5 = new JMenu("Hi, Doctor (" + doctorname + ")");
        JMenuItem ment9 = new JMenuItem("My Profile");
        JMenuItem ment10 = new JMenuItem("Change Password");

        JMenu men8 = new JMenu("Exit");
        JMenuItem ment14 = new JMenuItem("Exit");

        //men1.add(ment1);
        men1.add(ment2);
        //men2.add(ment3);
        men2.add(ment4);
        //men3.add(ment5);
        men3.add(ment6);
        //men4.add(ment7);
        men4.add(ment8);
        men5.add(ment9);
        men5.add(ment10);
        men8.add(ment14);

        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men8);

        m1.setBackground(Color.BLACK);

        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men8.setForeground(Color.RED);

        //ment1.setForeground(Color.YELLOW);
        //ment3.setForeground(Color.YELLOW);
        //ment5.setForeground(Color.YELLOW);
        //ment7.setForeground(Color.YELLOW);
        ment9.setForeground(Color.YELLOW);
        ment14.setForeground(Color.RED);

        //ment1.setBackground(Color.BLACK);
        //ment3.setBackground(Color.BLACK);
        //ment5.setBackground(Color.BLACK);
        //ment7.setBackground(Color.BLACK);
        ment9.setBackground(Color.BLACK);
        ment14.setBackground(Color.BLACK);

        //ment1.addActionListener(this);
        ment2.addActionListener(this);
        //ment3.addActionListener(this);
        ment4.addActionListener(this);
        //ment5.addActionListener(this);
        ment6.addActionListener(this);
        //ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment14.addActionListener(this);

        setJMenuBar(m1);
        l1.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if (command.equals("View Doctor")) {
            new View_Doctor(login__id).setVisible(true);
        }else if(command.equals("View Patient")){
            new View_Patient(username2,login__id).setVisible(true);
        }else if(command.equals("View Receptionist")){
            new View_Receptionist(login__id).setVisible(true);
        }else if(command.equals("View Appointment")){
            new View_Appointment(username2,login__id).setVisible(true);
        }else if(command.equals("My Profile")){
            new CheckMyProfile(doctor_id2,login__id).setVisible(true);
        }else if(command.equals("Change Password")){
            new ChangeMyPassword(doctor_id2,login__id).setVisible(true);
        }
        else if (command.equals("Exit")) {
            this.setVisible(false);
            new Index().setVisible(true);
        }
    }
}
