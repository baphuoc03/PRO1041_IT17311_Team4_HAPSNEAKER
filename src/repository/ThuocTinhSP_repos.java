/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ThuocTinhSP_Model;
import ultinities.JDBC_Helper;
import model.SanPham_Model;
import model.KichThuoc_Model;
import model.MauSac_Model;
import model.ThuongHieu_Model;

/**
 *
 * @author 84353
 */
public class ThuocTinhSP_repos implements IThuocTinhSP_Repos {

    public List<ThuocTinhSP_Model> GetAllThuocTinhSP() {
        List<ThuocTinhSP_Model> list = new ArrayList<>();
        String sql = "select s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai,k.MaSize,k.Us,k.ChieuDai,t.Id,t.SoLuong ,\n"
                + " thuonghieu.*,mausac.*\n"
                + "from hap_sneaker.thuoctinhsanpham t\n"
                + "join hap_sneaker.sanpham s on t.MaSP = s.MaSP \n"
                + "join hap_sneaker.kichthuoc k on t.MaSize = k.MaSize\n"
                + "join thuonghieu on s.MaThuongHieu = thuonghieu.mathuonghieu\n"
                + "join mausac on mausac.maMau = s.maMau";
        ResultSet rs = JDBC_Helper.Query(sql);

        try {
            while (rs.next()) {
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(12),rs.getString(13));
                MauSac_Model MS = new MauSac_Model(rs.getString(14),rs.getString(15));
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), th,MS, rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
                KichThuoc_Model kt = new KichThuoc_Model(rs.getFloat(7), rs.getFloat(8), rs.getInt(9));
                list.add(new ThuocTinhSP_Model(rs.getString(10), sp, kt, rs.getInt(11)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Lỗi tại GetAll");
            return null;
        }
    }

    @Override
    public ThuocTinhSP_Model getById(String id) {
     ThuocTinhSP_Model Sp = null;
        String sql = "select s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai,k.MaSize,k.Us,k.ChieuDai,t.Id,t.SoLuong ,\n"
                + " thuonghieu.*,mausac.*\n"
                + "from hap_sneaker.thuoctinhsanpham t\n"
                + "join hap_sneaker.sanpham s on t.MaSP = s.MaSP \n"
                + "join hap_sneaker.kichthuoc k on t.MaSize = k.MaSize\n"
                + "join thuonghieu on s.MaThuongHieu = thuonghieu.mathuonghieu\n"
                + "join mausac on mausac.maMau = s.maMau"
                + " WHERE t.Id = ?";
        ResultSet rs = JDBC_Helper.Query(sql,id);

        try {
            while (rs.next()) {
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(12),rs.getString(13));
                MauSac_Model MS = new MauSac_Model(rs.getString(14),rs.getString(15));
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), th,MS, rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
                KichThuoc_Model kt = new KichThuoc_Model(rs.getFloat(7), rs.getFloat(8), rs.getInt(9));
                Sp = new ThuocTinhSP_Model(rs.getString(10), sp, kt, rs.getInt(11));
            }
            return Sp;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Lỗi tại GetAll");
            return null;
        }
    }

    @Override
    public int undateSL(ThuocTinhSP_Model sp,int SL) {
        String sql = "Update thuoctinhsanpham set SoLuong = ? WHERE Id = ?";
        return JDBC_Helper.Update(sql,sp.getSl()-SL,sp.getId());
    }
    
    
}
