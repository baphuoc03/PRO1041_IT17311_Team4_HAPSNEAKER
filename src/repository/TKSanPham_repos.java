/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.TKSanPham_Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class TKSanPham_repos implements ITKSanPham_repos {

    @Override
    public List<TKSanPham_Model> getTKSanPham() {
        List<TKSanPham_Model> list = new ArrayList<>();
        String sql = "SELECT thuoctinhsanpham.MaSP, sanpham.Ten,mausac.Ten,thuonghieu.Ten, SUM(ctdonhang.SL) FROM thuoctinhsanpham\n"
                + "join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "join mausac on mausac.MaMau = SanPham.MaMau\n"
                + "join thuonghieu on thuonghieu.MaThuongHieu = sanpham.MaThuongHieu\n"
                + "join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "group by sanpham.MaSP, sanpham.Ten,mausac.Ten,thuonghieu.Ten";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                list.add(new TKSanPham_Model(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
