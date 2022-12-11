package View;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.KichThuoc_Model;
import model.MauSac_Model;
import model.NhanVien_Model;
import model.SanPham_Model;
import model.ThuocTinhSP_Model;
import model.ThuongHieu_Model;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import service.IKichThuoc_service;
import service.IMauSac_Service;
import service.ISanPham_Service;
import service.IThuocTinhSP_Service;
import service.IThuongHieu_Service;
import service.impl.KichThuoc_Service;
import service.impl.MauSac_Service;
import service.impl.SanPham_service;
import service.impl.ThuocTinhSP_service;
import service.impl.ThuongHieu_Service;
import viewmodel.SanPham_View;
import viewmodel.ThuocTinhSP_View;
import viewmodel.ThuocTinhSP_View;
import service.IPhanLoai_Service;
import service.impl.PhanLoai_Service;
import viewmodel.PhanLoai_View;
import service.impl.PLSanPham_Service;
import model.PlSp_Model;
import viewmodel.PLSanPham_View;
import model.PhanLoai_Model;
import service.IPLSanPham_Service;
import ultinities.ValiDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author 84353
 */
public class QLSanPham extends javax.swing.JPanel {

    IThuocTinhSP_Service TTS = new ThuocTinhSP_service();
    DefaultTableModel dtm;
    List<ThuocTinhSP_View> lstTT;
    List<ThuocTinhSP_Model> lstTTM = new ArrayList<>();
    List<SanPham_View> lstSP;
    ISanPham_Service SPS = new SanPham_service();
    List<SanPham_Model> lstSPM = new ArrayList<>();
    String idWhenclick;
    DefaultComboBoxModel THCBB = new DefaultComboBoxModel();
    DefaultComboBoxModel MSCBB = new DefaultComboBoxModel();
    DefaultComboBoxModel SPCBB = new DefaultComboBoxModel();
    DefaultComboBoxModel KTCBB = new DefaultComboBoxModel();
    List<ThuongHieu_Model> lstTH = new ArrayList<>();
    List<MauSac_Model> lstMS = new ArrayList<>();
    List<KichThuoc_Model> lstKT = new ArrayList<>();
    IThuongHieu_Service THS = new ThuongHieu_Service();
    IMauSac_Service MSS = new MauSac_Service();
    IKichThuoc_service KTS = new KichThuoc_Service();
    IPhanLoai_Service PLS = new PhanLoai_Service();
    List<PhanLoai_View> lstPL = new ArrayList<>();

    List<PLSanPham_View> lstPLV;
    IPLSanPham_Service plS = new PLSanPham_Service();
    String nameIcon = "";

    /**
     * Creates new form QLThuongHieu
     */
    public QLSanPham() {
        initComponents();
        this.cbbThuongHieu.setModel(THCBB);
        this.cbbMauSac.setModel(MSCBB);
        this.cbbSP.setModel(SPCBB);
        this.cbbMaSize.setModel(KTCBB);
        FillSanPham();
        FillFL();
        lstKT = TTS.GetAllKT();
        KTCBB.removeAllElements();
        for (var x : lstKT) {
            KTCBB.addElement(x.getMa());
        }
        SPCBB.removeAllElements();
        lstSPM = TTS.GetAllSP();
        for (var x : lstSP) {
            SPCBB.addElement(x.getMa());
        }
    }

    public void FillSanPham() {
        lstSP = SPS.GetAllSanPham();
        dtm = (DefaultTableModel) tblBangSP.getModel();
        dtm.setRowCount(0);
        int sl = 0;
        for (SanPham_View s : lstSP) {
            sl = 0;
            for (ThuocTinhSP_View thuocTinhSP_View : TTS.GetByMaTT(s.getMa())) {
                sl += thuocTinhSP_View.getsL();
            }
            dtm.addRow(new Object[]{s.getStt(), s.getMa(), s.getTen(), s.getThuongHieu(), s.getMauSac(), s.getGiaNhap(), s.getGiaBan(), sl, s.getTrangThai() == 1 ? "Hiển thị" : "Ẩn"});
        }
        lstTH = SPS.GetAllTH();
        for (var x : lstTH) {
            THCBB.addElement(x.getMa() + " - " + x.getTen());
        }

        lstMS = SPS.GetAllMS();
        for (var x : lstMS) {
            MSCBB.addElement(x.getMa() + " - " + x.getTen());
        }

    }

