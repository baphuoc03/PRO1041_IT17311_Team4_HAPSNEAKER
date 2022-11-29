/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang_Model;
import model.KhuyenMai_Model;
import ultinities.JDBC_Helper;
import viewmodel.KhuyenMai_View;

/**
 *
 * @author phamtuananh
 */
public class KhuyenMai_repos implements IKhuyenMai_repo {

    @Override
    public List<KhuyenMai_Model> getAllKhuyenMai() {
        List<KhuyenMai_Model> listKm = new ArrayList<>();
        String sql = "select khuyenmai.makm , khuyenmai.ten ,giamgia, NgayBatDau, NgayKetThuc from khuyenmai \n";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                KhuyenMai_Model KM = new KhuyenMai_Model(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5));
                listKm.add(KM);

            }
            return listKm;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(KhuyenMai_Model km) {
        String sql = "Insert into khuyenmai(makm, ten,giamgia, ngaybatdau, ngayketthuc) values (?,?,?,?,?)";
        return JDBC_Helper.Update(sql, km.getMa(), km.getTen(), km.getGiamGia(), km.getNgayBatDau(), km.getNgayKetThuc());
    }

    @Override
    public int delete(KhuyenMai_Model km) {
        String sql = " delete from khuyenmai where makm = ?";
        return JDBC_Helper.Update(sql, km.getMa());
    }

    @Override
    public int update(KhuyenMai_Model km) {
        String sql = "update khuyenmai set  ten = ?, giamgia = ?, ngaybatdau = ? , ngayketthuc = ? where makm =?";
        return JDBC_Helper.Update(sql, km.getTen(), km.getGiamGia(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getMa());
    }

}
