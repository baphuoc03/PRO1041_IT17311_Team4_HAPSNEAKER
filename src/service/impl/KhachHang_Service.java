/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KhachHang_Model;
import repository.IKhachHang_repos;
import repository.Khachhang_Repos;
import service.IKhachHang_Service;
import viewmodel.KhachHang_View;

/**
 *
 * @author admin
 */
public class KhachHang_Service implements IKhachHang_Service{
    IKhachHang_repos kh = new Khachhang_Repos();
    List<KhachHang_Model> list;

    @Override
    public List<KhachHang_View> getAllKhachHang() {
        List<KhachHang_View> list_view = new ArrayList<>();
        list = kh.getAllKhachHang();
        for(KhachHang_Model k : list){
            list_view.add(new KhachHang_View(k.getSđt(),k.getHoTen(), k.getGioiTinh(), k.getNgaySinh(), k.getEmail(), k.getDiaChi()));
        }
        return list_view;
    }

    @Override
    public KhachHang_Model getBySĐT(String SĐT) {
        return kh.getBySĐT(SĐT);
    }
    

}