    public void FillSanPham(String ma) {
        lstSP = SPS.Search(ma);
        dtm = (DefaultTableModel) tblBangSP.getModel();
        dtm.setRowCount(0);
        int sl = 0;
        for (SanPham_View s : lstSP) {
            sl = 0;
            for (ThuocTinhSP_View thuocTinhSP_View : TTS.GetByMaTT(s.getMa())) {
                sl += thuocTinhSP_View.getsL();
            }
            dtm.addRow(new Object[]{s.getStt(), s.getMa(), s.getTen(), s.getThuongHieu(), s.getMauSac(), s.getGiaNhap(), s.getGiaBan(), sl, s.getTrangThai() == 1 ? "Hiển thị" : "Ẩn"});
        }

    }

    public void FillThuocTinh(String ma) {
        lstTT = TTS.GetByMaTT(ma);
        dtm = (DefaultTableModel) tblPhanLoai.getModel();
        dtm.setRowCount(0);
        for (ThuocTinhSP_View t : lstTT) {
            dtm.addRow(new Object[]{t.getStt(), t.getId(), t.getMaSP(), t.getMaKT(), t.getsL()});
        }
        SanPham_Model sp = SPS.GetByMa(ma);
        SPCBB.setSelectedItem(sp.getMa());
        txtTenSP2.setText(sp.getTen());
    }

    public SanPham_Model GetDataSanPham() {
        String Ma = txtSanPham.getText();
        String Ten = txtTenSP.getText();
        String TH = cbbThuongHieu.getSelectedItem().toString().split(" ")[0];
        ThuongHieu_Model t = THS.getByMa(TH);
        String MS = cbbMauSac.getSelectedItem().toString().split(" ")[0];
        MauSac_Model m = MSS.getByMa(MS);
        String moTa = txtMoTa.getText();
        String giaNhap = txtGiaNhap.getText();
        String giaBan = txtGiaBan.getText();
        int trangThai;
        if (radioHienThi.isSelected() == true) {
            trangThai = 1;
        } else {
            trangThai = 2;
        }
        String hinh = nameIcon;
        if (giaBan.length() == 0) {
            return new SanPham_Model(Ma, Ten, t, m, moTa, Float.valueOf(giaNhap), 0, trangThai, hinh);
        } else {
            return new SanPham_Model(Ma, Ten, t, m, moTa, Float.valueOf(giaNhap), Float.valueOf(giaBan), trangThai, hinh);
        }
    }

    public ThuocTinhSP_Model GetDataThuocTinhSP() {
        //String id = null;

        String maSP = cbbSP.getSelectedItem().toString();
        SanPham_Model s = SPS.GetByMa(maSP);
        String maKT = cbbMaSize.getSelectedItem().toString();
        KichThuoc_Model k = KTS.getByMa(maKT);
        String SL = txtSoLuong.getText();
        if (SL.length() == 0) {
            return new ThuocTinhSP_Model(null, s, k, 0);
        } else {
            return new ThuocTinhSP_Model(null, s, k, Integer.valueOf(SL));
        }
    }

    public void ShowSanPham(SanPham_Model s) {
        int i = tblBangSP.getSelectedRow();
        txtSanPham.setText(s.getMa());
        txtTenSP.setText(s.getTen());
        txtMoTa.setText(s.getMoTa());
        txtGiaNhap.setText(String.valueOf(s.getGiaNhap()));
        txtGiaBan.setText(String.valueOf(s.getGiaBan()));
        cbbThuongHieu.setSelectedItem(s.getThuongHieu().getMa() + " - " + s.getThuongHieu().getTen());
        cbbMauSac.setSelectedItem(s.getMauSac().getMa() + " - " + s.getMauSac().getTen());
        txtTenSP2.setText(s.getTen());
        if (s.getTrangThai() == 1) {
            radioHienThi.setSelected(true);
        } else {
            radioAn.setSelected(true);
        }
        setImages(s.getHinh());
        nameIcon = s.getHinh();
        cbbSP.setSelectedItem(lstSP.get(i).getMa());
        fillPLSP(s.getMa());

    }

