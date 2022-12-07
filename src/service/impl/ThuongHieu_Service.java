/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ThuongHieu_Model;
import repository.ThuongHieu_repos;
import viewmodel.ThuongHieu_View;
import repository.IThuongHieu_Repos;
import service.IThuongHieu_Service;

/**
 *
 * @author baphuoc
 */
public class ThuongHieu_Service implements IThuongHieu_Service {

    IThuongHieu_Repos TH_repos = new ThuongHieu_repos();
    List<ThuongHieu_Model> lstTHM;

    @Override
    public List<ThuongHieu_View> getAllThuongHieu() {
        List<ThuongHieu_Model> list = TH_repos.getAllThuongHieu();
        List<ThuongHieu_View> list_view = new ArrayList<>();
        int stt = 1;
        for (ThuongHieu_Model t : list) {
            list_view.add(new ThuongHieu_View(stt, t.getMa(), t.getTen()));
            stt++;
        }
        return list_view;
    }

    @Override
    public ThuongHieu_Model GetThuongHieuByMa(String ma) {
        return TH_repos.getThuongHieuByMa1(ma);
    }

    @Override
    public int Add(ThuongHieu_Model th) {
        if (th.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Thương Hiệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (th.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Thương Hiệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (GetThuongHieuByMa(th.getMa()) != null) {
            JOptionPane.showMessageDialog(null, "Thương Hiệu Đã Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Thành Công Thương Hiệu " + th.getTen());
            return TH_repos.Add(th);

        }
    }

    @Override
    public int Update(ThuongHieu_Model th) {
        if (th.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Thương Hiệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (th.getTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Thương Hiệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (GetThuongHieuByMa(th.getMa()) == null) {
            JOptionPane.showMessageDialog(null, "Thương Hiệu Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công Thương Hiệu " + th.getTen());
            return TH_repos.update(th);
        }
    }

    @Override
    public int Delete(String ma) {
        if (GetThuongHieuByMa(ma) == null) {
            JOptionPane.showMessageDialog(null, "Thương Hiệu Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            ThuongHieu_Model th = GetThuongHieuByMa(ma);
            JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công Thương Hiệu " + th.getTen());
            return TH_repos.delete(ma);
        }
    }

    @Override
    public ThuongHieu_Model getByMa(String ma) {
        return TH_repos.getThuongHieuByMa1(ma);

    }

    @Override
    public List<ThuongHieu_View> Search(String key) {
        List<ThuongHieu_Model> list = TH_repos.Search(key);
        List<ThuongHieu_View> list_view = new ArrayList<>();
        int stt = 1;
        for (ThuongHieu_Model t : list) {
            list_view.add(new ThuongHieu_View(stt, t.getMa(), t.getTen()));
            stt++;
        }
        return list_view;
    }
}
