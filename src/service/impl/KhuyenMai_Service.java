/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KhuyenMai_Model;
import repository.KhuyenMai_repos;
import viewmodel.KhuyenMai_View;
import service.IKhuyenMai_Service;
import repository.IKhuyenMai_repo;

/**
 *
 * @author phamtuananh
 */
public class KhuyenMai_Service implements IKhuyenMai_Service{
    IKhuyenMai_repo KM_view = new KhuyenMai_repos();
    List<KhuyenMai_Model> list;
    @Override
    public List<KhuyenMai_View> getAllKhuyenMai(){
        List<KhuyenMai_View> listKM_view  = new ArrayList<>();
        list  = KM_view .getAllKhuyenMai();
        int stt = 1;
        for (KhuyenMai_Model km : list) {
                       listKM_view.add(new KhuyenMai_View(stt, km.getMa(), km.getTen(), km.getGiamGia(), km.getNgayBatDau(), km.getNgayKetThuc()));
                       stt ++;

            
        }
        return listKM_view;
    }

    @Override
    public int add(KhuyenMai_Model km) {
        return KM_view.add(km);
    }

    @Override
    public int delete(KhuyenMai_Model km) {
        return KM_view.delete(km);
    }

    @Override
    public int update(KhuyenMai_Model km) {
        return KM_view.update(km);
    }
    
    
}
