/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.PhanLoai_Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class PhanLoai_repos implements IPhanLoai_repos {

    @Override
    public List<PhanLoai_Model> getAllThuongHieu() {
        List<PhanLoai_Model> list = new ArrayList<>();
        String sql = "SELECT * FROM phanloai;";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                list.add(new PhanLoai_Model(rs.getString(1),rs.getString(2)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public PhanLoai_Model getByMa(String ma) {
    PhanLoai_Model PL = null;
        String sql = "SELECT * FROM Sneaker_hap.phanloai WHERE MaPhanLoai = ?";
        ResultSet rs = JDBC_Helper.Query(sql,ma);
        try {
            while (rs.next()) {
                PL = new PhanLoai_Model(rs.getString(1),rs.getString(2));
            }
            return PL;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
