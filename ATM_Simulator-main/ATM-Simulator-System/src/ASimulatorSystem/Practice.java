package ASimulatorSystem;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

// Chuyển ảnh thành ASCII Art
public final class Practice {

    boolean cheDoAm; // true = đảo màu (negative)

    public Practice() {
        this(false);
    }

    public Practice(final boolean cheDoAm) {
        this.cheDoAm = cheDoAm;
    }

    // Hàm chuyển ảnh thành chuỗi ASCII
    public String convert(final BufferedImage hinhAnh) {

        StringBuilder chuoi = new StringBuilder((hinhAnh.getWidth() + 1) * hinhAnh.getHeight());

        for (int y = 0; y < hinhAnh.getHeight(); y++) {

            if (chuoi.length() != 0) chuoi.append("\n");

            for (int x = 0; x < hinhAnh.getWidth(); x++) {

                Color mauPixel = new Color(hinhAnh.getRGB(x, y));

                // Tính giá trị mức xám (grayscale)
                double giaTriXam =
                        (double) mauPixel.getRed() * 0.2989 +
                        (double) mauPixel.getBlue() * 0.5870 +
                        (double) mauPixel.getGreen() * 0.1140;

                final char kyTu = cheDoAm ? layKyTuAm(giaTriXam) : layKyTuDuong(giaTriXam);

                chuoi.append(kyTu);
            }
        }

        return chuoi.toString();
    }

    /**
     * Trả về ký tự dựa trên độ sáng.
     * Pixel càng sáng → ký tự càng "nhạt".
     * Pixel càng tối → ký tự càng "đậm".
     */
    private char layKyTuDuong(double g) {

        final char kyTu;

        if (g >= 230.0) {
            kyTu = ' ';
        } else if (g >= 200.0) {
            kyTu = '.';
        } else if (g >= 180.0) {
            kyTu = '*';
        } else if (g >= 160.0) {
            kyTu = ':';
        } else if (g >= 130.0) {
            kyTu = 'o';
        } else if (g >= 100.0) {
            kyTu = '&';
        } else if (g >= 70.0) {
            kyTu = '8';
        } else if (g >= 50.0) {
            kyTu = '#';
        } else {
            kyTu = '@';
        }

        return kyTu;
    }

    /**
     * Ngược lại với trên (đảo sáng tối).
     * Pixel tối → ký tự nhạt
     * Pixel sáng → ký tự đậm
     */
    private char layKyTuAm(double g) {

        final char kyTu;

        if (g >= 230.0) {
            kyTu = '@';
        } else if (g >= 200.0) {
            kyTu = '#';
        } else if (g >= 180.0) {
            kyTu = '8';
        } else if (g >= 160.0) {
            kyTu = '&';
        } else if (g >= 130.0) {
            kyTu = 'o';
        } else if (g >= 100.0) {
            kyTu = ':';
        } else if (g >= 70.0) {
            kyTu = '*';
        } else if (g >= 50.0) {
            kyTu = '.';
        } else {
            kyTu = ' ';
        }

        return kyTu;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                JFileChooser chonFile = new JFileChooser();
                chonFile.setFileFilter(new FileNameExtensionFilter("Hình ảnh", "jpg", "gif", "png"));

                while (chonFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                    try {

                        File file = chonFile.getSelectedFile();
                        final BufferedImage hinhAnh = ImageIO.read(file);

                        if (hinhAnh == null)
                            throw new IllegalArgumentException(file + " không phải là hình ảnh hợp lệ.");

                        final String ascii = new Practice().convert(hinhAnh);

                        final JTextArea vungText = new JTextArea(ascii, hinhAnh.getHeight(), hinhAnh.getWidth());
                        vungText.setFont(new Font("Monospaced", Font.BOLD, 5));
                        vungText.setEditable(false);

                        final JDialog hopThoai =
                                new JOptionPane(new JScrollPane(vungText),
                                        JOptionPane.PLAIN_MESSAGE)
                                        .createDialog("Kết quả ASCII Art");

                        hopThoai.setResizable(true);
                        hopThoai.setVisible(true);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                e.toString(),
                                "Lỗi",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                System.exit(0);
            }
        });
    }
}