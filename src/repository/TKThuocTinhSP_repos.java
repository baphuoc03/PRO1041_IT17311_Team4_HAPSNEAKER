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
    public List<TKThuocTinhSP_Model> tkByMa() {
        List<TKThuocTinhSP_Model> list = new ArrayList<>();
        String sql = "SELECT thuoctinhsanpham.MaSP, sanpham.Ten,thuoctinhsanpham.MaSize, SUM(ctdonhang.SL),thuoctinhsanpham.SoLuong FROM thuoctinhsanpham\n"
                + "join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "left join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "join kichthuoc on thuoctinhsanpham.MaSize = kichthuoc.MaSize\n"
                + "group by sanpham.MaSP, sanpham.Ten,thuoctinhsanpham.SoLuong,thuoctinhsanpham.MaSize";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                int slban = 0;
                if (String.valueOf(rs.getInt(4)).length() > 0) {
                    slban = rs.getInt(4);
                }
                list.add(new TKThuocTinhSP_Model(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public List<TKThuocTinhSP_Model> tkByMa(String ma) {
        List<TKThuocTinhSP_Model> list = new ArrayList<>();
        String sql = "SELECT thuoctinhsanpham.MaSP, sanpham.Ten,thuoctinhsanpham.MaSize, SUM(ctdonhang.SL),thuoctinhsanpham.SoLuong FROM thuoctinhsanpham\n"
                + "join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "left join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "join kichthuoc on thuoctinhsanpham.MaSize = kichthuoc.MaSize\n"
                + "join donhang on donhang.MaDonHang = ctdonhang.MaDonHang\n"
                + "WHERE thuoctinhsanpham.MaSP = ? and donhang.TrangThai != 2\n"
                + "group by sanpham.MaSP, sanpham.Ten,thuoctinhsanpham.SoLuong,thuoctinhsanpham.MaSize";
        ResultSet rs = JDBC_Helper.Query(sql, ma);
        try {
            while (rs.next()) {
                int slban = 0;
                if (String.valueOf(rs.getInt(4)).length() > 0) {
                    slban = rs.getInt(4);
                }
                list.add(new TKThuocTinhSP_Model(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<TKThuocTinhSP_Model> tkByMaTheoNgay(String ma, String batDau, String ketThuc) {
        List<TKThuocTinhSP_Model> list = new ArrayList<>();
        String sql = "SELECT thuoctinhsanpham.MaSP, sanpham.Ten,thuoctinhsanpham.MaSize, SUM(ctdonhang.SL),thuoctinhsanpham.SoLuong FROM thuoctinhsanpham\n"
                + "                join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "                left join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "                join kichthuoc on thuoctinhsanpham.MaSize = kichthuoc.MaSize\n"
                + "                join donhang on donhang.MaDonHang = ctdonhang.MaDonHang \n"
                + "                WHERE thuoctinhsanpham.MaSP = ? AND DATE(donhang.NgayTao) between ? and ?\n AND donhang.TrangThai != 2"
                + "                 group by sanpham.MaSP, sanpham.Ten,thuoctinhsanpham.SoLuong,thuoctinhsanpham.MaSize    \n"
                + "UNION\n"
                + "SELECT thuoctinhsanpham.MaSP, sanpham.Ten,thuoctinhsanpham.MaSize, 0,thuoctinhsanpham.SoLuong FROM thuoctinhsanpham\n"
                + "                join sanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "                left join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "                join kichthuoc on thuoctinhsanpham.MaSize = kichthuoc.MaSize\n"
                + "                WHERE thuoctinhsanpham.MaSP = ? AND thuoctinhsanpham.MaSP NOT IN (SELECT distinct thuoctinhsanpham.MaSP from thuoctinhsanpham\n"
                + "							join ctdonhang on ctdonhang.IdThuocTinh = thuoctinhsanpham.Id\n"
                + "                             join donhang on donhang.MaDonHang = ctdonhang.MaDonHang\n"
                + "							 WHERE DATE(donhang.NgayTao) between ?  and ? AND donhang.TrangThai != 2) ";
        ResultSet rs = JDBC_Helper.Query(sql, ma, batDau, ketThuc, ma,batDau, ketThuc);
        try {
            while (rs.next()) {
                int slban = 0;
                if (String.valueOf(rs.getInt(4)).length() > 0) {
                    slban = rs.getInt(4);
                }
                list.add(new TKThuocTinhSP_Model(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        ITKThuocTinhSP_repos repo = new TKThuocTinhSP_repos();
        for (TKThuocTinhSP_Model tKThuocTinhSP_Model : repo.tkByMa()) {
            System.out.println(tKThuocTinhSP_Model.toString());
        }
    }
}
