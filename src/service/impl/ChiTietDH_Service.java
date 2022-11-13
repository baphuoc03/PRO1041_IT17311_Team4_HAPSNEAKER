/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ChiTietDH_model;
import repository.ChiTietDH_repos;
import repository.IChiTietDH_repos;
import service.IChiTietDH_Service;
import viewmodel.ChiTietDH_View;

/**
 *
 * @author baphuoc
 */
public class ChiTietDH_Service implements IChiTietDH_Service{
    IChiTietDH_repos ctDH_repos = new ChiTietDH_repos();
    @Override
    public List<ChiTietDH_View> getChiTietDHByMaDH(String maHD) {
        List<ChiTietDH_model> list = ctDH_repos.getChiTietDHByMaDH(maHD);
        List<ChiTietDH_View> list_view = new ArrayList<>();
        int stt=1;
        for (ChiTietDH_model c : list) {
            float donGia =  c.getSl()*c.getDonGia();
            float tienSauGiam = donGia - donGia*0;
            list_view.add(new ChiTietDH_View(stt,c.getThuocTinh().getSanPham().getMa(), c.getThuocTinh().getSanPham().getTen(),c.getThuocTinh().getKichThuoc().getMa(), c.getSl(), c.getDonGia(),donGia, 0, tienSauGiam));
            stt++;
        }
        return list_view;
    }
    
}
