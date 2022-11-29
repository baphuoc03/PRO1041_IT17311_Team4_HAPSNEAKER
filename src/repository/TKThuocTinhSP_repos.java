/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.TKThuocTinhSP_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class TKThuocTinhSP_repos implements ITKThuocTinhSP_repos {

    @Override
    public List<TKThuocTinhSP_Model> tkByMa(String ma) {
        List<TKThuocTinhSP_Model> list = new ArrayList<>();
        String sql = "SELECT thuoctinhsanpham.MaSP, sanpham.Ten,thuoctinhsanpham.MaSize, SUM(ctdonhang.SL),thuoctinhsanpham.SoLuong FROM thuoctinhsanpham\n"
                + "join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "join kichthuoc on thuoctinhsanpham.MaSize = kichthuoc.MaSize\n"
                + "WHERE thuoctinhsanpham.MaSP = ?\n"
                + "group by sanpham.MaSP, sanpham.Ten,thuoctinhsanpham.SoLuong,thuoctinhsanpham.MaSize";
        ResultSet rs = JDBC_Helper.Query(sql, ma);
        try {
            while (rs.next()) {
                list.add(new TKThuocTinhSP_Model(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
