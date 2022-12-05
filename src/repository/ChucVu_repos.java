/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChucVu_Model;
import ultinities.JDBC_Helper;

/**
 *
 * @author Ky Anh
 */
public class ChucVu_repos implements IChucVu_repos{

    @Override
    public List<ChucVu_Model> getAllChucVu() {
        List<ChucVu_Model> list = new ArrayList<>();
        String sql = "SELECT * FROM hap_sneaker.chucvu;";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                list.add(new ChucVu_Model(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ChucVu_Model getByMa(String ma) {
        ChucVu_Model CV = null;
        String sql = "SELECT * FROM hap_sneaker.ChucVu WHERE MaChucVu = ?";
        ResultSet rs = JDBC_Helper.Query(sql, ma);
        try {
            while (rs.next()) {
                CV = new ChucVu_Model(rs.getString(1), rs.getString(2));
            }
            return CV;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        IChucVu_repos cv = new ChucVu_repos();
        System.out.println(cv.getByMa("CV01").toString());
    }
}