    public void ShowThuocTinhSP() {
        int i = tblPhanLoai.getSelectedRow();
        if (i == -1) {
            return;
        }
        idWhenclick = tblPhanLoai.getModel().getValueAt(i, 1).toString();
        var t = TTS.GetThuongHieuSPByMa(idWhenclick);
        txtSoLuong.setText(String.valueOf(t.getSl()));
        cbbSP.setSelectedItem(lstTT.get(i).getMaSP());
        cbbMaSize.setSelectedItem(lstTT.get(i).getMaKT());
        //txtTenSP2.setText(lstSP.get(i).getTen());

    }

    public void FillFL() {
        lstPL = PLS.getAllPhanLoai();
        dtm = (DefaultTableModel) tblPL.getModel();
        dtm.setRowCount(0);
        for (PhanLoai_View p : lstPL) {
            dtm.addRow(new Object[]{p.getStt(), p.getMa(), p.getTen()});
        }
    }

    public void fillPLSP(String maSP) {
        for (int i = 0; i < tblPL.getRowCount(); i++) {
            tblPL.setValueAt(false, i, 3);

        }

        List<PLSanPham_View> plSP = plS.GetByMa(maSP);
        for (int i = 0; i < tblPL.getRowCount(); i++) {
            for (PLSanPham_View p : plSP) {
                if (p.getMaPL().equalsIgnoreCase(tblPL.getValueAt(i, 1).toString())) {
                    tblPL.setValueAt(true, i, 3);
                    System.out.println("333");
                }
            }
            System.out.println("111");
        }
    }

