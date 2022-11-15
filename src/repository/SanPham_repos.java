/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SanPham_Model;
import ultinities.JDBC_Helper;
import model.ThuongHieu_Model;
import model.MauSac_Model;

/**
 *
 * @author 84353
 */
public class SanPham_repos implements ISanPham_repos{
    
    public List<SanPham_Model> GetAllSanPham(){
        List<SanPham_Model> list = new ArrayList<>();
        String sql = "select t.MaThuongHieu,t.Ten,m.MaMau,m.Ten,s.MaSP,s.Ten,s.MoTa,s.GiaNhap,s.GiaBan,s.TrangThai from hap_sneaker.sanpham s \n" +
        "join hap_sneaker.thuonghieu t on s.MaThuongHieu = t.MaThuongHieu\n" +
        "join hap_sneaker.mausac m on s.MaMau = m.MaMau";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while(rs.next()){
                ThuongHieu_Model th = new ThuongHieu_Model(rs.getString(1), rs.getString(2));
                MauSac_Model ms = new MauSac_Model(rs.getString(3), rs.getString(4));
                list.add(new SanPham_Model(rs.getString(5), rs.getString(6), th, ms, rs.getString(7), rs.getFloat(8), rs.getFloat(9), rs.getInt(10)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
