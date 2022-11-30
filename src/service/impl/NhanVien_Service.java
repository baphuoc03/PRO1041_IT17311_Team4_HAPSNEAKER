/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien_Model;
import repository.INhanVien_Repos;
import repository.NhanVien_Repos;
import service.INhanVien_Service;
import viewmodel.NhanVien_View;

/**
 *
 * @author admin
 */
public class NhanVien_Service implements INhanVien_Service{
    INhanVien_Repos nv = new NhanVien_Repos();
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
    public List<NhanVien_View> getNVbyCV(String maCV) {
       List<NhanVien_View> list_view = new ArrayList<>();
       list = nv.getNVbyCV(maCV);
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
    public int addNV(NhanVien_Model nv) {
         return this.nv.addNV(nv);
    }

    @Override
    public int delNV(String manv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateNV(NhanVien_Model nv) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhanVien_View> FindNhanVien(String keyWord) {
            List<NhanVien_View> list_view = new ArrayList<>();
            list = nv.FindNhanVien(keyWord);
            for(NhanVien_Model n : list){
               list_view.add(new NhanVien_View(n.getMa(), n.getHoTen(), n.getGioiTinh(), n.getNgaySinh(), n.getSđt(), n.getDiaChi(), n.getPassWord(), n.getChucVu()));
            }
        return list_view;
    }
    

}