    public void addPLSP() {
        List<PhanLoai_Model> lstPLSP = new ArrayList<>();
        for (int i = 0; i < tblPL.getRowCount(); i++) {
            if (Boolean.parseBoolean(tblPL.getValueAt(i, 3).toString()) == true) {
                lstPLSP.add(PLS.getByMa(tblPL.getValueAt(i, 1) + ""));
            }
        }
        for (PhanLoai_Model p : lstPLSP) {
            plS.add(new PlSp_Model(p, GetDataSanPham()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtSearchSP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangSP = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        txtSanPham = new javax.swing.JTextField();
        btnThemSP = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnClearSP = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbThuongHieu = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        radioHienThi = new javax.swing.JRadioButton();
        radioAn = new javax.swing.JRadioButton();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPL = new javax.swing.JTable();
        btnMorePL = new javax.swing.JButton();
        btnMoreMau = new javax.swing.JButton();
        btnMoreTH = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhanLoai = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnThemPL = new javax.swing.JButton();
        btnSuaPL = new javax.swing.JButton();
        btnXoaPL = new javax.swing.JButton();
        btnClearPL = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbbSP = new javax.swing.JComboBox<>();
        cbbMaSize = new javax.swing.JComboBox<>();
        btnMoreSize = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtTenSP2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("SẢN PHẨM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane1MousePressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng thông tin sản phẩm"));

        txtSearchSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchSPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchSPKeyReleased(evt);
            }
        });

        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblBangSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Mã TH", "Mã màu", "Giá nhập", "Giá bán", "SL Tồn", "Trạng thái"
            }
        ));
        tblBangSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangSPMouseClicked(evt);
            }
        });
        tblBangSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblBangSPKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBangSP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Sản Phẩm"));

        jLabel2.setText("Mã sản phẩm:");

        jLabel3.setText("Tên sản phẩm:");

        btnThemSP.setText("Thêm");
        btnThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPActionPerformed(evt);
            }
        });

        btnSuaSP.setText("Sửa");
        btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnClearSP.setText("Clear");

        jLabel4.setText("Mã thương hiệu:");

        jLabel5.setText("Mã màu:");

        cbbThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThuongHieuActionPerformed(evt);
            }
        });

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSacActionPerformed(evt);
            }
        });

        jLabel7.setText("Giá nhập:");

        jLabel8.setText("Giá bán:");

        jLabel9.setText("Mô tả:");

        jLabel10.setText("Trạng thái:");

        buttonGroup1.add(radioHienThi);
        radioHienThi.setSelected(true);
        radioHienThi.setText("Hiển thị");

        buttonGroup1.add(radioAn);
        radioAn.setText("Ẩn");

        jLabel6.setText("Phân loại:");

        tblPL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPL);

        btnMorePL.setText("+");
        btnMorePL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMorePLActionPerformed(evt);
            }
        });

        btnMoreMau.setText("+");
        btnMoreMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreMauActionPerformed(evt);
            }
        });

        btnMoreTH.setText("+");
        btnMoreTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreTHActionPerformed(evt);
            }
        });

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setText("Click Để Chọn Ảnh");
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMorePL)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(txtGiaNhap)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMoreTH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMoTa)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnXoaSP)
                                    .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnClearSP, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSuaSP))
                                .addGap(145, 145, 145))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(64, 64, 64)
                                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMoreMau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioAn)
                                    .addComponent(radioHienThi)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(txtSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearSP, btnSuaSP, btnThemSP, btnXoaSP});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoreTH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(btnMoreMau))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(radioHienThi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioAn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(btnMorePL))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSP)
                    .addComponent(btnSuaSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSP)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearSP, btnSuaSP, btnThemSP, btnXoaSP});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thuộc Tính Sản Phẩm"));

        jButton9.setText("Tìm Kiếm");

        tblPhanLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Mã SP", "Mã Size", "Số lượng"
            }
        ));
        tblPhanLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhanLoaiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhanLoai);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Thuộc Tính"));

        jLabel11.setText("Sản phẩm:");

        jLabel12.setText("Size");

        btnThemPL.setText("Thêm");
        btnThemPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPLActionPerformed(evt);
            }
        });

        btnSuaPL.setText("Sửa");
        btnSuaPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPLActionPerformed(evt);
            }
        });

        btnXoaPL.setText("Xóa");
        btnXoaPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPLActionPerformed(evt);
            }
        });

        btnClearPL.setText("Clear");
        btnClearPL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearPLActionPerformed(evt);
            }
        });

        jLabel13.setText("Số lượng:");

        cbbSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSPItemStateChanged(evt);
            }
        });

        cbbMaSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnMoreSize.setText("+");
        btnMoreSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreSizeActionPerformed(evt);
            }
        });

        jLabel14.setText("Tên SP:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemPL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaPL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearPL)
                    .addComponent(btnSuaPL))
                .addGap(117, 117, 117))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cbbMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMoreSize))
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTenSP2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbbSP, javax.swing.GroupLayout.Alignment.LEADING, 0, 239, Short.MAX_VALUE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnClearPL, btnSuaPL, btnThemPL, btnXoaPL});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbbSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txtTenSP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbbMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoreSize))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaPL)
                    .addComponent(btnThemPL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaPL)
                    .addComponent(btnClearPL))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnClearPL, btnSuaPL, btnThemPL, btnXoaPL});

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Phân loại sản phẩm", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThuongHieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbThuongHieuActionPerformed

    private void cbbMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMauSacActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //SPS.Search(txtSearchSP.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // TODO add your handling code here:
        if (SPS.DELETE(GetDataSanPham().getMa()) == 0) {
            return;
        }
        cbbSP.removeItem(GetDataSanPham().getMa());
        FillSanPham();

    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnMoreTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreTHActionPerformed
        // TODO add your handling code here:
        JFrame frameChild = new JFrame();
        frameChild.setSize(900, 450);
        frameChild.setLocationRelativeTo(null);
        frameChild.add(new QLThuongHieu());
        frameChild.setVisible(true);
    }//GEN-LAST:event_btnMoreTHActionPerformed

    private void btnMoreMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreMauActionPerformed
        // TODO add your handling code here:
        JFrame frameChild = new JFrame();
        frameChild.setSize(900, 450);
        frameChild.setLocationRelativeTo(null);
        frameChild.add(new QLMauSac());
        frameChild.setVisible(true);
    }//GEN-LAST:event_btnMoreMauActionPerformed

    private void btnMorePLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMorePLActionPerformed
        // TODO add your handling code here:
        JFrame frameChild = new JFrame();
        frameChild.setSize(900, 450);
        frameChild.setLocationRelativeTo(null);
        frameChild.add(new QLPhanLoai());
        frameChild.setVisible(true);
    }//GEN-LAST:event_btnMorePLActionPerformed

    private void btnMoreSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreSizeActionPerformed
        // TODO add your handling code here:
        JFrame frameChild = new JFrame();
        frameChild.setSize(900, 450);
        frameChild.setLocationRelativeTo(null);
        frameChild.add(new QLKichThuoc());
        frameChild.setVisible(true);
    }//GEN-LAST:event_btnMoreSizeActionPerformed

    private void tblBangSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangSPMouseClicked
        // TODO add your handling code here:
        int index = tblBangSP.getSelectedRow();
        SanPham_Model sp = SPS.getSPByMa(tblBangSP.getValueAt(index, 1).toString());
        ShowSanPham(sp);

        FillThuocTinh(tblBangSP.getValueAt(index, 1).toString());

    }//GEN-LAST:event_tblBangSPMouseClicked

    private void btnThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPActionPerformed
        // TODO add your handling code here:
        if (getValidateSP() == false) {
            return;
        }
        if (SPS.ADD(GetDataSanPham()) == 0) {
            return;
        }
        FillSanPham();
        addPLSP();
        cbbSP.addItem(GetDataSanPham().getMa());
    }//GEN-LAST:event_btnThemSPActionPerformed

    private void btnSuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSPActionPerformed
        // TODO add your handling code here:
        if (getValidateSP() == false) {
            return;
        }
        if (plS.delete(txtSanPham.getText()) == 0) {
            return;
        }

        addPLSP();
        SPS.UPDATE(GetDataSanPham());

        FillSanPham();

    }//GEN-LAST:event_btnSuaSPActionPerformed

    private void btnThemPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPLActionPerformed
        // TODO add your handling code here:
        if (getValiDateTTSP() == false) {
            return;
        }
        if (TTS.ADD(GetDataThuocTinhSP()) == 0) {
            return;
        }
        FillThuocTinh(cbbSP.getSelectedItem().toString());
    }//GEN-LAST:event_btnThemPLActionPerformed

    private void btnSuaPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPLActionPerformed
        // TODO add your handling code here:
        if (getValiDateTTSP() == false) {
            return;
        }
        int index = tblPhanLoai.getSelectedRow();
        ThuocTinhSP_Model ttsp = GetDataThuocTinhSP();
        ttsp.setId(tblPhanLoai.getValueAt(index, 1).toString());
        if (TTS.UPDATE(ttsp) == 0) {
            return;
        }
        FillThuocTinh(SPCBB.getSelectedItem().toString());
    }//GEN-LAST:event_btnSuaPLActionPerformed

    private void btnXoaPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPLActionPerformed
        // TODO add your handling code here:
        int index = tblPhanLoai.getSelectedRow();
        String id = tblPhanLoai.getValueAt(index, 1).toString();
        if (TTS.DELETE(id) == 0) {
            return;
        }
        FillThuocTinh(SPCBB.getSelectedItem().toString());
    }//GEN-LAST:event_btnXoaPLActionPerformed

    private void btnClearPLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearPLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearPLActionPerformed

    private void tblPhanLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhanLoaiMouseClicked
        // TODO add your handling code here:
        ShowThuocTinhSP();
    }//GEN-LAST:event_tblPhanLoaiMouseClicked

    private void txtSearchSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSPKeyPressed
        // TODO add your handling code here:
