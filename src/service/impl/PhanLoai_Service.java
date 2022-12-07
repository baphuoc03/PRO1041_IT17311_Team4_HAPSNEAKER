/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.PhanLoai_Model;
import model.ThuongHieu_Model;
import repository.PhanLoai_repos;
import viewmodel.PhanLoai_View;
import service.IPhanLoai_Service;
import repository.IPhanLoai_repos;

/**
 *
 * @author baphuoc
 */
public class PhanLoai_Service implements IPhanLoai_Service {

    IPhanLoai_repos PL_repos = new PhanLoai_repos();
    List<PhanLoai_Model> List;

    @Override
    public List<PhanLoai_View> getAllPhanLoai() {
        List = PL_repos.getAllPhanLoai();
        List<PhanLoai_View> list_view = new ArrayList<>();
        int stt = 1;
        for (PhanLoai_Model p : List) {
            list_view.add(new PhanLoai_View(stt, p.getMa(), p.getTen()));
            stt++;
        }
        return list_view;
    }

    @Override
    public PhanLoai_Model getByMa(String ma) {
        return PL_repos.getByMa(ma);
    }

    @Override
    public int ADD(PhanLoai_Model p) {
        if (p.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Phân Loại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (p.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Phân Loại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (getByMa(p.getMa()) != null) {
            JOptionPane.showMessageDialog(null, "Phân Loại Đã Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Thành Công Phân Loại " + p.getTen());
            return PL_repos.add(p);
        }
    }

    @Override
    public int UPDATE(PhanLoai_Model p) {
        if (p.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Phân Loại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (p.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Phân Loại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (getByMa(p.getMa()) == null) {
            JOptionPane.showMessageDialog(null, "Phân Loại Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công Phân Loại " + p.getTen());
            return PL_repos.update(p);
        }
    }

    @Override
    public int DELETE(String ma) {
        if (getByMa(ma) == null) {
            JOptionPane.showMessageDialog(null, "Phân Loại Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            PhanLoai_Model p = getByMa(ma);
            JOptionPane.showMessageDialog(null, "Xóa Thành Công Phân Loại " + p.getTen());
            return PL_repos.delete(ma);
        }
    }

    @Override
    public PhanLoai_Model GetPhanLoaiByMa(String ma) {
        for (PhanLoai_Model p : List) {
            if (p.getMa().equals(ma)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<PhanLoai_View> Search(String key) {
        List = PL_repos.Search(key);
        List<PhanLoai_View> list_view = new ArrayList<>();
        int stt = 1;
        for (PhanLoai_Model p : List) {
            list_view.add(new PhanLoai_View(stt, p.getMa(), p.getTen()));
            stt++;
        }
        return list_view;
    }
}
