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

    public List<ThuocTinhSP_Model> GetAllThuocTinhSP(){
        List<ThuocTinhSP_Model> list = new ArrayList<>();
            String sql = "select s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai,k.MaSize,k.Us,k.ChieuDai,t.Id,t.SoLuong from hap_sneaker.thuoctinhsanpham t \n" +
"join hap_sneaker.sanpham s on t.MaSP = s.MaSP \n" +
"join hap_sneaker.kichthuoc k on t.MaSize = k.MaSize";
            ResultSet rs = JDBC_Helper.Query(sql);
            
            try {
                while(rs.next()){
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
    public List<ThuocTinhSP_Model> GetByMaTT(String maSP){
        List<ThuocTinhSP_Model> list = new ArrayList<>();
            String sql = "select s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai,k.MaSize,k.Us,k.ChieuDai,t.Id,t.SoLuong from hap_sneaker.thuoctinhsanpham t \n" +
"join hap_sneaker.sanpham s on t.MaSP = s.MaSP \n" +
"join hap_sneaker.kichthuoc k on t.MaSize = k.MaSize where s.maSP = ?";
            ResultSet rs = JDBC_Helper.Query(sql,maSP);
            
            try {
                while(rs.next()){
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
    public int add(ThuocTinhSP_Model t){
        String sql = "insert into hap_sneaker.thuoctinhsanpham(MaSP,MaSize,SoLuong) values(?,?,?)";
        return JDBC_Helper.Update(sql, t.getSanPham().getMa(),t.getKichThuoc().getMa(),t.getSl());
    }
    
    @Override
    public int delete(String id){
        String sql = "Delete from hap_sneaker.thuoctinhsanpham where id = ?";
        return JDBC_Helper.Update(sql, id);
    }
    
    @Override
    public int undate(ThuocTinhSP_Model t){
        String sql = "Update hap_sneaker.thuoctinhsanpham Set MaSP = ?,MaSize =?,SoLuong =? where id =?";
        return JDBC_Helper.Update(sql, t.getSanPham().getMa(),t.getKichThuoc().getMa(),t.getSl(),t.getId());
    }
    
    
}
