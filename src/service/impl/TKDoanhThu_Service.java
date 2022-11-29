/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.TKDoanhThu_Model;
import repository.TKDoanhThu_repos;
import viewmodel.TKDoanhThu_View;
import service.ITKDoanhThu_service;
import repository.ITKDoanhThu_repo;

/**
 *
 * @author baphuoc
 */
public class TKDoanhThu_Service implements ITKDoanhThu_service {

    ITKDoanhThu_repo TK_repos = new TKDoanhThu_repos();
    List<TKDoanhThu_Model> list;

    @Override
    public List<TKDoanhThu_View> getTKDoanhThu() {
        List<TKDoanhThu_View> list_view = new ArrayList<>();
        list = TK_repos.getTKDoanhThu();
        for (TKDoanhThu_Model tK : list) {
            list_view.add(new TKDoanhThu_View(tK.getThang(), tK.getSlSanPham(), tK.getTongGiaBan(), tK.getTongGiaGia(), tK.getTongDoanhThu()));
        }
        return list_view;
        
    }

}
