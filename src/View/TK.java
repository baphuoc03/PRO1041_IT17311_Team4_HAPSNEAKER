/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import viewmodel.TKDoanhThu_View;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.SanPham_Model;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import service.ISanPham_Service;
import service.impl.TKDoanhThu_Service;
import service.impl.TKSanPham_Service;
import service.impl.TKTongQuan_service;
import viewmodel.TKSanPham_View;
import viewmodel.TKTongQuan_View;
import service.ITKDoanhThu_service;
import service.ITKSanPham_Service;
import service.ITKThuocTinh_Service;
import service.ITKTongQuan_Service;
import service.impl.SanPham_service;
import service.impl.TKThuocTinh_Sevice;
import viewmodel.TKThuocTinhSP_View;

/**
 *
 * @author admin
 */
public class TK extends javax.swing.JPanel {

    SimpleDateFormat dateFM = new SimpleDateFormat("yyyy-MM-dd");
    private JPanel panel;
    ITKSanPham_Service tkSP_sv = new TKSanPham_Service();
    ITKTongQuan_Service tkTQ_Service = new TKTongQuan_service();
    ITKDoanhThu_service tKDoanhThu_service = new TKDoanhThu_Service();
    ITKThuocTinh_Service tk_TTSP = new TKThuocTinh_Sevice();
    ISanPham_Service sp_sv = new SanPham_service();
    List<TKDoanhThu_View> listDoanhThuThang;
    List<TKSanPham_View> listTkSP;
    DefaultTableModel mol;
    NumberFormat numberFM = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    DecimalFormat decimal = new DecimalFormat("#.#");
    public String ketthuc = "", batDau = "";
    List<TKThuocTinhSP_View> lstTKTTSP;
//    String dateBatDau;
//    String dateKetThuc;

