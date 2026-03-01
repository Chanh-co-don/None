package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

// Lớp Đăng Nhập hệ thống ATM
public class Login extends JFrame implements ActionListener{

    JLabel lblTieuDe, lblSoThe, lblPin;
    JTextField txtSoThe;
    JPasswordField txtPin;
    JButton btnDangNhap, btnXoa, btnDangKy;
  
    Login(){

        setTitle("MÁY RÚT TIỀN TỰ ĐỘNG (ATM)");
        
        // Logo ATM
        ImageIcon iconGoc = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image hinhScale = iconGoc.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon iconMoi = new ImageIcon(hinhScale);
        JLabel lblLogo = new JLabel(iconMoi);
        lblLogo.setBounds(70, 10, 100, 100);
        add(lblLogo);
        
        // Tiêu đề
        lblTieuDe = new JLabel("CHÀO MỪNG BẠN ĐẾN VỚI ATM");
        lblTieuDe.setFont(new Font("Osward", Font.BOLD, 38));
        lblTieuDe.setBounds(200,40,500,40);
        add(lblTieuDe);
        
        // Nhãn số thẻ
        lblSoThe = new JLabel("Số thẻ:");
        lblSoThe.setFont(new Font("Raleway", Font.BOLD, 28));
        lblSoThe.setBounds(125,150,375,30);
        add(lblSoThe);
        
        // Ô nhập số thẻ
        txtSoThe = new JTextField(15);
        txtSoThe.setBounds(300,150,230,30);
        txtSoThe.setFont(new Font("Arial", Font.BOLD, 14));
        add(txtSoThe);
        
        // Nhãn PIN
        lblPin = new JLabel("Mã PIN:");
        lblPin.setFont(new Font("Raleway", Font.BOLD, 28));
        lblPin.setBounds(125,220,375,30);
        add(lblPin);
        
        // Ô nhập PIN
        txtPin = new JPasswordField(15);
        txtPin.setFont(new Font("Arial", Font.BOLD, 14));
        txtPin.setBounds(300,220,230,30);
        add(txtPin);
                
        // Nút đăng nhập
        btnDangNhap = new JButton("ĐĂNG NHẬP");
        btnDangNhap.setBackground(Color.BLACK);
        btnDangNhap.setForeground(Color.WHITE);
        
        // Nút xóa dữ liệu
        btnXoa = new JButton("XÓA");
        btnXoa.setBackground(Color.BLACK);
        btnXoa.setForeground(Color.WHITE);
        
        // Nút đăng ký tài khoản
        btnDangKy = new JButton("ĐĂNG KÝ");
        btnDangKy.setBackground(Color.BLACK);
        btnDangKy.setForeground(Color.WHITE);
        
        setLayout(null);
        
        btnDangNhap.setFont(new Font("Arial", Font.BOLD, 14));
        btnDangNhap.setBounds(300,300,120,30);
        add(btnDangNhap);
        
        btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
        btnXoa.setBounds(430,300,100,30);
        add(btnXoa);
        
        btnDangKy.setFont(new Font("Arial", Font.BOLD, 14));
        btnDangKy.setBounds(300,350,230,30);
        add(btnDangKy);
        
        // Thêm sự kiện
        btnDangNhap.addActionListener(this);
        btnXoa.addActionListener(this);
        btnDangKy.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
    }

    // Xử lý sự kiện khi nhấn nút
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==btnDangNhap){

                Conn ketNoi = new Conn();
                String soThe  = txtSoThe.getText();
                String maPin  = txtPin.getText();

                String cauLenh  = "select * from login where cardno = '"+soThe+"' and pin = '"+maPin+"'";

                ResultSet rs = ketNoi.s.executeQuery(cauLenh);

                if(rs.next()){
                    setVisible(false);
                    new Transactions(maPin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Sai số thẻ hoặc mã PIN");
                }

            }else if(ae.getSource()==btnXoa){
                txtSoThe.setText("");
                txtPin.setText("");

            }else if(ae.getSource()==btnDangKy){
                setVisible(false);
                new Signup().setVisible(true);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Login().setVisible(true);
    }
}