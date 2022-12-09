/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.TKSanPham_Model;
import repository.TKSanPham_repos;
import viewmodel.TKSanPham_View;
import repository.ITKSanPham_repos;
import service.ITKSanPham_Service;

/**
 *
 * @author baphuoc
 */
public class TKSanPham_Service implements ITKSanPham_Service{
    ITKSanPham_repos repo = new TKSanPham_repos();
    List<TKSanPham_Model> list = new ArrayList<>();
    @Override
    public List<TKSanPham_View> getTKSanPham() {
        list =repo.getTKSanPham();
        List<TKSanPham_View> list_view = new ArrayList<>();
        int stt = 1;
        for (TKSanPham_Model t : list) {
            list_view.add(new TKSanPham_View(stt, t.getMaSP(), t.getTen(),t.getMau(), t.getThuongHieu(),t.getSlBan()));
            stt++;
        }
        return list_view;
    }

    @Override
    public List<TKSanPham_View> getTKSanPham(String batDau, String ketThuc) {
       list =repo.getTKSanPhamTheoNgay(batDau, ketThuc);
        List<TKSanPham_View> list_view = new ArrayList<>();
        int stt = 1;
        for (TKSanPham_Model t : list) {
            list_view.add(new TKSanPham_View(stt, t.getMaSP(), t.getTen(),t.getMau(), t.getThuongHieu(),t.getSlBan()));
            stt++;
        }
        return list_view; 
    }
    
}
