package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    
    Signup3(String formno){
        this.formno = formno;
        setTitle("ĐƠN ĐĂNG KÝ TÀI KHOẢN MỚI - TRANG 3");
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);
        
        l1 = new JLabel("Trang 3: Thông tin tài khoản");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Loại tài khoản:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Số thẻ:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("(Số thẻ gồm 16 chữ số)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l6 = new JLabel("Sẽ xuất hiện trên thẻ ATM / Sổ séc / Sao kê");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l7 = new JLabel("Mã PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
    
        l9 = new JLabel("(Mật khẩu 4 chữ số)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
    
        l10 = new JLabel("Dịch vụ đăng ký:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Mã đơn:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("Xác nhận");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Hủy");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        c1 = new JCheckBox("Thẻ ATM");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c4 = new JCheckBox("Thông báo Email");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c5 = new JCheckBox("Sổ séc");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c6 = new JCheckBox("Sao kê điện tử");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c7 = new JCheckBox("Tôi cam kết thông tin trên là đúng sự thật theo hiểu biết của tôi.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
         
        r1 = new JRadioButton("Tài khoản tiết kiệm");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Tài khoản tiền gửi cố định");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        
        r3 = new JRadioButton("Tài khoản thanh toán");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Tài khoản gửi định kỳ");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        setLayout(null);
        
        l11.setBounds(700,10,70,30);
        add(l11);
        
        l12.setBounds(770,10,40,30);
        add(l12);
        
        l1.setBounds(280,40,400,40);
        add(l1); 
        
        l2.setBounds(100,140,200,30);
        add(l2);
        
        r1.setBounds(100,180,250,30);
        add(r1);
        
        r2.setBounds(350,180,300,30);
        add(r2);
        
        r3.setBounds(100,220,250,30);
        add(r3);
        
        r4.setBounds(350,220,250,30);
        add(r4);
        
        l3.setBounds(100,300,200,30);
        add(l3);
        
        l4.setBounds(330,300,250,30);
        add(l4);
        
        l5.setBounds(100,330,250,20);
        add(l5);
        
        l6.setBounds(330,330,500,20);
        add(l6);
        
        l7.setBounds(100,370,200,30);
        add(l7);
        
        l8.setBounds(330,370,200,30);
        add(l8);
        
        l9.setBounds(100,400,200,20);
        add(l9);
        
        l10.setBounds(100,450,200,30);
        add(l10);
        
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7.setBounds(100,680,600,20);
        add(c7);
        
        b1.setBounds(250,720,100,30);
        add(b1);
        
        b2.setBounds(420,720,100,30);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,120);
        setVisible(true);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        String atype = null;
        if(r1.isSelected()){ 
            atype = "Tài khoản tiết kiệm";
        }
        else if(r2.isSelected()){ 
            atype = "Tài khoản tiền gửi cố định";
        }
        else if(r3.isSelected()){ 
            atype = "Tài khoản thanh toán";
        }else if(r4.isSelected()){ 
            atype = "Tài khoản gửi định kỳ";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String facility = "";
        if(c1.isSelected()){ facility = facility + " Thẻ ATM"; }
        if(c2.isSelected()){ facility = facility + " Internet Banking"; }
        if(c3.isSelected()){ facility = facility + " Mobile Banking"; }
        if(c4.isSelected()){ facility = facility + " Thông báo Email"; }
        if(c5.isSelected()){ facility = facility + " Sổ séc"; }
        if(c6.isSelected()){ facility = facility + " Sao kê điện tử"; }
        
        try{
            if(ae.getSource()==b1){
                
                if(atype.equals("")){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin bắt buộc");
                }else{
                    Conn c1 = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+atype+"','"+cardno+"','"+pin+"','"+facility+"')";  
                    String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Số thẻ: " + cardno + "\nMã PIN: "+ pin);
                    
                    new Deposit(pin).setVisible(true);
                    setVisible(false);
                }
            
            }else if(ae.getSource()==b2){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }
}