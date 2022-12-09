/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang_Model;
import ultinities.JDBC_Helper;

/**
 *
 * @author admin
 */
public class Khachhang_Repos implements IKhachHang_repos{

    @Override
    public List<KhachHang_Model> getAllKhachHang() {
        List<KhachHang_Model> list = new ArrayList<>();
        String sql = "SELECT HOTEN, SĐT, GIOITINH, NGAYSINH,EMAIL, DIACHI FROM KHACHHANG\n";        
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while(rs.next()){
                KhachHang_Model kh = new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5), rs.getString(6));
                list.add(kh);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public KhachHang_Model getBySĐT(String SĐT) {
        KhachHang_Model kh = null;
        String sql = "SELECT HOTEN, SĐT, GIOITINH, NGAYSINH,EMAIL, DIACHI FROM KHACHHANG\n" +
        "WHERE SĐT = ?";
        
        ResultSet rs = JDBC_Helper.Query(sql,SĐT);
        try {
            while(rs.next()){
                kh =  new KhachHang_Model(rs.getString(2), rs.getString(1), rs.getString(3), rs.getDate(4),rs.getString(5), rs.getString(6));
            }
            return kh;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        IKhachHang_repos kh = new Khachhang_Repos();
        System.out.println(kh.getBySĐT("0938475839").toString());
    }
    @Override
    public int addKH(KhachHang_Model kh) {
        String sql = "INSERT INTO KHACHHANG(HOTEN, SĐT, GIOITINH, NGAYSINH,EMAIL, DIACHI) VALUES (?,?,?,?,?,?)";
        return JDBC_Helper.Update(sql, kh.getHoTen(), kh.getSđt(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getEmail(), kh.getDiaChi());
    }

    @Override
    public int delKH(String sdt) {
         String sql = "DELETE FROM KHACHHANG WHERE SĐT = ?;";
        return JDBC_Helper.Update(sql, sdt);
    }

    @Override
    public int updateKH(KhachHang_Model kh) {
        String sql = "UPDATE KHACHHANG SET HOTEN = ?, SĐT = ?, GIOITINH = ?, NGAYSINH = ?, EMAIL = ?, DIACHI = ? WHERE SĐT = ?";
        return JDBC_Helper.Update(sql, kh.getHoTen(), kh.getSđt(), kh.getGioiTinh(), kh.getNgaySinh(), kh.getEmail(), kh.getDiaChi(), kh.getSđt());
    }
    @Override
    public List<KhachHang_Model> FindKhachHang(String keyWord) {
        List<KhachHang_Model> list = new ArrayList<>();
        String sql = "SELECT HOTEN, SĐT, GIOITINH, NGAYSINH,EMAIL, DIACHI FROM KHACHHANG\n"
                + "WHERE SĐT like concat('%',?,'%')\n"
                + " or HOTen like concat('%',?,'%')\n";        
        ResultSet rs = JDBC_Helper.Query(sql,keyWord,keyWord);
        try {
            while(rs.next()){
                list.add(new KhachHang_Model(rs.getString(1), rs.getString(2),rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
