/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.NhanVien_Model;
import repository.NhanVien_Repos;
import viewmodel.NhanVien_View;
import repository.INhanVien_Repos;
import service.INhanVien_Service;

/**
 *
 * @author admin
 */
public class NhanVien_Service implements INhanVien_Service {

    INhanVien_Repos nv = new NhanVien_Repos();
    List<NhanVien_Model> list;

    @Override
    public List<NhanVien_View> getAllNhanVien() {
        List<NhanVien_View> list_view = new ArrayList<>();
        list = nv.getAllNhanVien();
        for (NhanVien_Model n : list) {
            list_view.add(new NhanVien_View(n.getMa(), n.getHoTen(), n.getGioiTinh(), n.getNgaySinh(), n.getSđt(), n.getDiaChi(), n.getPassWord(), n.getChucVu()));
        }
        return list_view;
    }

    @Override
    public NhanVien_Model getByMa(String ma) {
        return nv.getByMa(ma);
    }

    @Override
    public NhanVien_Model LoginNhanVien(String ma, String pass) {
        return nv.LoginNhanVien(ma, pass);
    }

    @Override
    public List<NhanVien_View> getNVbyCV(String maCV) {
        List<NhanVien_View> list_view = new ArrayList<>();
        list = nv.getNVbyCV(maCV);
        for (NhanVien_Model n : list) {
            list_view.add(new NhanVien_View(n.getMa(), n.getHoTen(), n.getGioiTinh(), n.getNgaySinh(), n.getSđt(), n.getDiaChi(), n.getPassWord(), n.getChucVu()));
        }
        return list_view;
    }

    @Override
    public int addNV(NhanVien_Model nv) {
        if (nv.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Nhân Viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getHoTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Nhân Viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getSđt().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Số Điện Thoại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }  else if (nv.getSđt().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Đúng Định Dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getPassWord().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống PassWord", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }else if (!nv.getPassWord().matches("\\w{1,}")) {
            JOptionPane.showMessageDialog(null, "PassWord Không Có Ký Tự Đặc Biệt", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getPassWord().length() > 20) {
            JOptionPane.showMessageDialog(null, "PassWord Không Quá 20 ký Tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }  else if (this.nv.getByMa(nv.getMa()) != null) {
            JOptionPane.showMessageDialog(null, "Nhân Viên Đã Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Thêm Thành Công Nhân Viên " + nv.getHoTen());
            return this.nv.addNV(nv);
        }
    }

    @Override
    public int delNV(String manv) {
        NhanVien_Model nv = this.nv.getByMa(manv);
        if (nv == null) {
            JOptionPane.showMessageDialog(null, "Nhân Viên Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Xóa Công Nhân Viên " + nv.getHoTen());
            return this.nv.delNV(manv);
        }
    }

    @Override
    public int updateNV(NhanVien_Model nv) {
        if (nv.getMa().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Mã Nhân Viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getHoTen().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Tên Nhân Viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getSđt().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống Số Điện Thoại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }  else if (nv.getSđt().matches("0\\d{9}")) {
            JOptionPane.showMessageDialog(null, "Số Điện Thoại Không Đúng Định Dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getPassWord().length() == 0) {
            JOptionPane.showMessageDialog(null, "Không Để Trống PassWord", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (!nv.getPassWord().matches("\\w{1,}")) {
            JOptionPane.showMessageDialog(null, "PassWord Không Có Ký Tự Đặc Biệt", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (nv.getPassWord().length() > 20) {
            JOptionPane.showMessageDialog(null, "PassWord Không Quá 20 ký Tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }  else if (this.nv.getByMa(nv.getMa()) == null) {
            JOptionPane.showMessageDialog(null, "Nhân Viên Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            JOptionPane.showMessageDialog(null, "Cập Nhật Công Nhân Viên " + nv.getHoTen());
            return this.nv.updateNV(nv);
        }
    }

    @Override
    public List<NhanVien_View> FindNhanVien(String keyWord) {
        List<NhanVien_View> list_view = new ArrayList<>();
        list = nv.FindNhanVien(keyWord);
        for (NhanVien_Model n : list) {
            list_view.add(new NhanVien_View(n.getMa(), n.getHoTen(), n.getGioiTinh(), n.getNgaySinh(), n.getSđt(), n.getDiaChi(), n.getPassWord(), n.getChucVu()));
        }
        return list_view;
    }

    @Override
    public int UpdatePassword(NhanVien_Model nv) {
        return this.nv.UpdatePassword(nv);
    }

}
