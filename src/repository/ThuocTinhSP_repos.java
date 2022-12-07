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
                + "join mausac on mausac.maMau = s.maMau "
                + "WHERE s.TrangThai = 1 "
                + "ORDER BY s.MaSP ";
        ResultSet rs = JDBC_Helper.Query(sql);

        try {
            while (rs.next()) {
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(12), rs.getString(13));
                MauSac_Model MS = new MauSac_Model(rs.getString(14), rs.getString(15));
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), th, MS, rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
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
        ResultSet rs = JDBC_Helper.Query(sql, id);

        try {
            while (rs.next()) {
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(12), rs.getString(13));
                MauSac_Model MS = new MauSac_Model(rs.getString(14), rs.getString(15));
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), th, MS, rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
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

    public List<ThuocTinhSP_Model> GetByMaTT(String maSP) {
        List<ThuocTinhSP_Model> list = new ArrayList<>();
        String sql = "select s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai,k.MaSize,k.Us,k.ChieuDai,t.Id,t.SoLuong from hap_sneaker.thuoctinhsanpham t \n"
                + "join hap_sneaker.sanpham s on t.MaSP = s.MaSP \n"
                + "join hap_sneaker.kichthuoc k on t.MaSize = k.MaSize where s.maSP = ?"
                + " ORDER BY k.MaSize";
        ResultSet rs = JDBC_Helper.Query(sql, maSP);

        try {
            while (rs.next()) {
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), null, null, rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
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
    public int undateSL(ThuocTinhSP_Model sp, int SL) {
        String sql = "Update thuoctinhsanpham set SoLuong = ? WHERE Id = ?";
        return JDBC_Helper.Update(sql, sp.getSl() - SL, sp.getId());
    }

    @Override
    public List<ThuocTinhSP_Model> FilterThuocTinhSP(String keyWord, String maSize, String MaTH, String MaMau, String MaPL) {
        List<ThuocTinhSP_Model> list = new ArrayList<>();
        String sql = "   select distinct sanpham.MaSP,sanpham.Ten,sanpham.MoTa,sanpham.GiaNhap,sanpham.GiaBan,sanpham.TrangThai,\n"
                + "    kichthuoc.MaSize,kichthuoc.Us,kichthuoc.ChieuDai,thuoctinhsanpham.Id,thuoctinhsanpham.SoLuong ,\n"
                + "                                   thuonghieu.*,mausac.*\n"
                + "                                  from thuoctinhsanpham \n"
                + "                                  join sanpham  on thuoctinhsanpham.MaSP = sanpham.MaSP \n"
                + "                                  join kichthuoc on thuoctinhsanpham.MaSize = kichthuoc.MaSize\n"
                + "                                  join thuonghieu on sanpham.MaThuongHieu = thuonghieu.mathuonghieu\n"
                + "                                  join mausac on mausac.maMau = sanpham.maMau\n"
                + "                                  join pl_sp on pl_sp.MaSP = sanpham.MaSP \n"
                + "                 WHERE (sanpham.Ten LIKE CONCAT('%',?,'%') OR sanpham.MaSP LIKE CONCAT('%',?,'%'))\n"
                + "                  AND thuoctinhsanpham.MaSize  LIKE CONCAT('%',?,'%')\n"
                + "                  AND thuonghieu.MaThuongHieu LIKE CONCAT('%',?,'%') \n"
                + "                  AND mausac.MaMau LIKE CONCAT('%',?,'%') \n"
                + "                  AND pl_sp.MaPhanLoai LIKE CONCAT('%',?,'%')";
        ResultSet rs = JDBC_Helper.Query(sql, keyWord, keyWord, maSize, MaTH, MaMau, MaPL);

        try {
            while (rs.next()) {
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(12), rs.getString(13));
                MauSac_Model MS = new MauSac_Model(rs.getString(14), rs.getString(15));
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), th, MS, rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
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

    public static void main(String[] args) {
        ThuocTinhSP_repos repo = new ThuocTinhSP_repos();
        for (ThuocTinhSP_Model thuocTinhSP_Model : repo.GetByMaTT("SP1")) {
            System.out.println(thuocTinhSP_Model.toString());
        }
    }

    public int add(ThuocTinhSP_Model t) {
        String sql = "insert into thuoctinhsanpham(MaSP,MaSize,SoLuong) values(?,?,?)";
        return JDBC_Helper.Update(sql, t.getSanPham().getMa(), t.getKichThuoc().getMa(), t.getSl());
    }

    @Override
    public int delete(String id) {
        String sql = "Delete from thuoctinhsanpham where id = ?";
        return JDBC_Helper.Update(sql, id);
    }

    @Override
    public int undate(ThuocTinhSP_Model t) {
        String sql = "Update thuoctinhsanpham Set MaSP = ?,MaSize =?,SoLuong =? where id =?";
        return JDBC_Helper.Update(sql, t.getSanPham().getMa(), t.getKichThuoc().getMa(), t.getSl(), t.getId());
    }

}
