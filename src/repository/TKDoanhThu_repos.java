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
    public List<TKDoanhThu_Model> getTKDoanhThu(int nam) {
        List<TKDoanhThu_Model> list = new ArrayList<>();
        String sql = "SELECT  ? AS \"Tháng\", SUM(ctdonhang.SL), Sum(ctdonhang.DonGia),Sum(ctdonhang.DonGia) - Sum(ctdonhang.DonGiaSauGiam) AS GiamGia,\n"
                + "ctdonhang.DonGiaSauGiam  AS GiaSauGiam\n"
                + "  FROM sanpham  \n"
                + "   join thuoctinhsanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "   join ctdonhang on thuoctinhsanpham.id = ctdonhang.idThuocTinh\n"
                + "   join donhang on ctdonhang.MaDonHang = donhang.MaDonHang  \n"
                + "   join kichthuoc on kichthuoc.MaSize = thuoctinhsanpham.MaSize \n"
                + "   WHERE  Month(donhang.NgayTao) = ? AND YEAR(donhang.NgayTao) = ?\n and donhang.TrangThai != 2\n"
                + "GROUP BY GiaSauGiam,ctdonhang.SL";

        for (int i = 1; i <= 12; i++) {
            try {
                ResultSet rs = JDBC_Helper.Query(sql, i, i,nam);
                int thang = 0;
                float SL = 0, doanhThu = 0, giamGia = 0, giaSauGiam = 0;
                while (rs.next()) {
                    thang = rs.getInt(1);
                    SL += rs.getInt(2);
                    doanhThu += rs.getFloat(3);
                    giamGia += rs.getFloat(4);
                    giaSauGiam += rs.getFloat(5);
                }
                list.add(new TKDoanhThu_Model(thang, (int) SL, doanhThu, giamGia, giaSauGiam));
            } catch (SQLException ex) {
                Logger.getLogger(TKDoanhThu_repos.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return list;
    }

}
