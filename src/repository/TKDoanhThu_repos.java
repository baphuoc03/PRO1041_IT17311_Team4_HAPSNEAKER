/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.TKDoanhThu_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class TKDoanhThu_repos implements ITKDoanhThu_repos {

    @Override
    public List<TKDoanhThu_Model> getTKDoanhThu() {
        List<TKDoanhThu_Model> list = new ArrayList<>();
        String sql = "SELECT  ? AS \"Thang\",SUM(ctdonhang.SL), Sum(ctdonhang.DonGia) FROM hap_sneaker.donhang\n"
                + "join ctdonhang on donhang.MaDonHang = ctdonhang.MaDonHang\n"
                + "WHERE  Month(donhang.NgayTao) = ?";

        for (int i = 1; i <= 12; i++) {
            try {
                ResultSet rs = JDBC_Helper.Query(sql, i, i);
                while (rs.next()) {
                    list.add(new TKDoanhThu_Model(rs.getInt(1), rs.getInt(2), rs.getFloat(3), 0, rs.getFloat(3)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TKDoanhThu_repos.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return list;
    }

}
