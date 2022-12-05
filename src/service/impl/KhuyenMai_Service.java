/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.KhuyenMai_Model;
import repository.KhuyenMai_repos;
import viewmodel.KhuyenMai_View;
import repository.IKhuyenMai_repos;
import service.IKhuyenMai_Service;

/**
 *
 * @author phamtuananh
 */
public class KhuyenMai_Service implements IKhuyenMai_Service {

    IKhuyenMai_repos KM_view = new KhuyenMai_repos();
    List<KhuyenMai_Model> list;

    @Override
    public List<KhuyenMai_View> getAllKhuyenMai() {
        List<KhuyenMai_View> listKM_view = new ArrayList<>();
        list = KM_view.getAllKhuyenMai();
        int stt = 1;
        for (KhuyenMai_Model km : list) {
            listKM_view.add(new KhuyenMai_View(stt, km.getMa(), km.getTen(), km.getGiamGia(), km.getNgayBatDau(), km.getNgayKetThuc()));
            stt++;

        }
        return listKM_view;
    }

    @Override
    public int add(KhuyenMai_Model km) {
        if (km.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Mã", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (km.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (km.getGiamGia() <= 0 || km.getGiamGia() > 100) {
            JOptionPane.showMessageDialog(null, "Mức Giảm Giá Phải > 0 và <= 100", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (km.getNgayBatDau().after(km.getNgayKetThuc())) {
            JOptionPane.showMessageDialog(null, "Ngày Bắt Đầu Phải <= Ngày Kết Thúc", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (KM_view.getKhuyenMaiByMa(km.getMa()) != null) {
            JOptionPane.showMessageDialog(null, "Khuyến Mãi Đã Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Khuyến Mãi Thành Công " + km.getTen());
            System.out.println("212");
            return KM_view.add(km);
        }
    }

    @Override
    public int delete(KhuyenMai_Model km) {
        if (KM_view.getKhuyenMaiByMa(km.getMa()) == null) {
            JOptionPane.showMessageDialog(null, "Khuyến Mãi Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Xóa Thành Công " + km.getTen());
            return KM_view.delete(km);
        }
    }

    @Override
    public int update(KhuyenMai_Model km) {
        if (km.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Mã", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (km.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Tên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (km.getGiamGia() <= 0 || km.getGiamGia() > 100) {
            JOptionPane.showMessageDialog(null, "Mức Giảm Giá Phải > 0 và <= 100", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (km.getNgayBatDau().after(km.getNgayKetThuc())) {
            JOptionPane.showMessageDialog(null, "Ngày Bắt Đầu Phải <= Ngày Kết Thúc", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (KM_view.getKhuyenMaiByMa(km.getMa()) == null) {
            JOptionPane.showMessageDialog(null, "Khuyến Mãi Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Cập Nhật Khuyến Mãi Thành Công " + km.getTen());
            return KM_view.update(km);
        }
    }

    @Override
    public KhuyenMai_Model getKhuyenMaiByMa(String ma) {
        return KM_view.getKhuyenMaiByMa(ma);
    }
    public static void main(String[] args) {
        IKhuyenMai_repos KM_view = new KhuyenMai_repos();
        if (KM_view.getKhuyenMaiByMa("KM10") != null) {
            JOptionPane.showMessageDialog(null, "Khuyến Mãi Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

}
