/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.KichThuoc_Model;
import model.SanPham_Model;
import model.ThuocTinhSP_Model;
import repository.KichThuoc_repos;
import repository.SanPham_repos;
import viewmodel.ThuocTinhSP_View;
import repository.ThuocTinhSP_repos;
import repository.IKichThuoc_repos;
import repository.ISanPham_repos;
import repository.IThuocTinhSP_Repos;
import repository.IThuocTinhSP_Repos;
import service.IThuocTinhSP_Service;

/**
 *
 * @author 84353
 */
public class ThuocTinhSP_service implements IThuocTinhSP_Service {

    IThuocTinhSP_Repos repo = new ThuocTinhSP_repos();
    List<ThuocTinhSP_Model> list;
    ISanPham_repos SPrepo = new SanPham_repos();
    IKichThuoc_repos KTrepo = new KichThuoc_repos();

    @Override
    public List<ThuocTinhSP_View> GetAllThuocTinhSP() {
        List<ThuocTinhSP_View> lst_view = new ArrayList<>();
        list = repo.GetAllThuocTinhSP();
        int stt = 1;
        for (ThuocTinhSP_Model t : list) {
            lst_view.add(new ThuocTinhSP_View(stt, t.getId(), t.getSanPham().getMa(), t.getSanPham().getTen(), t.getSanPham().getThuongHieu().getTen(), t.getSanPham().getMauSac().getTen(), t.getKichThuoc().getMa() + "", t.getSl(), t.getSanPham().getGiaBan()));
        }
        return lst_view;
    }

    @Override
    public ThuocTinhSP_Model GetThuongHieuSPByMa(String id) {
        for (ThuocTinhSP_Model t : list) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public List<ThuocTinhSP_View> FilterThuocTinhSP(String keyWord, String maSize, String MaTH, String MaMau, String MaPL) {
        List<ThuocTinhSP_View> lst_view = new ArrayList<>();
        list = repo.FilterThuocTinhSP(keyWord, maSize, MaTH, MaMau, MaPL);
        int stt = 1;
        for (ThuocTinhSP_Model t : list) {
            lst_view.add(new ThuocTinhSP_View(stt, t.getId(), t.getSanPham().getMa(), t.getSanPham().getTen(), t.getSanPham().getThuongHieu().getTen(), t.getSanPham().getMauSac().getTen(), t.getKichThuoc().getMa() + "", t.getSl(), t.getSanPham().getGiaBan()));
            stt++;
        }
        return lst_view;
    }
    @Override
    public List<ThuocTinhSP_View> findTTSP(String keyWord) {
        List<ThuocTinhSP_View> lst_view = new ArrayList<>();
        list = repo.findTTSP(keyWord);
        int stt = 1;
        for (ThuocTinhSP_Model t : list) {
            lst_view.add(new ThuocTinhSP_View(stt, t.getId(), t.getSanPham().getMa(), t.getSanPham().getTen(), t.getSanPham().getThuongHieu().getTen(), t.getSanPham().getMauSac().getTen(), t.getKichThuoc().getMa() + "", t.getSl(), t.getSanPham().getGiaBan()));
            stt++;
        }
        return lst_view;
    }
    public List<ThuocTinhSP_View> GetByMaTT(String maSP) {
        List<ThuocTinhSP_View> lst_view = new ArrayList<>();
        list = repo.GetByMaTT(maSP);
        int stt = 1;
        for (ThuocTinhSP_Model t : list) {
            lst_view.add(new ThuocTinhSP_View(stt, t.getId(), t.getSanPham().getMa(), t.getSanPham().getTen(), null, null, t.getKichThuoc().getMa() + "", t.getSl(), t.getSanPham().getGiaBan()));
            stt++;
        }
        return lst_view;

    }
    @Override
    public List<ThuocTinhSP_View> findTTSPByPL(String PL) {
        List<ThuocTinhSP_View> lst_view = new ArrayList<>();
        list = repo.findTTSPByPL(PL);
        int stt = 1;
        for (ThuocTinhSP_Model t : list) {
            lst_view.add(new ThuocTinhSP_View(stt, t.getId(), t.getSanPham().getMa(), t.getSanPham().getTen(), null, null, t.getKichThuoc().getMa() + "", t.getSl(), t.getSanPham().getGiaBan()));
            stt++;
        }
        return lst_view;
    }
    @Override
    public int ADD(ThuocTinhSP_Model t) {
        if (t.getSl() < 0) {
            JOptionPane.showMessageDialog(null, "Số Lượng Phải > 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Thành Công Thuộc Tính Sản Phẩm");
            return repo.add(t);
        }
    }

    @Override
    public int DELETE(String id) {
        JOptionPane.showMessageDialog(null, "Xóa Thành Công Thuộc Tính Sản Phẩm");
        return repo.delete(id);
    }

    @Override
    public int UPDATE(ThuocTinhSP_Model t) {
        if (t.getSl() < 0) {
            JOptionPane.showMessageDialog(null, "Số Lượng Phải > 0", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công Thuộc Tính Sản Phẩm");
        return repo.undate(t);
        }
    }

    @Override
    public List<SanPham_Model> GetAllSP() {
        return SPrepo.GetAllSanPham();
    }

    @Override
    public List<KichThuoc_Model> GetAllKT() {
        return KTrepo.getAllKichThuoc();
    }

    @Override
    public ThuocTinhSP_Model getById(String id) {
        return repo.getById(id);
    }

    @Override
    public int updateSL(ThuocTinhSP_Model sp, int SL) {
        return repo.undateSL(sp, SL);
    }


    
}
