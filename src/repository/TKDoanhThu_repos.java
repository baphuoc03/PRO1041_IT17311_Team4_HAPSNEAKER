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
public class TKDoanhThu_repos implements ITKDoanhThu_repo {

    @Override
    public List<TKDoanhThu_Model> getTKDoanhThu() {
        List<TKDoanhThu_Model> list = new ArrayList<>();
        String sql = "SELECT  ? AS \"Tháng\", SUM(ctdonhang.SL), Sum(ctdonhang.DonGia),SUM(ctdonhang.DonGia * (khuyenmai.GiamGia/100)) AS GiamGia,\n"
                + "Sum(ctdonhang.DonGia) - SUM(ctdonhang.DonGia * (khuyenmai.GiamGia/100)) AS GiaSauGiam\n"
                + "  FROM sanpham  \n"
                + "   join thuoctinhsanpham on thuoctinhsanpham.MaSP = sanpham.MaSP\n"
                + "   join ctdonhang on thuoctinhsanpham.id = ctdonhang.idThuocTinh\n"
                + "   join donhang on ctdonhang.MaDonHang = donhang.MaDonHang  \n"
                + "   join kichthuoc on kichthuoc.MaSize = thuoctinhsanpham.MaSize \n"
                + "   left join km_sp  on sanpham.MaSP = km_sp.MaSP\n"
                + "	join khuyenmai on khuyenmai.MaKM = km_sp.MaKM\n"
                + "   WHERE  Month(donhang.NgayTao) = ? AND donhang.NgayTao between NgayBatDau and NgayKetThuc \n"
                + "Union\n"
                + "SELECT ? AS \"Tháng\", SUM(ctdonhang.SL) , Sum(ctdonhang.DonGia) ,Sum(ctdonhang.DonGia*(0/100)),Sum(ctdonhang.DonGia)\n"
                + "	FROM sanpham  \n"
                + "	join thuoctinhsanpham on thuoctinhsanpham.MaSP = sanpham.MaSP \n"
                + "    join ctdonhang on thuoctinhsanpham.id = ctdonhang.idThuocTinh\n"
                + "    join donhang on ctdonhang.MaDonHang = donhang.MaDonHang\n"
                + "	join kichthuoc on kichthuoc.MaSize = thuoctinhsanpham.MaSize \n"
                + "	WHERE  Month(donhang.NgayTao) = ? AND sanpham.MaSP NOT IN (SELECT sanpham.MaSP\n"
                + "                   FROM ctdonhang  \n"
                + "                   join donhang on ctdonhang.MaDonHang = donhang.MaDonHang  \n"
                + "                   join thuoctinhsanpham on thuoctinhsanpham.id = ctdonhang.idThuocTinh  \n"
                + "                   left join sanpham on sanpham.MaSP = thuoctinhsanpham.MaSP  \n"
                + "                   left join km_sp  on sanpham.MaSP = km_sp.MaSP\n"
                + "					join khuyenmai on khuyenmai.MaKM = km_sp.MaKM\n"
                + "                   WHERE  Month(donhang.NgayTao) = ? AND donhang.NgayTao between NgayBatDau and NgayKetThuc) ";

        for (int i = 1; i <= 12; i++) {
            try {
                ResultSet rs = JDBC_Helper.Query(sql, i, i, i, i, i);
                int thang = 0;
                float SL = 0, doanhThu = 0, giamGia = 0, giaSauGiam = 0;
                while (rs.next()) {
                    thang = rs.getInt(1);
                    SL += rs.getInt(2);
                    doanhThu += rs.getFloat(3);
                    giamGia +=rs.getFloat(4);
                    giaSauGiam += rs.getFloat(5);
                }
                list.add(new TKDoanhThu_Model(thang, (int) SL,doanhThu, giamGia, giaSauGiam));
            } catch (SQLException ex) {
                Logger.getLogger(TKDoanhThu_repos.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return list;
    }

}
