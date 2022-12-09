/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.KmSp_Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhuyenMai_Model;
import model.SanPham_Model;
import ultinities.JDBC_Helper;
import java.util.Date;

/**
 *
 * @author phamtuananh
 */
public class KhuyenmaiSP_repos implements IKhuyenmaiSP_repos {

    @Override
    public List<KmSp_Model> getSanPhamByKM(String maKM) {
        List<KmSp_Model> list = new ArrayList<>();
        String sql = "SELECT * FROM hap_sneaker.km_sp WHERE MaKM = ?";
        ResultSet rs = JDBC_Helper.Query(sql, maKM);
        try {
            while (rs.next()) {
                SanPham_Model sp = new SanPham_Model(rs.getString(1), null, null, null, null, 0, 0, 0,null);
                list.add(new KmSp_Model(new KhuyenMai_Model(rs.getString(2), sql, 0, null, null), sp));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(KmSp_Model kmsp) {
        String sql = "INSERT INTO km_sp(MaKM,MaSP) VALUES (?,?)";
        return JDBC_Helper.Update(sql, kmsp.getKhuyenMai().getMa(), kmsp.getSanPham().getMa());
    }

    @Override
    public int deleteByMaKM(String MaKM) {
        String sql = "DELETE FROM km_sp WHERE MaKM = ?";
        return JDBC_Helper.Update(sql, MaKM);
    }

    @Override
    public List<KmSp_Model> getSanPhamByGetDate(Date getDate) {
        List<KmSp_Model> list = new ArrayList<>();
        String sql = "SELECT MaSP,km_sp.MaKM,GiamGia FROM km_sp\n"
                + "Join khuyenmai on km_sp.MaKM = khuyenmai.MaKM\n"
                + "WHERE ?  between khuyenmai.NgayBatDau AND khuyenmai.NgayKetThuc";
        ResultSet rs = JDBC_Helper.Query(sql, getDate);
        try {
            while (rs.next()) {
                SanPham_Model sp = new SanPham_Model(rs.getString(1), null, null, null, null, 0, 0, 0,null);
                list.add(new KmSp_Model(new KhuyenMai_Model(rs.getString(2), sql, rs.getInt(3), null, null), sp));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
