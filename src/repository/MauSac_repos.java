/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.MauSac_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultinities.JDBC_Helper;

/**
 *
 * @author baphuoc
 */
public class MauSac_repos implements IMauSac_repos {

    @Override
    public List<MauSac_Model> getAllMauSac() {
        List<MauSac_Model> list = new ArrayList<>();
        String sql = "SELECT * FROM hap_sneaker.mausac;";
        ResultSet rs = JDBC_Helper.Query(sql);
        try {
            while (rs.next()) {
                list.add(new MauSac_Model(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public MauSac_Model getByMa(String ma) {
       MauSac_Model MS = null;
        String sql = "SELECT * FROM hap_sneaker.mausac WHERE MaMau = ?";
        ResultSet rs = JDBC_Helper.Query(sql,ma);
        try {
            while (rs.next()) {
                MS = new MauSac_Model(rs.getString(1), rs.getString(2));
            }
            return MS;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public int add(MauSac_Model m){
        String sql = "insert into hap_sneaker.mausac(MaMau,Ten) Values(?,?)";
        return JDBC_Helper.Update(sql, m.getMa(),m.getTen());
    }
    
    @Override
    public int delete(String ma){
        String sql = "delete from hap_sneaker.mausac where MaMau = ?";
        return JDBC_Helper.Update(sql, ma);
    }
    
    @Override
    public int update(MauSac_Model m){
        String sql = "Update hap_sneaker.mausac Set MaMau = ?, Ten = ? where MaMau = ?";
        return JDBC_Helper.Update(sql, m.getMa(),m.getTen(),m.getMa());
    }
    
    public List<MauSac_Model> Search(String key){
        List<MauSac_Model> lst = new ArrayList<>();
        String sql = "SELECT * FROM hap_sneaker.mausac WHERE MaMau like concat('%',?,'%')\n" +
"or Ten like concat('%',?,'%')";
        ResultSet rs = JDBC_Helper.Query(sql, key,key);
        try {
            while(rs.next()){
                lst.add(new MauSac_Model(rs.getString(1), rs.getString(2)));
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
