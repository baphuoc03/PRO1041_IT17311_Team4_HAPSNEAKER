/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai_Model;
import model.KmSp_MoDel;
import model.SanPham_Model;
import ultinities.JDBC_Helper;
import model.ThuongHieu_Model;
import model.MauSac_Model;

/**
 *
 * @author 84353
 */
public class SanPham_repos implements ISanPham_repos {

    public List<SanPham_Model> GetAllSanPham() {
        List<SanPham_Model> list = new ArrayList<>();
        String sql = "select t.MaThuongHieu,t.Ten,m.MaMau,m.Ten,s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai from sanpham s \n"
                + "        join thuonghieu t on s.MaThuongHieu = t.MaThuongHieu\n"
                + "        join mausac m on s.MaMau = m.MaMau"
                + " ORDER BY s.MaSP ";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(1), rs.getString(2));
                MauSac_Model ms = new MauSac_Model(rs.getString(3), rs.getString(4));
                list.add(new SanPham_Model(rs.getString(5), rs.getString(6), th, ms, rs.getString(7), rs.getFloat(8), rs.getFloat(9), rs.getInt(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
                    return null;

        }
    }

    public List<SanPham_Model> GetSanPhamByMaKM(String maKM) {
        List<SanPham_Model> list = new ArrayList<>();
        String sql = "SELECT sanpham.masp FROM sanpham\n"
                + "join km_sp on sanpham.MaSP = km_sp.MaSP\n"
                + "join khuyenmai on khuyenmai.MaKM = km_sp.MaKM \n"
                + "join thuonghieu on thuonghieu.mathuonghieu = sanpham.mathuonghieu\n"
                + "join mausac on mausac.mamau = sanpham.mamau\n"
                + "WHERE khuyenmai.MaKM = ?";
        ResultSet rs = JDBC_Helper.Query(sql, maKM);
        try {
            while (rs.next()) {
                list.add(new SanPham_Model(rs.getString(1), null, null, null, null, 0, 0, 0));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SanPham_Model GetSanPhamByMa(String ma) {
        SanPham_Model SP = null;
        String sql = "select t.MaThuongHieu,t.Ten,m.MaMau,m.Ten,s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai from sanpham s \n"
                + "        join thuonghieu t on s.MaThuongHieu = t.MaThuongHieu\n"
                + "        join mausac m on s.MaMau = m.MaMau"
                + " WHERE s.MaSP = ? ";
        ResultSet rs = JDBC_Helper.Query(sql, ma);
        try {
            while (rs.next()) {
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(1), rs.getString(2));
                MauSac_Model ms = new MauSac_Model(rs.getString(3), rs.getString(4));
                SP = new SanPham_Model(rs.getString(5), rs.getString(6), th, ms, rs.getString(7), rs.getFloat(8), rs.getFloat(9), rs.getInt(10));
            }
            return SP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(SanPham_Model s) {
        String sql = "insert into Sneaker_hap.sanpham(MaSP,Ten,MaThuongHieu,MaMau,MoTa,GiaNhap,GiaBan,TrangThai) values (?,?,?,?,?,?,?,?)";
        return JDBC_Helper.Update(sql, s.getMa(), s.getTen(), s.getThuongHieu().getMa(), s.getMauSac().getMa(), s.getMoTa(), s.getGiaNhap(), s.getGiaBan(), s.getTrangThai());
    }

    @Override
    public int delete(String s) {
        String sql = "delete from sanpham where MaSP = ?";
        return JDBC_Helper.Update(sql, s);
    }

    @Override
    public int update(SanPham_Model s) {
        String sql = "update sanpham SET MaSP = ?,Ten = ?,MaThuongHieu =?, MaMau = ?,MoTa = ?,GiaNhap = ?, GiaBan = ?, TrangThai = ? where MaSP =?";
        return JDBC_Helper.Update(sql, s.getMa(), s.getTen(), s.getThuongHieu().getMa(), s.getMauSac().getMa(), s.getMoTa(), s.getGiaNhap(), s.getGiaBan(), s.getTrangThai(), s.getMa());
    }
}
