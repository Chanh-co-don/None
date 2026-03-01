package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Signup extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
    JDateChooser dateChooser;
    
    
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);
    
    Signup(){
        
        setTitle("ĐƠN ĐĂNG KÝ TÀI KHOẢN MỚI");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(20, 0, 100, 100);
        add(l11);
        
        l1 = new JLabel("MÃ ĐƠN ĐĂNG KÝ: "+first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        
        l2 = new JLabel("Trang 1: Thông tin cá nhân");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l3 = new JLabel("Họ và tên:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l4 = new JLabel("Tên cha:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l5 = new JLabel("Ngày sinh:");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l6 = new JLabel("Giới tính:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l7 = new JLabel("Email:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l8 = new JLabel("Tình trạng hôn nhân:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l9 = new JLabel("Địa chỉ:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l10 = new JLabel("Thành phố:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l11 = new JLabel("Mã bưu điện:");
        l11.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l12 = new JLabel("Tỉnh / Bang:");
        l12.setFont(new Font("Raleway", Font.BOLD, 20));
        
        l13 = new JLabel("Ngày");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l14 = new JLabel("Tháng");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l15 = new JLabel("Năm");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));
        
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t3 = new JTextField();
        t3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t4 = new JTextField();
        t4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t5 = new JTextField();
        t5.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t6 = new JTextField();
        t6.setFont(new Font("Raleway", Font.BOLD, 14));
        
        t7 = new JTextField();
        t7.setFont(new Font("Raleway", Font.BOLD, 14));
        
       
        b = new JButton("Tiếp theo");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        
        r1 = new JRadioButton("Nam");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Nữ");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        
        r3 = new JRadioButton("Đã kết hôn");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Chưa kết hôn");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        
        r5 = new JRadioButton("Khác");
        r5.setFont(new Font("Raleway", Font.BOLD, 14));
        r5.setBackground(Color.WHITE);
        
        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(r3);
        groupstatus.add(r4);
        groupstatus.add(r5);
        
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(137, 337, 200, 29);
        add(dateChooser);
        
        setLayout(null);
        l1.setBounds(140,20,600,40);
        add(l1);
        
        l2.setBounds(290,80,600,30);
        add(l2);
        
        l3.setBounds(100,140,100,30);
        add(l3);
        
        t1.setBounds(300,140,400,30);
        add(t1);
        
        l4.setBounds(100,190,200,30);
        add(l4);
        
        t2.setBounds(300,190,400,30);
        add(t2);
        
        l5.setBounds(100,240,200,30);
        add(l5);
        
        dateChooser.setBounds(300, 240, 400, 30);
        
        l6.setBounds(100,290,200,30);
        add(l6);
        
        r1.setBounds(300,290,60,30);
        add(r1);
        
        r2.setBounds(450,290,90,30);
        add(r2);
        
        l7.setBounds(100,340,200,30);
        add(l7);
        
        t3.setBounds(300,340,400,30);
        add(t3);
        
        l8.setBounds(100,390,200,30);
        add(l8);
        
        r3.setBounds(300,390,130,30);
        add(r3);
        
        r4.setBounds(450,390,150,30);
        add(r4);
        
        r5.setBounds(635,390,100,30);
        add(r5);
        
        l9.setBounds(100,440,200,30);
        add(l9);
        
        t4.setBounds(300,440,400,30);
        add(t4);
        
        l10.setBounds(100,490,200,30);
        add(l10);
        
        t5.setBounds(300,490,400,30);
        add(t5);
        
        l11.setBounds(100,540,200,30);
        add(l11);
        
        t6.setBounds(300,540,400,30);
        add(t6);
        
        l12.setBounds(100,590,200,30);
        add(l12);
        
        t7.setBounds(300,590,400,30);
        add(t7);
        
        b.setBounds(620,660,100,30);
        add(b);
        
        b.addActionListener(this); 
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = first;
        String name = t1.getText().trim();
        String fname = t2.getText().trim();
        java.util.Date utilDate = dateChooser.getDate();
        
        String gender = null;
        if(r1.isSelected()){ 
            gender = "Nam";
        }else if(r2.isSelected()){ 
            gender = "Nữ";
        }
            
        String email = t3.getText().trim();
        String marital = null;
        if(r3.isSelected()){ 
            marital = "Đã kết hôn";
        }else if(r4.isSelected()){ 
            marital = "Chưa kết hôn";
        }else if(r5.isSelected()){ 
            marital = "Khác";
        }
           
        String address = t4.getText().trim();
        String city = t5.getText().trim();
        String pincode = t6.getText().trim();
        String state = t7.getText().trim();
        

        try{
           
            if(name.equals("") || fname.equals("") || email.equals("") || utilDate == null || pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ các trường bắt buộc");
                return;
            }else{
                Conn c1 = new Conn();
                
                String q1 = "INSERT INTO signup VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                
                try (PreparedStatement pst = c1.c.prepareStatement(q1)) {
                    
                    pst.setString(1, formno);
                    pst.setString(2, name);
                    pst.setString(3, fname);
                    
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    pst.setDate(4, sqlDate);
                    
                    pst.setString(5, gender);
                    pst.setString(6, email);
                    pst.setString(7, marital);
                    pst.setString(8, address);
                    pst.setString(9, city);
                    pst.setString(10, pincode);
                    pst.setString(11, state);
                    
                    pst.executeUpdate();
                }
                
                new Signup2(first).setVisible(true);
                setVisible(false);
            }
            
        }catch(Exception e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu: "+e.getMessage());
        }
        
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}