/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.SanPham_Model;
import viewmodel.SanPham_View;
import repository.SanPham_repos;
import service.impl.SanPham_service;
import repository.ThuongHieu_repos;
import repository.MauSac_repos;
import model.ThuongHieu_Model;
import model.MauSac_Model;
import repository.IMauSac_repos;
import repository.ISanPham_repos;
import repository.IThuongHieu_Repos;
import service.ISanPham_Service;

/**
 *
 * @author 84353
 */
public class SanPham_service implements ISanPham_Service {

    List<SanPham_Model> list;
    ISanPham_repos repo = new SanPham_repos();
    IThuongHieu_Repos THrepo = new ThuongHieu_repos();
    IMauSac_repos MSrepo = new MauSac_repos();

    @Override
    public List<SanPham_View> GetAllSanPham() {
        List<SanPham_View> lst_view = new ArrayList<>();
        list = repo.GetAllSanPham();
        int stt = 1;
        for (SanPham_Model s : list) {
            lst_view.add(new SanPham_View(stt++, s.getMa(), s.getTen(), s.getThuongHieu().getMa(), s.getMauSac().getMa(), s.getMoTa(), s.getGiaNhap(), s.getGiaBan(), s.getTrangThai()));
        }
        return lst_view;
    }

    @Override
    public int ADD(SanPham_Model s) {
        if (s.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Sản Phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (s.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Sản Phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (s.getGiaNhap() < 0) {
            JOptionPane.showMessageDialog(null, "Giá Nhập Phải >0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (s.getGiaBan() < 0) {
            JOptionPane.showMessageDialog(null, "Giá Bán Phải >0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (GetByMa(s.getMa()) != null) {
            JOptionPane.showMessageDialog(null, "Sản Phẩm Đã Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Thành Công Sản Phẩm " + s.getTen());
            return repo.add(s);
        }
    }

    @Override
    public int DELETE(String s) {
        if (GetByMa(s) == null) {
            JOptionPane.showMessageDialog(null, "Sản Phẩm Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            SanPham_Model sp = GetByMa(s);
<<<<<<< HEAD
            JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công Sản Phẩm " + sp.getTen());
=======
            JOptionPane.showMessageDialog(null, "Xóa Thành Công Sản Phẩm " + sp.getTen());
>>>>>>> origin/baphuoc
        return repo.delete(s);
        }
    }

    @Override
    public int UPDATE(SanPham_Model s) {
        if (s.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Sản Phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (s.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Sản Phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (s.getGiaNhap() < 0) {
            JOptionPane.showMessageDialog(null, "Giá Nhập Phải >0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (s.getGiaBan() < 0) {
            JOptionPane.showMessageDialog(null, "Giá Bán Phải >0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (GetByMa(s.getMa()) == null) {
            JOptionPane.showMessageDialog(null, "Sản Phẩm Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công Sản Phẩm " + s.getTen());
            return repo.update(s);
        }
    }

    @Override
    public List<ThuongHieu_Model> GetAllTH() {
        return THrepo.getAllThuongHieu();
    }

    @Override
    public List<MauSac_Model> GetAllMS() {
        return MSrepo.getAllMauSac();
    }

    @Override
    public List<SanPham_Model> GetSanPhamByMaKM(String maKM) {
        return repo.GetSanPhamByMaKM(maKM);
    }

    @Override
    public SanPham_Model getSPByMa(String ma) {
        return repo.GetSanPhamByMa(ma);
    }

    @Override
    public SanPham_Model GetByMa(String ma) {
        return repo.GetSanPhamByMa(ma);
    }

    public List<SanPham_View> Search(String key) {
        List<SanPham_View> lst_view = new ArrayList<>();
        list = repo.serchSP(key);
        int stt = 1;
        for (SanPham_Model s : list) {
            lst_view.add(new SanPham_View(stt++, s.getMa(), s.getTen(), s.getThuongHieu().getMa(), s.getMauSac().getMa(), s.getMoTa(), s.getGiaNhap(), s.getGiaBan(), s.getTrangThai()));
        }
        return lst_view;
    }
}
