package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// Lớp Nạp Tiền - kế thừa JFrame và xử lý sự kiện
public class Deposit extends JFrame implements ActionListener{
    
    JTextField txtSoTien, txt2;
    JButton btnNapTien, btnQuayLai, btn3;
    JLabel lblThongBao, lbl2, lblHinhNen;
    String maPin;

    // Constructor nhận mã PIN
    Deposit(String pin){
        this.maPin = pin;

        // Load hình nền ATM
        ImageIcon iconGoc = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image hinhScale = iconGoc.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon iconMoi = new ImageIcon(hinhScale);
        JLabel lblHinhNen = new JLabel(iconMoi);
        lblHinhNen.setBounds(0, 0, 960, 1080);
        add(lblHinhNen);
        
        // Label yêu cầu nhập số tiền
        lblThongBao = new JLabel("NHẬP SỐ TIỀN BẠN MUỐN NẠP");
        lblThongBao.setForeground(Color.WHITE);
        lblThongBao.setFont(new Font("System", Font.BOLD, 16));
        
        // Ô nhập số tiền
        txtSoTien = new JTextField();
        txtSoTien.setFont(new Font("Raleway", Font.BOLD, 22));
        
        // Các nút chức năng
        btnNapTien = new JButton("NẠP TIỀN");
        btnQuayLai = new JButton("QUAY LẠI");
        
        setLayout(null);
        
        lblThongBao.setBounds(190,350,400,35);
        lblHinhNen.add(lblThongBao);
        
        txtSoTien.setBounds(190,420,320,25);
        lblHinhNen.add(txtSoTien);
        
        btnNapTien.setBounds(390,588,150,35);
        lblHinhNen.add(btnNapTien);
        
        btnQuayLai.setBounds(390,633,150,35);
        lblHinhNen.add(btnQuayLai);
        
        // Thêm sự kiện cho nút
        btnNapTien.addActionListener(this);
        btnQuayLai.addActionListener(this);
        
        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }
    
    // Xử lý sự kiện khi nhấn nút
    public void actionPerformed(ActionEvent ae){
        try{        
            String soTien = txtSoTien.getText();
            Date ngayGiaoDich = new Date();

            if(ae.getSource()==btnNapTien){
                if(txtSoTien.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền bạn muốn nạp");
                }else{
                    Conn ketNoi = new Conn();
                    
                    // Thêm giao dịch vào bảng bank
                    ketNoi.s.executeUpdate(
                        "insert into bank values('"+maPin+"', '"+ngayGiaoDich+"', 'Deposit', '"+soTien+"')"
                    );

                    JOptionPane.showMessageDialog(null, "Đã nạp thành công " + soTien + " VNĐ");
                    
                    setVisible(false);
                    new Transactions(maPin).setVisible(true);
                }
            }
            else if(ae.getSource()==btnQuayLai){
                setVisible(false);
                new Transactions(maPin).setVisible(true);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Hàm main chạy thử
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}