package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

// Lớp kiểm tra số dư - kế thừa JFrame và xử lý sự kiện
class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField txt1, txt2;        // Ô nhập (hiện chưa dùng)
    JButton btnQuayLai, btn2, btn3;
    JLabel lblThongBao, lbl2, lblHinhNen;
    String maPin;

    // Constructor nhận mã PIN
    BalanceEnquiry(String pin) {
        this.maPin = pin;

        // Load hình nền ATM
        ImageIcon iconGoc = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image hinhScale = iconGoc.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon iconMoi = new ImageIcon(hinhScale);
        JLabel lblHinhNen = new JLabel(iconMoi);
        lblHinhNen.setBounds(0, 0, 960, 1080);
        add(lblHinhNen);

        // Label hiển thị số dư
        lblThongBao = new JLabel();
        lblThongBao.setForeground(Color.WHITE);
        lblThongBao.setFont(new Font("System", Font.BOLD, 16));

        // Nút quay lại
        btnQuayLai = new JButton("QUAY LẠI");

        setLayout(null);

        lblThongBao.setBounds(190, 350, 400, 35);
        lblHinhNen.add(lblThongBao);

        btnQuayLai.setBounds(390, 633, 150, 35);
        lblHinhNen.add(btnQuayLai);

        // Biến lưu số dư
        int soDu = 0;

        try {
            // Kết nối CSDL
            Conn ketNoi = new Conn();

            // Truy vấn tất cả giao dịch theo PIN
            ResultSet rs = ketNoi.s.executeQuery("select * from bank where pin = '" + pin + "'");

            // Tính tổng số dư
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    soDu += Integer.parseInt(rs.getString("amount"));
                } else {
                    soDu -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            // Có thể in lỗi nếu cần
            // e.printStackTrace();
        }

        // Hiển thị số dư hiện tại
        lblThongBao.setText("Số dư tài khoản hiện tại của bạn là: " + soDu + " VNĐ");

        // Thêm sự kiện cho nút quay lại
        btnQuayLai.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    // Xử lý sự kiện khi nhấn nút
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(maPin).setVisible(true);
    }

    // Hàm main để chạy thử
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}