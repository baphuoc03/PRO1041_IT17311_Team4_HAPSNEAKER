/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.ChiTietDH_model;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DonHang_Model;
import model.KichThuoc_Model;
import model.SanPham_Model;
import model.ThuocTinhSP_Model;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class ChiTietDH_repos implements IChiTietDH_repos {

    @Override
    public List<ChiTietDH_model> getChiTietDHByMaDH(String maHD) {
        List<ChiTietDH_model> list = new ArrayList<>();
        String sql = "SELECT donhang.MaDonHang,\n"
                + " ctdonhang.SL, ctdonhang.DonGia,\n"
                + "sanpham.MaSP, sanpham.Ten,sanpham.MoTa, sanpham.GiaNhap, sanpham.GiaBan, sanpham.TrangThai,\n"
                + " thuoctinhsanpham.id, thuoctinhsanpham.SoLuong, kichthuoc.MaSize, kichthuoc.Us, kichthuoc.ChieuDai\n"
                + "FROM ctdonhang\n"
                + "join donhang on ctdonhang.MaDonHang = donhang.MaDonHang\n"
                + "join thuoctinhsanpham on thuoctinhsanpham.id = ctdonhang.idThuocTinh\n"
                + "join sanpham on sanpham.MaSP = thuoctinhsanpham.MaSP\n"
                + "join kichthuoc on kichthuoc.MaSize = thuoctinhsanpham.MaSize\n"
                + "WHERE donhang.MaDonHang = ?";
        ResultSet rs = JDBC_Helper.Query(sql,maHD);
        try {
            while (rs.next()) {
                DonHang_Model DH = new DonHang_Model(rs.getString(1), null, null, null, 0);
                SanPham_Model SP = new SanPham_Model(rs.getString(4), rs.getString(5), null, null, rs.getString(6), rs.getFloat(7), rs.getFloat(8), rs.getInt(9));
                KichThuoc_Model kt = new KichThuoc_Model(rs.getFloat(12), rs.getFloat(13), rs.getInt(14));
                ThuocTinhSP_Model ttSP = new ThuocTinhSP_Model(rs.getString(10), SP, kt, rs.getInt(11));
                list.add(new ChiTietDH_model(DH, ttSP, rs.getInt(2), rs.getFloat(3)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        IChiTietDH_repos DH = new ChiTietDH_repos();
        for (ChiTietDH_model chiTietDH_model : DH.getChiTietDHByMaDH("DH1")) {
            System.out.println(chiTietDH_model.toString());
        }
    }

    @Override
    public int add(ChiTietDH_model dh) {
        String sql = "INSERT INTO ctdonhang(MaDonHang,IdThuocTinh,SL,DonGia) VALUES (?,?,?,?)";
        return JDBC_Helper.Update(sql, dh.getDonHang().getMa(),dh.getThuocTinh().getId(),dh.getSl(),dh.getDonGia());
    }

    @Override
    public int updateSL(ChiTietDH_model dh) {
        float dongia = dh.getThuocTinh().getSanPham().getGiaBan() * dh.getSl();
        String sql = "UPDATE ctdonhang set SL = ?, DonGia = ? WHERE MaDonHang = ? AND IdThuocTinh = ?";
        return JDBC_Helper.Update(sql, dh.getSl(),dongia,dh.getDonHang().getMa(),dh.getThuocTinh().getId());
    }

    @Override
    public int delete(ChiTietDH_model dh) {
        String sql = "DELETE from ctdonhang WHERE MaDonHang = ? AND IdThuocTinh = ? ";
        return JDBC_Helper.Update(sql,dh.getDonHang().getMa(),dh.getThuocTinh().getId());
    }
}
