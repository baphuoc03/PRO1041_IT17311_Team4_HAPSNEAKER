/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.DonHang_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang_Model;
import model.NhanVien_Model;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class DonHang_Repos implements IDonHang_Repos {

    @Override
    public List<DonHang_Model> getAllDonHang() {
        List<DonHang_Model> list = new ArrayList<>();
        String sql = "SELECT NhanVien.MaNV, NhanVien.PassWord, NhanVien.HoTen, NhanVien.GioiTinh, NhanVien.NgaySinh, NhanVien.SĐT, NhanVien.GiaChi,\n"
                + "KhachHang.SĐT, KhachHang.HoTen, KhachHang.GioiTinh, KhachHang.NgaySInh, KhachHang.Email, KhachHang.DiaChi,\n"
                + "donhang.MaDonHang, donhang.NgayTao, donhang.TrangThai \n"
                + " FROM donhang\n"
                + " Join NhanVien on NhanVien.MaNV = donhang.MaNhanVien\n"
                + " Join KhachHang on KhachHang.SĐT = donhang.SĐT"
                + " ORDER BY donhang.MaDonHang DESC";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), null);
                KhachHang_Model kh = new KhachHang_Model(rs.getString(8),rs.getString(9),rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13));
                list.add(new DonHang_Model(rs.getString(14), nv, kh,rs.getDate(15), rs.getInt(16)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DonHang_Model> FindDonHang(String keyWord) {
        List<DonHang_Model> list = new ArrayList<>();
        String sql = "SELECT NhanVien.MaNV, NhanVien.PassWord, NhanVien.HoTen, NhanVien.GioiTinh, NhanVien.NgaySinh, NhanVien.SĐT, NhanVien.DiaChi,\n" +
"                KhachHang.SĐT, KhachHang.HoTen, KhachHang.GioiTinh, KhachHang.NgaySInh, KhachHang.Email, KhachHang.DiaChi,\n" +
"                donhang.MaDonHang, donhang.NgayTao, donhang.TrangThai\n" +
"                 FROM donhang\n" +
"                 Join NhanVien on NhanVien.MaNV = donhang.MaNhanVien\n" +
"                 Join KhachHang on KhachHang.SĐT = donhang.SĐT\n" +
"                WHERE KhachHang.SĐT LIKE CONCAT('%',?,'%') \n" +
"                OR KhachHang.HoTen LIKE CONCAT('%',?,'%')";
        ResultSet rs = JDBC_Helper.Query(sql,keyWord,keyWord);
        try {
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), null);
                KhachHang_Model kh = new KhachHang_Model(rs.getString(8),rs.getString(9),rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13));
                list.add(new DonHang_Model(rs.getString(14), nv, kh,rs.getDate(15), rs.getInt(16)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(DonHang_Model dh) {
        String sql = "INSERT INTO donhang(MaDonHang,MaNhanVien,SĐT,NgayTao,TrangThai) VALUES (?,?,?,?,?)";
        return JDBC_Helper.Update(sql,dh.getMa(),dh.getNhanVien().getMa(),dh.getKhachHang().getSđt(),dh.getNgayTao(),dh.getTrangThai());
    }

    @Override
    public int update(DonHang_Model dh) {
       String sql = "UPDATE donhang SET TrangThai = ? WHERE MaDonHang = ?";
        return JDBC_Helper.Update(sql,dh.getTrangThai(),dh.getMa()); 
    }

    @Override
    public DonHang_Model getDHByMa(String ma) {
        DonHang_Model DH = null;
        String sql = "SELECT NhanVien.MaNV, NhanVien.PassWord, NhanVien.HoTen, NhanVien.GioiTinh, NhanVien.NgaySinh, NhanVien.SĐT, NhanVien.DiaChi,\n"
                + "KhachHang.SĐT, KhachHang.HoTen, KhachHang.GioiTinh, KhachHang.NgaySInh, KhachHang.Email, KhachHang.DiaChi,\n"
                + "donhang.MaDonHang, donhang.NgayTao, donhang.TrangThai \n"
                + " FROM donhang\n"
                + " Join NhanVien on NhanVien.MaNV = donhang.MaNhanVien\n"
                + " Join KhachHang on KhachHang.SĐT = donhang.SĐT"
                + " WHERE donhang.MaDonHang = ?";
        ResultSet rs = JDBC_Helper.Query(sql,ma);
        try {
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6), rs.getString(7), null);
                KhachHang_Model kh = new KhachHang_Model(rs.getString(8),rs.getString(9),rs.getString(10), rs.getDate(11), rs.getString(12), rs.getString(13));
                DH = new DonHang_Model(rs.getString(14), nv, kh,rs.getDate(15), rs.getInt(16));
            }
            return DH;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