//        SPS.Search(txtSearchSP.getText());
//        FillSanPham();
    }//GEN-LAST:event_txtSearchSPKeyPressed

    private void txtSearchSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchSPKeyReleased
        // TODO add your handling code here:
        FillSanPham(txtSearchSP.getText());
    }//GEN-LAST:event_txtSearchSPKeyReleased

    private void tblBangSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBangSPKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tblBangSPKeyReleased

    private void cbbSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSPItemStateChanged
        // TODO add your handling code here:
        FillThuocTinh(SPCBB.getSelectedItem().toString());
    }//GEN-LAST:event_cbbSPItemStateChanged

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser("/Users/baphuoc/Documents/DuAn1/DuAn1/src/icon");
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("hinh anh", "jpg", "jpeg", "png", "webp");
        filechooser.setFileFilter(imageFilter);

        int x = filechooser.showDialog(this, "Chọn Hình Ảnh");
        if (x == JFileChooser.APPROVE_OPTION) {
            File f = filechooser.getSelectedFile();
            nameIcon = f.getAbsolutePath();
            lblAnh.removeAll();
            setImages(nameIcon);
        }
    }//GEN-LAST:event_lblAnhMouseClicked

    private void jTabbedPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTabbedPane1MousePressed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTabbedPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnClearPL;
    public javax.swing.JButton btnClearSP;
    public javax.swing.JButton btnMoreMau;
    public javax.swing.JButton btnMorePL;
    public javax.swing.JButton btnMoreSize;
    public javax.swing.JButton btnMoreTH;
    public javax.swing.JButton btnSuaPL;
    public javax.swing.JButton btnSuaSP;
    public javax.swing.JButton btnThemPL;
    public javax.swing.JButton btnThemSP;
    public javax.swing.JButton btnXoaPL;
    public javax.swing.JButton btnXoaSP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMaSize;
    public static javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbSP;
    public static javax.swing.JComboBox<String> cbbThuongHieu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JRadioButton radioAn;
    private javax.swing.JRadioButton radioHienThi;
    private javax.swing.JTable tblBangSP;
    public static javax.swing.JTable tblPL;
    private javax.swing.JTable tblPhanLoai;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSanPham;
    private javax.swing.JTextField txtSearchSP;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenSP2;
    // End of variables declaration//GEN-END:variables
    public void FillThuocTinh() {
        lstTT = TTS.GetAllThuocTinhSP();
        dtm = (DefaultTableModel) tblPhanLoai.getModel();
        dtm.setRowCount(0);
        for (ThuocTinhSP_View t : lstTT) {
            dtm.addRow(new Object[]{t.getStt(), t.getId(), t.getMaSP(), t.getMaKT(), t.getsL()});
        }
    }

    public boolean getValidateSP() {
        if (ValiDate.isNull(txtGiaNhap, "Không Để Trống Giá Nhập")) {
            return false;
        } else if (ValiDate.isFlaot(txtGiaNhap, "Giá Nhập Phải Là Số")) {
            return false;
        } else if (txtGiaBan.getText().length() > 0) {
            if (ValiDate.isFlaot(txtGiaBan, "Giá Bán Phải Là Số")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean getValiDateTTSP() {
        if (ValiDate.isFlaot(txtSoLuong, "Số Lượng Phải Là Số")) {
            return false;
        } else {
            return true;
        }
    }

    public void setImages(String image) {
        if (image == null) {
            image = "src/icon/logo_blue.png";
        }
        ImageIcon images = new ImageIcon(image);
        Image im = images.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(200, 110, im.SCALE_SMOOTH));
        lblAnh.setText(null);
        lblAnh.setIcon(icon);
//        lblAnh.setPreferredSize(new Dimension(width, height));
    }


}
