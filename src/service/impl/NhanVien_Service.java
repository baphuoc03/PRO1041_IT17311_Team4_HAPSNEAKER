/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien_Model;
import repository.NhanVien_Repos;
import viewmodel.NhanVien_View;
import service.INhanVien_Service;
import repository.INhanVien_Repo;

/**
 *
 * @author admin
 */
public class NhanVien_Service implements INhanVien_Service{
    INhanVien_Repo nv = new NhanVien_Repos();
    List<NhanVien_Model> list;

    @Override
    public List<NhanVien_View> getAllNhanVien() {
       List<NhanVien_View> list_view = new ArrayList<>();
       list = nv.getAllNhanVien();
       for(NhanVien_Model n : list){
           list_view.add(new NhanVien_View(n.getMa(), n.getHoTen(), n.getGioiTinh(), n.getNgaySinh(), n.getSđt(), n.getDiaChi(), n.getPassWord(), n.getChucVu()));
       }
       return list_view;
    }

    @Override
    public NhanVien_Model getByMa(String ma) {
        return nv.getByMa(ma);
    }

    @Override
    public NhanVien_Model LoginNhanVien(String ma, String pass) {
        return nv.LoginNhanVien(ma, pass);
    }
    
    
}
