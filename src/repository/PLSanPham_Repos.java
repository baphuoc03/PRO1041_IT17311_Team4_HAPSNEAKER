/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.PhanLoai_Model;
import model.PlSp_Model;
import model.SanPham_Model;
import ultinities.JDBC_Helper;
import java.sql.*;

/**
 *
 * @author baphuoc
 */
    public class PLSanPham_Repos implements IPLSanPham{
    public List<PlSp_Model> getByMa(String ma) {
        List<PlSp_Model> lst = new ArrayList<>();
        String sql = "SELECT * FROM pl_sp where MaSP = ?";
        ResultSet rs = JDBC_Helper.Query(sql,ma);
        try {
            while (rs.next()) {
                PhanLoai_Model pl = new PhanLoai_Model(rs.getString(1), null);
                SanPham_Model sp = new SanPham_Model(rs.getString(2), null, null, null,null, 0, 0, 0);
                lst.add(new PlSp_Model(pl, sp));
            }
            return lst;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(PlSp_Model p){
        String sql = "insert into pl_sp(MaPhanLoai,MaSP) values(?,?)";
        return JDBC_Helper.Update(sql, p.getPhanLoai().getMa(),p.getSanPham().getMa());
    }

    @Override
    public int delete(String maSP){
        String sql = "delete from pl_sp where MaSP = ?";
        return  JDBC_Helper.Update(sql, maSP);
    }

}