    /**
     * Creates new form TK
     */
    public TK() {
        initComponents();
        filltblTKSP();
        testbarchar(2022);
        txtBatDau.setEnabled(false);
        txtKetThuc.setEnabled(false);
        btnTK.setEnabled(false);
        filltblDoanhThuThang(2022);
        TKTongQuan_View tk = tkTQ_Service.tkHomNay();
        fillTKTongQuan(tk.getDonHang(), tk.getSanPham(), tk.getDoanhthu());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dangTK = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblDonHang = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblSanPham = new javax.swing.JLabel();
        cboLoaiTG = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        pnlLoaiThoiGian = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtBatDau = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtKetThuc = new com.toedter.calendar.JDateChooser();
        btnTK = new javax.swing.JButton();
        tabTK = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabDoanhThu = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTK_Thang = new javax.swing.JTable();
        pnlBieuDo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_TKSP = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ĐƠN HÀNG");

        lblDonHang.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lblDonHang.setForeground(new java.awt.Color(255, 255, 255));
        lblDonHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonHang.setText("10");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(lblDonHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblDonHang)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 153, 51));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DOANH THU");

        lblDoanhThu.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lblDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThu.setText("10");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(lblDoanhThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblDoanhThu)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SẢN PHẨM");

        lblSanPham.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lblSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSanPham.setText("10");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(lblSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblSanPham)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        cboLoaiTG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm nay", "Theo ngày" }));
        cboLoaiTG.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiTGItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Loại Thời Gian");

        pnlLoaiThoiGian.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Ngày Bắt Đầu");

        txtBatDau.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Ngày Kết Thúc");

        txtKetThuc.setBackground(new java.awt.Color(255, 255, 255));

        btnTK.setText("Tìm Kiếm");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoaiThoiGianLayout = new javax.swing.GroupLayout(pnlLoaiThoiGian);
        pnlLoaiThoiGian.setLayout(pnlLoaiThoiGianLayout);
        pnlLoaiThoiGianLayout.setHorizontalGroup(
            pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoaiThoiGianLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnTK)
                .addGap(36, 36, 36))
        );
        pnlLoaiThoiGianLayout.setVerticalGroup(
            pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoaiThoiGianLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTK)
                    .addGroup(pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlLoaiThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
        );

        pnlLoaiThoiGianLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtBatDau, txtKetThuc});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cboLoaiTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLoaiThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cboLoaiTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel10, jPanel7});

        tabTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTKMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Chi Tiết Doanh Thu");

        tabDoanhThu.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabDoanhThu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDoanhThuMouseClicked(evt);
            }
        });

        tblTK_Thang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tháng", "Sản Phẩm Bán", "Tổng Giá Bán", "Tổng Giá Giảm", "Doanh Thu", "Lợi Nhuận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTK_Thang);

        tabDoanhThu.addTab("Bảng", jScrollPane1);

        pnlBieuDo.setLayout(new java.awt.BorderLayout());
        tabDoanhThu.addTab("Biểu Đồ", pnlBieuDo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(401, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(350, 350, 350))
            .addComponent(tabDoanhThu)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Năm");

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2021" }));
        cboNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );

        tabTK.addTab("Doanh Thu", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(953, 345));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Thống Kê Chi Tiết Sản Phẩm");

        tbl_TKSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Thương Hiệu", "Màu Sắc", "Số Lượng Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_TKSP.setPreferredSize(new java.awt.Dimension(375, 320));
        tbl_TKSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TKSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_TKSP);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(299, 299, 299))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton2.setText("Xuất Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(162, 162, 162))
        );

        tabTK.addTab("Sản Phẩm", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabTK)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabTK))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDoanhThuMouseClicked
        // TODO add your handling code here:
        if (tabDoanhThu.getSelectedIndex() == 1) {
            testbarchar(Integer.parseInt(cboNam.getSelectedItem().toString()));
        }
    }//GEN-LAST:event_tabDoanhThuMouseClicked

    private void cboLoaiTGItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiTGItemStateChanged
        // TODO add your handling code here:
        if (cboLoaiTG.getItemCount() > 0) {
            if (cboLoaiTG.getSelectedIndex() == 0) {

                TKTongQuan_View tk = tkTQ_Service.tkHomNay();
                txtBatDau.setEnabled(false);
                txtKetThuc.setEnabled(false);
                btnTK.setEnabled(false);

                fillTKTongQuan(tk.getDonHang(), tk.getSanPham(), tk.getDoanhthu());
            } else {
                pnlLoaiThoiGian.setEnabled(true);
                txtBatDau.setEnabled(true);
                txtKetThuc.setEnabled(true);
                btnTK.setEnabled(true);
            }
        }
    }//GEN-LAST:event_cboLoaiTGItemStateChanged

    private void tabTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTKMouseClicked
        // TODO add your handling code here:
        if (tabTK.getSelectedIndex() == 0) {
            filltblDoanhThuThang(Integer.parseInt(cboNam.getSelectedItem().toString()));
        } else {
            filltblTKSP();
        }
    }//GEN-LAST:event_tabTKMouseClicked

    private void tbl_TKSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TKSPMouseClicked
        // TODO add your handling code here:
        TKThuocTinhSP sp = new TKThuocTinhSP();
        JFrame frameChild = new JFrame();
        frameChild.setSize(900, 450);
        frameChild.setLocationRelativeTo(null);
        frameChild.add(sp);
        frameChild.setVisible(true);
        int index = tbl_TKSP.getSelectedRow();
        String ma = tbl_TKSP.getValueAt(index, 1).toString();
        sp.filltbl(ma);


    }//GEN-LAST:event_tbl_TKSPMouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
        TKChiTiet_SP tksp = new TKChiTiet_SP();
        JFrame frameChild = new JFrame();
        frameChild.setSize(900, 450);
        frameChild.setLocationRelativeTo(null);
        frameChild.add(tksp);
        frameChild.setVisible(true);
        if (cboLoaiTG.getSelectedIndex() == 0) {
            tksp.filtblsanpham(tkSP_sv.getTKSanPham(dateFM.format(new Date()), dateFM.format(new Date())));
//            TKChiTiet_SP tkCTSP = new TKChiTiet_SP();
            TKChiTiet_SP.txtBD.setText("Hôm Nay");
            TKChiTiet_SP.txtKT.setText("Hôm Nay");
        } else {
            tksp.filtblsanpham(tkSP_sv.getTKSanPham(dateFM.format(txtBatDau.getDate()), dateFM.format(txtKetThuc.getDate())));
            TKChiTiet_SP.txtBD.setText(dateFM.format(txtBatDau.getDate()));
            TKChiTiet_SP.txtKT.setText(dateFM.format(txtKetThuc.getDate()));
        }


    }//GEN-LAST:event_jPanel10MouseClicked

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        // TODO add your handling code here:
        if(txtBatDau.getDate().after(txtKetThuc.getDate())){
            JOptionPane.showMessageDialog(this, "Ngày Bắt Đầu Phải <= Ngày Kết Thúc");
        }
        TKTongQuan_View tkTQ = tkTQ_Service.tkTheoNgay(dateFM.format(txtBatDau.getDate()), dateFM.format(txtKetThuc.getDate()));
        ketthuc = dateFM.format(txtBatDau.getDate());
        batDau = dateFM.format(txtKetThuc.getDate());
        fillTKTongQuan(tkTQ.getDonHang(), tkTQ.getSanPham(), tkTQ.getDoanhthu());
    }//GEN-LAST:event_btnTKActionPerformed

    private void cboNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamItemStateChanged
        // TODO add your handling code here:
        filltblDoanhThuThang(Integer.parseInt(cboNam.getSelectedItem().toString()));
    }//GEN-LAST:event_cboNamItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        writeExcel();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTK;
    public static javax.swing.JComboBox<String> cboLoaiTG;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.ButtonGroup dangTK;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDoanhThu;
    public static javax.swing.JLabel lblDonHang;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JPanel pnlBieuDo;
    public javax.swing.JPanel pnlLoaiThoiGian;
    private javax.swing.JTabbedPane tabDoanhThu;
    public static javax.swing.JTabbedPane tabTK;
    private javax.swing.JTable tblTK_Thang;
    private javax.swing.JTable tbl_TKSP;
    public static com.toedter.calendar.JDateChooser txtBatDau;
    public static com.toedter.calendar.JDateChooser txtKetThuc;
    // End of variables declaration//GEN-END:variables
    public void testbarchar(int nam) {
        listDoanhThuThang = tKDoanhThu_service.getTKDoanhThu(nam);
        DefaultCategoryDataset dbSet = new DefaultCategoryDataset();
        for (TKDoanhThu_View t : listDoanhThuThang) {
            dbSet.setValue(t.getTongDoanhThu(), "Doanh Thu", t.getThang() + "");
        }
        JFreeChart Barchar = ChartFactory.createBarChart("Doanh thu theo nam", "Thang", "Doanh Thu", dbSet, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel chartPanel = new ChartPanel(Barchar);
        chartPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        pnlBieuDo.removeAll();
        pnlBieuDo.add(chartPanel);
    }

    public void filltblDoanhThuThang(int nam) {
        listDoanhThuThang = tKDoanhThu_service.getTKDoanhThu(nam);
        mol = (DefaultTableModel) tblTK_Thang.getModel();
        mol.setRowCount(0);
        for (TKDoanhThu_View t : listDoanhThuThang) {
            mol.addRow(new Object[]{t.getThang(), t.getSlSanPham(), numberFM.format(t.getTongGiaBan()), numberFM.format(t.getTongGiaGia()), numberFM.format(t.getTongDoanhThu()),numberFM.format(t.getLoiNhuan())});
        }
    }

    public void filltblTKSP() {
        listTkSP = tkSP_sv.getTKSanPham();
        mol = (DefaultTableModel) tbl_TKSP.getModel();
        mol.setRowCount(0);
        for (TKSanPham_View t : listTkSP) {
            mol.addRow(new Object[]{t.getStt(), t.getMaSP(), t.getTen(), t.getThuongHieu(), t.getMau(), t.getSlBan()});
        }
    }

    public void fillTKTongQuan(int donHang, int sanpham, float daonhThu) {
        lblDoanhThu.setText(numberFM.format(daonhThu));
        lblDonHang.setText(donHang + "");
        lblSanPham.setText(sanpham + "");
    }

    public void writeExcel() {
        try {
            SimpleDateFormat dateTimeFM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            lstTKTTSP = tk_TTSP.tkByMa();
            String date = dateTimeFM.format(new Date());
            FileOutputStream file = new FileOutputStream("../TK_SP/" + "TKSP_" + date + ".xlsx");
            XSSFWorkbook worbook = new XSSFWorkbook();
            XSSFSheet worksheet = worbook.createSheet("Thống Kê Sản Phẩm");
            XSSFRow row;
            XSSFCell maSP, ten, thuongHieu, mauSac, size, slBan, slVCon;
            int i = 1;
            row = worksheet.createRow(i);
            maSP = row.createCell(0);
            maSP.setCellValue("Mã Sản Phẩm");
            ten = row.createCell(1);
            ten.setCellValue("Tên Sản Phẩm");
            thuongHieu = row.createCell(2);
            thuongHieu.setCellValue("Thương Hiệu");
            mauSac = row.createCell(3);
            mauSac.setCellValue("Màu Sắc");
            size = row.createCell(4);
            size.setCellValue("Size");
            slBan = row.createCell(5);
            slBan.setCellValue("Số Lượng Bán");
            slVCon = row.createCell(6);
            slVCon.setCellValue("Số Lượng Còn");
            for (TKThuocTinhSP_View t : lstTKTTSP) {
                i++;
                SanPham_Model sp = sp_sv.GetByMa(t.getMaSP());
                row = worksheet.createRow(i);
                maSP = row.createCell(0);
                maSP.setCellValue(t.getMaSP());
                ten = row.createCell(1);
                ten.setCellValue(t.getTenSP());
                thuongHieu = row.createCell(2);
                thuongHieu.setCellValue(sp.getThuongHieu().getTen());
                mauSac = row.createCell(3);
                mauSac.setCellValue(sp.getMauSac().getTen());
                size = row.createCell(4);
                size.setCellValue(t.getSize());
                slBan = row.createCell(5);
                slBan.setCellValue(t.getSlBan());
                slVCon = row.createCell(6);
                slVCon.setCellValue(t.getSlCon());
            }
            worbook.write(file);
            worbook.close();
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
