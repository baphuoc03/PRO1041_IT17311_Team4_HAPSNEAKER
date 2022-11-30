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
public class NhanVien_Repos implements INhanVien_Repos{
    
    @Override
    public List<NhanVien_Model> getAllNhanVien() {
        List<NhanVien_Model> list = new ArrayList<>();
        String sql = "select MANV,  HOTEN, GIOITINH, NGAYSINH, SĐT, GIACHI, PASSWORD, CHUCVU.MACHUCVU,CHUCVU.Ten \n" +
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
        String sql = "select MANV,  HOTEN, GIOITINH, NGAYSINH, SĐT, GIACHI, PASSWORD, CHUCVU.MACHUCVU, CHUCVU.Ten \n" +
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
                String macv = rs.getString(8);
                String tencv = rs.getString(9);
                ChucVu_Model cv = new ChucVu_Model(macv, tencv);
                NV = new NhanVien_Model(manv, pw, t, gt, ns, sdt, dc, cv);
            }
            return NV;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int addNV(NhanVien_Model nv) {
         String sql = "INSERT INTO NHANVIEN(MANV, HOTEN, GIOITINH, NGAYSINH, SĐT, GIACHI, PASSWORD, MACHUCVU) VALUES (?,?,?,?,?,?,?,?)";
        return JDBC_Helper.Update(sql, nv.getMa(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSđt(), nv.getDiaChi(), nv.getPassWord(), nv.getChucVu().getMa());
    }

    @Override
    public int delNV(String manv) {
        String sql = "DELETE FROM NHANVIEN WHERE MANV = ?";
        return JDBC_Helper.Update(sql, manv);
    }

    @Override
    public int updateNV(NhanVien_Model nv) {
        String sql = "UPDATE NHANVIEN SET MANV = ?, HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, SÐT = ?, GIACHI = ?, PASSWORD = ?, MACHUCVU = ? WHERE SĐT = ?";
        return JDBC_Helper.Update(sql, nv.getMa(), nv.getHoTen(), nv.getGioiTinh(), nv.getNgaySinh(), nv.getSđt(), nv.getDiaChi(), nv.getPassWord(), nv.getChucVu().getMa(), nv.getSđt());
    }

    @Override
    public List<NhanVien_Model> getNVbyCV(String maCV) {
         List<NhanVien_Model> listNV = new ArrayList<>();
        ResultSet rs;
        String sql= "SELECT MANV, HOTEN, GIOITINH, NGAYSINH, SĐT, GIACHI, PASSWORD, CHUCVU.MACHUCVU,CHUCVU.Ten \n"
            +"from nhanvien JOIN chucvu ON NHANVIEN.MACHUCVU = CHUCVU.MACHUCVU WHERE MaChucVu = ? ";
        
        rs = JDBC_Helper.Query(sql, maCV);
        try {
            while(rs.next()){
                String manv = rs.getString(1);
                String pw = rs.getString(7);
                String t = rs.getString(2);
                String gt = rs.getString(3);
                Date ns = rs.getDate(4);
                String sdt = rs.getString(5);
                String dc = rs.getString(6);
                String macv = rs.getString(7);
                String tencv = rs.getString(8);
                ChucVu_Model cv = new ChucVu_Model(macv, tencv);
                NhanVien_Model nv = new NhanVien_Model(macv, pw, tencv, gt, ns, sdt, macv, cv);
                listNV.add(nv);
            }
            return listNV;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhanVien_Model> FindNhanVien(String keyWord){
         List<NhanVien_Model> list = new ArrayList<>();
        String sql = "select MANV,  HOTEN, GIOITINH, NGAYSINH, SĐT, GIACHI, PASSWORD, CHUCVU.MACHUCVU,CHUCVU.Ten \n"
                + "from nhanvien JOIN chucvu ON NHANVIEN.MACHUCVU = CHUCVU.MACHUCVU \n"
                + "WHERE SĐT LIKE CONCAT('%',?,'%')\n"
                + "OR HOTEN LIKE CONCAT('%',?,'%')";
        
        ResultSet rs = JDBC_Helper.Query(sql, keyWord, keyWord);
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
    
}
