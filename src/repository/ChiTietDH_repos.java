/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.ChiTietDH_model;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
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
                + " ctdonhang.SL, ctdonhang.DonGia,ctdonhang.DonGiaSauGiam,\n"
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
                SanPham_Model SP = new SanPham_Model(rs.getString(5), rs.getString(6), null, null, rs.getString(7), rs.getFloat(8), rs.getFloat(9), rs.getInt(10));
                KichThuoc_Model kt = new KichThuoc_Model(rs.getFloat(13), rs.getFloat(14), rs.getInt(15));
                ThuocTinhSP_Model ttSP = new ThuocTinhSP_Model(rs.getString(11), SP, kt, rs.getInt(12));
                list.add(new ChiTietDH_model(DH, ttSP, rs.getInt(2), rs.getFloat(3),rs.getFloat(4)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(ChiTietDH_model dh) {
        String sql = "INSERT INTO ctdonhang(MaDonHang,IdThuocTinh,SL,DonGia,DonGiaSauGiam) VALUES (?,?,?,?,?)";
        return JDBC_Helper.Update(sql, dh.getDonHang().getMa(),dh.getThuocTinh().getId(),dh.getSl(),dh.getDonGia(),dh.getDonGiaSauGiam());
    }

    @Override
    public int updateSL(ChiTietDH_model dh) {
//        float dongia = dh.getThuocTinh().getSanPham().getGiaBan() * dh.getSl();
        String sql = "UPDATE ctdonhang set SL = ?, DonGia = ?,DonGiaSauGiam = ? WHERE MaDonHang = ? AND IdThuocTinh = ?";
        return JDBC_Helper.Update(sql, dh.getSl(),dh.getDonGia(),dh.getDonGiaSauGiam(),dh.getDonHang().getMa(),dh.getThuocTinh().getId());
    }

    @Override
    public int delete(ChiTietDH_model dh) {
        String sql = "DELETE from ctdonhang WHERE MaDonHang = ? AND IdThuocTinh = ? ";
        return JDBC_Helper.Update(sql,dh.getDonHang().getMa(),dh.getThuocTinh().getId());
    }
    public static void main(String[] args) {
        IChiTietDH_repos repo = new ChiTietDH_repos();
        for (ChiTietDH_model chiTietDH_model : repo.getChiTietDHByMaDH("DH27")) {
            System.out.println(chiTietDH_model.toString());
        }
    }
}
