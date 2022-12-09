/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.KhachHang_Model;
import repository.Khachhang_Repos;
import viewmodel.KhachHang_View;
import repository.IKhachHang_repos;
import service.IKhachHang_Service;

/**
 *
 * @author admin
 */
public class KhachHang_Service implements IKhachHang_Service {

    IKhachHang_repos kh = new Khachhang_Repos();
    List<KhachHang_Model> list;

    @Override
    public List<KhachHang_View> getAllKhachHang() {
        List<KhachHang_View> list_view = new ArrayList<>();
        list = kh.getAllKhachHang();
        for (KhachHang_Model k : list) {
            list_view.add(new KhachHang_View(k.getSđt(), k.getHoTen(), k.getGioiTinh(), k.getNgaySinh(), k.getEmail(), k.getDiaChi()));
        }
        return list_view;
    }

    @Override
    public KhachHang_Model getBySĐT(String SĐT) {
        return kh.getBySĐT(SĐT);
    }

    @Override
    public int addKH(KhachHang_Model kh) {
        if (kh.getSđt().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Số Điện Thoại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (!kh.getSđt().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Đúng Định Dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (kh.getHoTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Họ Tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (kh.getEmail().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Email", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } /*else if (!kh.getEmail().matches("[a-zA-Z0-9]{1,}@[a-zA-Z0-9.]{1,}.[a-zA-Z0-9]{1,}")) {
            JOptionPane.showMessageDialog(null, "Email Không Đúng Định Dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } */else if (this.kh.getBySĐT(kh.getSđt()) != null) {
            JOptionPane.showMessageDialog(null, "Khách Hàng Đã Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Thành Công Khách Hàng " + kh.getHoTen());
            return this.kh.addKH(kh);
        }
    }

    @Override
    public int delKH(String sdt) {
        KhachHang_Model kh = this.kh.getBySĐT(sdt);
        if (kh == null) {
            JOptionPane.showMessageDialog(null, "Khách Hàng Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Xóa Thành Công Khách Hàng " + kh.getHoTen());
            return this.kh.delKH(sdt);
        }
    }

    @Override
    public int updateKH(KhachHang_Model kh) {
        if (kh.getSđt().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Số Điện Thoại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (!kh.getSđt().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Đúng Định Dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (kh.getHoTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Họ Tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (kh.getEmail().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Email", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } /*else if (!kh.getEmail().matches("[a-zA-Z0-9]{1,}@[a-zA-Z0-9.]{1,}.[a-zA-Z0-9]{1,}")) {
            JOptionPane.showMessageDialog(null, "Email Không Đúng Định Dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }*/ else if (this.kh.getBySĐT(kh.getSđt()) == null) {
            JOptionPane.showMessageDialog(null, "Khách Hàng Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Xóa Thành Công Khách Hàng " + kh.getHoTen());
            return this.kh.updateKH(kh);
        }
    }

    @Override
    public List<KhachHang_View> FindKhachHang(String keyWord) {
        List<KhachHang_View> list_view = new ArrayList<>();
        list = kh.FindKhachHang(keyWord);
        for (KhachHang_Model k : list) {
            list_view.add(new KhachHang_View(k.getSđt(), k.getHoTen(), k.getGioiTinh(), k.getNgaySinh(), k.getEmail(), k.getDiaChi()));
        }
        return list_view;
    }
}
