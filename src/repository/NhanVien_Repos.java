/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien_Model;
import ultinities.JDBC_Helper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import model.ChucVu_Model;

/**
 *
 * @author admin
 */
public class NhanVien_Repos implements INhanVien_Repo{

    @Override
    public List<NhanVien_Model> getAllNhanVien() {
        List<NhanVien_Model> list = new ArrayList<>();
        String sql = "select MANV,  HOTEN, GIOITINH, NGAYSINH, SĐT, DIACHI, PASSWORD, CHUCVU.MACHUCVU,CHUCVU.Ten \n" +
        "from nhanvien JOIN chucvu ON NHANVIEN.MACHUCVU = CHUCVU.MACHUCVU";
        
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {                
                String ma = rs.getString(1);
                String t = rs.getString(2);
                String gt = rs.getString(3);
                Date ns = rs.getDate(4);
                String sdt = rs.getString(5);
                String dc = rs.getString(6);
                String pw = rs.getString(7);
                ChucVu_Model cv = new ChucVu_Model(rs.getString(8),rs.getString(9));
                
                NhanVien_Model nv = new NhanVien_Model(ma, pw, t, gt, ns, sdt, dc, cv);
                list.add(nv);
            }
            return list;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public NhanVien_Model getByMa(String ma) {
       NhanVien_Model NV = null;
        String sql = "select MANV,  HOTEN, GIOITINH, NGAYSINH, SĐT, DIACHI, PASSWORD, CHUCVU.MACHUCVU,CHUCVU.Ten \n" +
        "from nhanvien JOIN chucvu ON NHANVIEN.MACHUCVU = CHUCVU.MACHUCVU "
                + "WHERE MaNV = ?";
        
        ResultSet rs = JDBC_Helper.Query(sql,ma);
        try {
            while (rs.next()) {                
                String manv = rs.getString(1);
                String t = rs.getString(2);
                String gt = rs.getString(3);
                Date ns = rs.getDate(4);
                String sdt = rs.getString(5);
                String dc = rs.getString(6);
                String pw = rs.getString(7);
                ChucVu_Model cv = new ChucVu_Model(rs.getString(8),rs.getString(9));
                
                NV = new NhanVien_Model(manv, pw, t, gt, ns, sdt, dc, cv);
            }
            return NV;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
