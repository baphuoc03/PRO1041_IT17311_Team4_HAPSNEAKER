/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Date;
import java.util.List;
import model.TKTongQuan_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class TKTongQuan_Repos implements ITKTongQuan_Repos {

    @Override
    public TKTongQuan_Model tkHomNay() {
        TKTongQuan_Model tk = null;
        String sql = "SELECT (SELECT count(donhang.MaDonHang) FROM donhang WHERE DATE(donhang.NgayTao)  = CURDATE() ) AS DONHANG, \n" +
"                sum(ctdonhang.SL), SUM(ctdonhang.DonGia) FROM donhang\n" +
"                left JOIN ctdonhang on donhang.MaDonHang = ctdonhang.MaDonHang\n" +
"                WHERE DATE(donhang.NgayTao)  = CURDATE()";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                tk = new TKTongQuan_Model(rs.getInt(1), rs.getInt(2), rs.getFloat(3));
            }
            return tk;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public TKTongQuan_Model tkTheoNgay(String batDau, String ketThuc) {
        TKTongQuan_Model tk = null;
        String sql = "SELECT (SELECT count(donhang.MaDonHang) FROM donhang WHERE DATE(donhang.NgayTao) BETWEEN ? and ?   )  AS DONHANG, \n"
                + "sum(ctdonhang.SL), SUM(ctdonhang.DonGia) FROM donhang\n"
                + "left JOIN ctdonhang on donhang.MaDonHang = ctdonhang.MaDonHang\n"
                + "WHERE DATE(donhang.NgayTao) BETWEEN ? and ?  ";
        ResultSet rs = JDBC_Helper.Query(sql, batDau, ketThuc, batDau, ketThuc);
        try {
            while (rs.next()) {
                tk = new TKTongQuan_Model(rs.getInt(1), rs.getInt(2), rs.getFloat(3));
            }
            return tk;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        ITKTongQuan_Repos repo = new TKTongQuan_Repos();
        System.out.println(repo.tkHomNay().toString());
    }

}
